{-# LANGUAGE TypeSynonymInstances, FlexibleInstances, DeriveAnyClass #-}

module Generator where

import AST
import HardwareTypes
import BasicFunctions

type Offset         = Int
type Entry          = (String, Type, Offset)
type Scope          = [Entry]
type SymbolTable    = ([Scope], Offset)

offset :: [Scope] -> String -> Offset
offset [] identifier                            = -1
offset ([]:scopes) identifier                   = offset scopes identifier
offset (((i, t, o):entries):scopes) identifier  | i == identifier   = o
                                                | otherwise         = offset (entries:scopes) identifier

regOut1 :: Int
regOut1 = regE

regOut2 :: Int
regOut2 = regD

regOut3 :: Int
regOut3 = regC

regOut4 :: Int
regOut4 = regB

regOut5 :: Int
regOut5 = regA

generate :: Prog -> [Instruction]
generate p@(Prog cores stmnts) = instructions
    where (instructions, table, sharedTable) = gen p ([], 1) ([], cores)

class CodeGen c where
    --gen subtree -> localmem table -> sharedmem table -> (instructions, new localmem table, new sharedmemtable)
    gen :: c -> SymbolTable -> SymbolTable -> ([Instruction], SymbolTable, SymbolTable)

type Stats = [Stat]

instance CodeGen Stats where
    gen []              table   sharedTable     = ([], table, sharedTable)
    gen (stat:stats)    table   sharedTable     = (statInstrs ++ restInstrs, restTable, restSharedTable) where
        (statInstrs, statTable, statSharedTable) = gen stat table sharedTable
        (restInstrs, restTable, restSharedTable) = gen stats statTable statSharedTable

instance CodeGen Prog where
    gen (Prog _ stats) (scopes, offset) (sharedScopes, sharedOffsets) = (statInstrs ++ [EndProg], restTable, restSharedTable)
        where (statInstrs, restTable, restSharedTable) = gen stats ([]:scopes, offset) ([]:sharedScopes, sharedOffsets)

instance CodeGen Stat where
    --DeclStat
    gen (Decl varName varType) (x:xs, offset) sharedTable   = (code, table, sharedTable) where        
        size = case varType of
            IntType     -> 1
            BoolType    -> 1
            ArrayType len _ -> len + 1
        table       = (((varName, varType, offset):x):xs, offset + size)
        code        = case varType of
            IntType                 ->  [Store reg0 (DirAddr offset)]    --default value for Int is 0
            BoolType                ->  [Store reg0 (DirAddr offset)]    --default value for Bool is 0
            ArrayType len elemType  ->  [Load (ImmValue len) regOut1, Store regOut1 (DirAddr offset)] ++
                                        [Store reg0 (DirAddr dirAddr) | dirAddr <- [offset+1..offset+len+1]]
                                        --default value for arrays is all zeros. fix in case the elements are arrays themselves

    --BlockStat
    gen (Block stats) (scopes, offset) sharedTable          = (statIntrs, (scopes, newOffset), restSharedTable) --we only need to pop the first element so we can reuse 'scopes'.
        where (statIntrs, (_, newOffset), restSharedTable) = gen stats ([]:scopes, offset) sharedTable--opens a new scope for the stats. will not be reused after the blockstat.

    --ExprStat
    gen (Expr expr) table sharedTable                       = gen expr table sharedTable

    --IfThenStat
    gen (IfThen expr stat) table sharedTable                = (code, restTable, restSharedTable) where
        invertedExpr = case expr of                             -- small optimization
            UnOp Not e -> e
            _ -> UnOp Not expr
        (exprInstrs, exprTable, exprSharedTable) = gen invertedExpr table sharedTable        -- only jump if expression is false
        (statInstrs, restTable, restSharedTable) = gen stat exprTable exprSharedTable
        code = exprInstrs ++ [Branch regOut1 (Rel (length statInstrs + 1))] ++ statInstrs

    --IfThenElseStat
    gen (IfThenElse expr stat1 stat2) table sharedTable     = (code, restTable, restSharedTable) where
        (exprInstrs, exprTable, exprSharedTable)     = gen expr table sharedTable
        (stat1Instrs, stat1Table, stat1SharedTable)   = gen stat1 exprTable exprSharedTable
        (stat2Instrs, restTable, restSharedTable)    = gen stat2 stat1Table stat1SharedTable
        code =  exprInstrs ++ [Branch regOut1 (Rel (length stat2Instrs + 2))] ++
                stat2Instrs ++ [Jump $ Rel (length stat1Instrs+1)] ++ stat1Instrs   --if not expr stat2 else stat1

    --WhileStat
    gen (While expr stat) table sharedTable                 = (code, restTable, sharedRestTable) where
        invertedExpr = case expr of                      -- small optimization
            UnOp Not e -> e
            _ -> UnOp Not expr
        (exprInstrs, exprTable, sharedExprTable) = gen invertedExpr table sharedTable-- jump past while if and only if expression is false.
        (statInstrs, restTable, sharedRestTable) = gen stat exprTable sharedExprTable
        code = exprInstrs ++ [Branch regOut1 (Rel (length statInstrs + 2))] ++ statInstrs ++ [Jump (Rel $ -(length exprInstrs + length statInstrs + 1))]

    --DeclShared
    gen (DeclShared varName varType) table (x:xs, offset)   = (code, table, sharedTable) where        
        size = case varType of
            IntType     -> 1
            BoolType    -> 1
            ArrayType len _ -> len + 1

        sharedTable       = (((varName, varType, offset):x):xs, offset + size)

        code        = case varType of
            IntType                 ->  [WriteInstr reg0 (DirAddr offset)]    --default value for Int is 0
            BoolType                ->  [WriteInstr reg0 (DirAddr offset)]    --default value for Bool is 0
            ArrayType len elemType  ->  [Load (ImmValue len) regOut1, WriteInstr regOut1 (DirAddr offset)] ++
                                        [WriteInstr reg0 (DirAddr dirAddr) | dirAddr <- [offset+1..offset+len+1]]
                                        --default value for arrays is all zeros. fix in case the elements are arrays themselves
    --ForkStat    
    gen (Fork spr_id stat) table (sharedScopes, sharedOffset) = (code, restTable, (sharedScopes, newSharedOffset)) where
        (statInstrs, restTable, (_, newSharedOffset)) = gen stat table ([]:sharedScopes, sharedOffset)
        forkInstrs =    [Load (ImmValue spr_id) regOut1, Compute NEq regOut1 regSprID regOut1, Branch regOut1 (Rel (length statInstrs + 2))]
        code = forkInstrs ++ statInstrs ++ [EndProg] --TODO spin and wait for join?

    --gen (Join thread_id) table       --TODO
    --gen (Sync lock stat) table       --TODO

instance CodeGen Expr where
    -- ParExpr
    gen (Par expr) table sharedTable                    = gen expr table sharedTable

    -- BoolExpr
    gen (Bool bool) table sharedTable                   = ([Load (ImmValue $ intBool bool) regOut1], table, sharedTable)

    -- IdfExpr
    gen (Idf string) table sharedTable                 = (code, table, sharedTable) where
        localAddr = offset (fst table) string
        sharedAddr = offset (fst sharedTable) string
        code    | localAddr /= -1         = [Load (DirAddr localAddr) regOut1]
                | otherwise             = [ReadInstr (DirAddr sharedAddr), Receive regOut1]

    -- IntExpr
    gen (Int int) table sharedTable                     = ([Load (ImmValue int) regOut1], table, sharedTable)
    
    -- UnOpExpr
    gen (UnOp op expr) table sharedTable               = (exprInstrs ++ unopInstrs, restTable, sharedRestTable) where
        (exprInstrs, exprTable, sharedExprTable) = gen expr table sharedTable
        (unopInstrs, restTable, sharedRestTable) = gen op exprTable sharedExprTable

    -- BinOpExpr
    gen (BinOp op expr1 expr2) table sharedTable        = (code, restTable, sharedRestTable) where
        (expr1Instrs, expr1Table, sharedExpr1Table)   = gen expr1 table sharedTable
        (expr2Instrs, expr2Table, sharedExpr2Table)   = gen expr2 expr1Table sharedExpr1Table
        (opInstrs, restTable, sharedRestTable)        = gen op expr2Table sharedExpr2Table
        code = expr1Instrs ++ [Push regOut1] ++ expr2Instrs ++ [Pop regOut2] ++ opInstrs

    -- TrinOpExpr
    gen (TrinOp op expr lower upper) table sharedTable  = (code, restTable, sharedRestTable) where
        (exprInstrs, exprTable, sharedExprTable)        = gen expr table sharedTable
        (lowerInstrs, lowerTable, sharedLowerTable)     = gen lower exprTable sharedExprTable
        (upperInstrs, upperTable, sharedUpperTable)     = gen upper lowerTable sharedLowerTable
        (opInstrs, restTable, sharedRestTable)          = gen op upperTable sharedUpperTable
        code = exprInstrs ++ [Push regOut1] ++ lowerInstrs ++ [Push regOut1] ++ upperInstrs ++ [Pop regOut3, Pop regOut2] ++ opInstrs

    -- CrementExpr
    gen (Crem crem string) table sharedTable        = (code, crementTable, sharedCrementTable) where
        localAddr = offset (fst table) string
        sharedAddr = offset (fst sharedTable) string

        (crementInstrs, crementTable, sharedCrementTable)   = gen crem table sharedTable

        code    | localAddr /= -1   =   [Load (DirAddr localAddr) regOut1] ++ crementInstrs ++ [Store regOut1 (DirAddr localAddr)]
                | otherwise         =   [ReadInstr (DirAddr sharedAddr), Receive regOut1] ++ crementInstrs ++ [WriteInstr regOut1 (DirAddr sharedAddr)]
                                        --TODO add loop that spins until value is written successfully?

    -- AssignExpr
    gen (Ass string expr) table sharedTable                 = (code, restTable, restSharedTable) where
        (exprCode, restTable, restSharedTable)   = gen expr table sharedTable
        localAddr = offset (fst restTable) string
        sharedAddr = offset (fst restSharedTable) string

        code    | localAddr /= -1   = exprCode ++ [Store regOut1 (DirAddr localAddr)]
                | otherwise         = exprCode ++ [WriteInstr regOut1 (DirAddr sharedAddr)]

        --TODO make this work correctly for arrays; there is no array expression yet... xD

instance CodeGen UnOp where
    -- NegExpr
    gen Neg table sharedTable   = ([Load (ImmValue (-1)) regOut2, Compute Mul regOut1 regOut2 regOut1], table, sharedTable)

    -- NotExpr
    gen Not table sharedTable  = ([Load (ImmValue $ intBool True) regOut2, Compute Xor regOut1 regOut2 regOut1], table, sharedTable)

instance CodeGen BinOp where
    -- Plus
    gen Plus table sharedTable              = ([Compute Add regOut2 regOut1 regOut1], table, sharedTable)

    -- Minus
    gen Minus table sharedTable             = ([Compute Sub regOut2 regOut1 regOut1], table, sharedTable)

    -- Times
    gen Times table sharedTable             = ([Compute Mul regOut2 regOut1 regOut1], table, sharedTable)

    -- Divide
    gen Divide table sharedTable            = ([Compute Div regOut2 regOut1 regOut1], table, sharedTable)

    -- Modulo
    gen Modulo table sharedTable            = ([Compute Mod regOut2 regOut1 regOut1], table, sharedTable)

    -- Power
    gen Power table sharedTable             = ([Compute Pow regOut2 regOut1 regOut1], table, sharedTable)

    -- LessThan
    gen LessThan table sharedTable          = ([Compute Lt regOut2 regOut1 regOut1], table, sharedTable)

    -- LessThanEq
    gen LessThanEq table sharedTable        = ([Compute LtE regOut2 regOut1 regOut1], table, sharedTable)

    -- GreaterThan
    gen GreaterThan table sharedTable       = ([Compute Gt regOut2 regOut1 regOut1], table, sharedTable)

    -- GreaterThanEq
    gen GreaterThanEq table sharedTable     = ([Compute GtE regOut2 regOut1 regOut1], table, sharedTable)

    -- Equal
    gen Equal table sharedTable             = ([Compute Equ regOut2 regOut1 regOut1], table, sharedTable)

    -- NotEqual
    gen NotEqual table sharedTable          = ([Compute NEq regOut2 regOut1 regOut1], table, sharedTable)

    -- And
    gen LogicAnd table sharedTable          = ([Compute And regOut2 regOut1 regOut1], table, sharedTable)

    -- Or
    gen LogicOr table sharedTable           = ([Compute Or regOut2 regOut1 regOut1], table, sharedTable)

instance CodeGen TrinOp where
    -- Between (regOut3 < regOut2 < regOut1) ----> (regOut3 < regOut2 && regOut2 < regOut1)
    gen Between table sharedTable       = (code, table, sharedTable) where
        code = [Compute Lt regOut3 regOut2 regOut4, Compute Lt regOut2 regOut1 regOut5, Compute And regOut4 regOut5 regOut1]

    -- Inside (regOut3 <= regOut2 <= regOut1) ----> (regOut3 <= regOut2 && regOut2 <= regOut1)
    gen Inside table sharedTable        = (code, table, sharedTable) where
        code = [Compute LtE regOut3 regOut2 regOut4, Compute LtE regOut2 regOut1 regOut5, Compute And regOut4 regOut5 regOut1]

    -- Outside (regOut2 < regOut3 || regOut2 > regOut1)
    gen Outside table sharedTable       = (code, table, sharedTable) where
        code = [Compute Lt regOut2 regOut3 regOut4, Compute Gt regOut2 regOut1 regOut5, Compute Or regOut4 regOut5 regOut1]

instance CodeGen Crem where
    -- Increment
    gen Increm table sharedTable        = ([Compute Incr regOut1 reg0 regOut1], table, sharedTable)

    -- Decrement
    gen Decrem table sharedTable        = ([Compute Decr regOut1 reg0 regOut1], table, sharedTable)