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
    where (instructions, table, sharedTable, pc) = gen p ([], 1) ([], cores) 0

class CodeGen c where
    --gen subtree -> localmem table -> sharedmem table -> (instructions, new localmem table, new sharedmemtable)
    gen :: c -> SymbolTable -> SymbolTable -> Int -> ([Instruction], SymbolTable, SymbolTable, Int)

type Stats = [Stat]

instance CodeGen Stats where
    gen []              table   sharedTable     pc  = ([], table, sharedTable, pc)
    gen (stat:stats)    table   sharedTable     pc  = (statInstrs ++ restInstrs, restTable, restSharedTable, restPc) where
        (statInstrs, statTable, statSharedTable, statPc) = gen stat table sharedTable pc
        (restInstrs, restTable, restSharedTable, restPc) = gen stats statTable statSharedTable statPc

instance CodeGen Prog where
    gen (Prog numSprockells stats) (scopes, offset) (sharedScopes, sharedOffsets) pc    = (code, restTable, restSharedTable, restPc) where
        (statInstrs, restTable, restSharedTable, statPc) = gen stats ([]:scopes, offset) ([]:sharedScopes, sharedOffsets) (pc + 2 + 5) --length spinChilds + length isId0

        spinChilds = [WriteInstr reg0 (IndAddr regSprID), ReadInstr (IndAddr regSprID), Receive regOut1, Branch regOut1 (Ind regOut1), Jump (Rel (-3))]
        isSprockellID0 = [Compute Equ reg0 regSprID regOut1, Branch regOut1 (Rel (length spinChilds + 1))]
        endprogLocation = length isSprockellID0 + length spinChilds + length statInstrs + 1 + numSprockells - 1
        shutdownOtherThreadsInstr = [Load (ImmValue endprogLocation) regOut1] ++ [WriteInstr regOut1 (DirAddr addr) | addr <- [1..numSprockells - 1]]

        code = isSprockellID0 ++ spinChilds ++ statInstrs ++ shutdownOtherThreadsInstr ++ [EndProg]
        restPc = length isSprockellID0 + length spinChilds + statPc + length shutdownOtherThreadsInstr + 1

instance CodeGen Stat where
    --DeclStat
    gen (Decl varName varType) (x:xs, offset) sharedTable pc  = (code, table, sharedTable, restPc) where        
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
        
        restPc = pc + length code

    --BlockStat
    gen (Block stats) (scopes, offset) sharedTable pc         = (statIntrs, (scopes, newOffset), restSharedTable, newPc) where --we only need to pop the first element so we can reuse 'scopes'.
        (statIntrs, (_, newOffset), restSharedTable, newPc) = gen stats ([]:scopes, offset) sharedTable pc --opens a new scope for the stats. will not be reused after the blockstat.

    --ExprStat
    gen (Expr expr) table sharedTable pc                      = gen expr table sharedTable pc

    --IfThenStat
    gen (IfThen expr stat) table sharedTable pc               = (code, restTable, restSharedTable, restPc) where
        invertedExpr = case expr of                             -- small optimization
            UnOp Not e -> e
            _ -> UnOp Not expr
        (exprInstrs, exprTable, exprSharedTable, exprPc) = gen invertedExpr table sharedTable pc       -- only jump if expression is false
        (statInstrs, restTable, restSharedTable, statPc) = gen stat exprTable exprSharedTable (exprPc + 1)
        code = exprInstrs ++ [Branch regOut1 (Rel (length statInstrs + 1))] ++ statInstrs
        restPc = pc + length code

    --IfThenElseStat
    gen (IfThenElse expr stat1 stat2) table sharedTable pc    = (code, restTable, restSharedTable, restPc) where
        (exprInstrs, exprTable, exprSharedTable, exprPc)     = gen expr table sharedTable pc
        (stat1Instrs, stat1Table, stat1SharedTable, stat1Pc) = gen stat1 exprTable exprSharedTable (stat2Pc + 1)
        (stat2Instrs, restTable, restSharedTable, stat2Pc)   = gen stat2 stat1Table stat1SharedTable (exprPc + 1)
        code =  exprInstrs ++ [Branch regOut1 (Rel (length stat2Instrs + 2))] ++
                stat2Instrs ++ [Jump $ Rel (length stat1Instrs+1)] ++ stat1Instrs   --if not expr stat2 else stat1
        restPc = pc + length code

    --WhileStat
    gen (While expr stat) table sharedTable pc                = (code, restTable, sharedRestTable, restPc) where
        invertedExpr = case expr of                      -- small optimization
            UnOp Not e -> e
            _ -> UnOp Not expr
        (exprInstrs, exprTable, sharedExprTable, exprPc) = gen invertedExpr table sharedTable pc-- jump past while if and only if expression is false.
        (statInstrs, restTable, sharedRestTable, statPc) = gen stat exprTable sharedExprTable (exprPc + 1)
        code = exprInstrs ++ [Branch regOut1 (Rel (length statInstrs + 2))] ++ statInstrs ++ [Jump (Rel $ -(length exprInstrs + length statInstrs + 1))]
        restPc = pc + length code

    --DeclShared
    gen (DeclShared varName varType) table (x:xs, offset) pc  = (code, table, sharedTable, restPc) where        
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
        restPc = pc + length code

    --ForkStat    
    gen (Fork spr_id stat) table (sharedScopes, sharedOffset) pc = (code, restTable, (sharedScopes, newSharedOffset), restPc) where
        jumpPc = pc + 6 --length forkInstrs + length setForkInstrs
        forkInstrs = [Load (ImmValue jumpPc) regOut1, WriteInstr regOut1 (DirAddr spr_id)] --make the other sprockell jump to new programcounter
        setForkInstrs = [TestAndSet (DirAddr spr_id), Receive regOut1, Compute Equ regOut1 reg0 regOut1, Branch regOut1 (Rel (-3))] --TODO use readinstr instead of testandset
        spinInstrs = [WriteInstr reg0 (IndAddr regSprID), ReadInstr (IndAddr regSprID), Receive regOut1, Branch regOut1 (Ind regOut1), Jump (Rel (-3))]
            --TODO jump to initial spin instead of a new one

        (statInstrs, restTable, (_, newSharedOffset), statPc) = gen stat table ([]:sharedScopes, sharedOffset) (pc + length forkInstrs + length setForkInstrs)

        code = setForkInstrs ++ forkInstrs ++ statInstrs ++ spinInstrs
        restPc = pc + length code

    --JoinStat
    gen (Join spr_id) table sharedTable pc = (code, table, sharedTable, pc + 3) where
        code = [ReadInstr (DirAddr spr_id), Receive regOut1, Branch regOut1 (Rel (-3))]

    --gen (Sync lock stat) table       --TODO

instance CodeGen Expr where
    -- ParExpr
    gen (Par expr) table sharedTable pc                   = gen expr table sharedTable pc

    -- BoolExpr
    gen (Bool bool) table sharedTable pc                  = ([Load (ImmValue $ intBool bool) regOut1], table, sharedTable, pc + 1)

    -- IdfExpr
    gen (Idf string) table sharedTable pc                = (code, table, sharedTable, restPc) where
        localAddr = offset (fst table) string
        sharedAddr = offset (fst sharedTable) string
        code    | localAddr /= -1   = [Load (DirAddr localAddr) regOut1]
                | otherwise         = [ReadInstr (DirAddr sharedAddr), Receive regOut1]
        restPc = pc + length code

    -- IntExpr
    gen (Int int) table sharedTable pc                    = ([Load (ImmValue int) regOut1], table, sharedTable, pc + 1)
    
    -- UnOpExpr
    gen (UnOp op expr) table sharedTable pc              = (code, restTable, sharedRestTable, restPc) where
        (exprInstrs, exprTable, sharedExprTable, exprPc) = gen expr table sharedTable pc
        (unopInstrs, restTable, sharedRestTable, unopPc) = gen op exprTable sharedExprTable exprPc
        code = exprInstrs ++ unopInstrs
        restPc = pc + length code

    -- BinOpExpr
    gen (BinOp op expr1 expr2) table sharedTable pc       = (code, restTable, sharedRestTable, restPc) where
        (expr1Instrs, expr1Table, sharedExpr1Table, expr1Pc)   = gen expr1 table sharedTable pc
        (expr2Instrs, expr2Table, sharedExpr2Table, expr2Pc)   = gen expr2 expr1Table sharedExpr1Table (expr1Pc + 1)
        (opInstrs, restTable, sharedRestTable, opPc)           = gen op expr2Table sharedExpr2Table (expr1Pc + 1)
        code = expr1Instrs ++ [Push regOut1] ++ expr2Instrs ++ [Pop regOut2] ++ opInstrs
        restPc = pc + length code

    -- TrinOpExpr
    gen (TrinOp op expr lower upper) table sharedTable pc   = (code, restTable, sharedRestTable, restPc) where
        (exprInstrs, exprTable, sharedExprTable, exprPc)        = gen expr table sharedTable pc
        (lowerInstrs, lowerTable, sharedLowerTable, lowerPc)    = gen lower exprTable sharedExprTable (exprPc + 1)
        (upperInstrs, upperTable, sharedUpperTable, upperPc)    = gen upper lowerTable sharedLowerTable (lowerPc + 1)
        (opInstrs, restTable, sharedRestTable, opPc)            = gen op upperTable sharedUpperTable (upperPc + 2)
        code = exprInstrs ++ [Push regOut1] ++ lowerInstrs ++ [Push regOut1] ++ upperInstrs ++ [Pop regOut3, Pop regOut2] ++ opInstrs
        restPc = pc + length code

    -- CrementExpr
    gen (Crem crem string) table sharedTable pc       = (code, crementTable, sharedCrementTable, restPc) where
        localAddr = offset (fst table) string
        sharedAddr = offset (fst sharedTable) string

        isLocal = localAddr /= -1 

        (crementInstrs, crementTable, sharedCrementTable, cremPc)   = gen crem table sharedTable (if isLocal then pc + 1 else pc + 2)

        code    | isLocal           =   [Load (DirAddr localAddr) regOut1] ++ crementInstrs ++ [Store regOut1 (DirAddr localAddr)]
                | otherwise         =   [ReadInstr (DirAddr sharedAddr), Receive regOut1] ++ crementInstrs ++ [WriteInstr regOut1 (DirAddr sharedAddr)]
                                        --TODO add loop that spins until value is written successfully?
        restPc = pc + length code

    -- AssignExpr
    gen (Ass string expr) table sharedTable pc                = (code, restTable, restSharedTable, restPc) where
        (exprCode, restTable, restSharedTable, exprPc)   = gen expr table sharedTable pc
        localAddr = offset (fst restTable) string
        sharedAddr = offset (fst restSharedTable) string

        code    | localAddr /= -1   = exprCode ++ [Store regOut1 (DirAddr localAddr)]
                | otherwise         = exprCode ++ [WriteInstr regOut1 (DirAddr sharedAddr)]

        restPc = pc + length code

        --TODO make this work correctly for arrays; there is no array expression yet... xD

instance CodeGen UnOp where
    -- NegExpr
    gen Neg table sharedTable pc  = ([Load (ImmValue (-1)) regOut2, Compute Mul regOut1 regOut2 regOut1], table, sharedTable, pc + 2)

    -- NotExpr
    gen Not table sharedTable pc  = ([Load (ImmValue $ intBool True) regOut2, Compute Xor regOut1 regOut2 regOut1], table, sharedTable, pc + 2)

instance CodeGen BinOp where
    -- Plus
    gen Plus table sharedTable pc             = ([Compute Add regOut2 regOut1 regOut1], table, sharedTable, pc + 1)

    -- Minus
    gen Minus table sharedTable pc            = ([Compute Sub regOut2 regOut1 regOut1], table, sharedTable, pc + 1)

    -- Times
    gen Times table sharedTable pc            = ([Compute Mul regOut2 regOut1 regOut1], table, sharedTable, pc + 1)

    -- Divide
    gen Divide table sharedTable pc           = ([Compute Div regOut2 regOut1 regOut1], table, sharedTable, pc + 1)

    -- Modulo
    gen Modulo table sharedTable pc           = ([Compute Mod regOut2 regOut1 regOut1], table, sharedTable, pc + 1)

    -- Power
    gen Power table sharedTable pc            = ([Compute Pow regOut2 regOut1 regOut1], table, sharedTable, pc + 1)

    -- LessThan
    gen LessThan table sharedTable pc         = ([Compute Lt regOut2 regOut1 regOut1], table, sharedTable, pc + 1)

    -- LessThanEq
    gen LessThanEq table sharedTable pc       = ([Compute LtE regOut2 regOut1 regOut1], table, sharedTable, pc + 1)

    -- GreaterThan
    gen GreaterThan table sharedTable pc      = ([Compute Gt regOut2 regOut1 regOut1], table, sharedTable, pc + 1)

    -- GreaterThanEq
    gen GreaterThanEq table sharedTable pc    = ([Compute GtE regOut2 regOut1 regOut1], table, sharedTable, pc + 1)

    -- Equal
    gen Equal table sharedTable pc            = ([Compute Equ regOut2 regOut1 regOut1], table, sharedTable, pc + 1)

    -- NotEqual
    gen NotEqual table sharedTable pc         = ([Compute NEq regOut2 regOut1 regOut1], table, sharedTable, pc + 1)

    -- And
    gen LogicAnd table sharedTable pc         = ([Compute And regOut2 regOut1 regOut1], table, sharedTable, pc + 1)

    -- Or
    gen LogicOr table sharedTable pc          = ([Compute Or regOut2 regOut1 regOut1], table, sharedTable, pc + 1)

instance CodeGen TrinOp where
    -- Between (regOut3 < regOut2 < regOut1) ----> (regOut3 < regOut2 && regOut2 < regOut1)
    gen Between table sharedTable pc      = (code, table, sharedTable, pc + 3) where
        code = [Compute Lt regOut3 regOut2 regOut4, Compute Lt regOut2 regOut1 regOut5, Compute And regOut4 regOut5 regOut1]

    -- Inside (regOut3 <= regOut2 <= regOut1) ----> (regOut3 <= regOut2 && regOut2 <= regOut1)
    gen Inside table sharedTable pc       = (code, table, sharedTable, pc + 3) where
        code = [Compute LtE regOut3 regOut2 regOut4, Compute LtE regOut2 regOut1 regOut5, Compute And regOut4 regOut5 regOut1]

    -- Outside (regOut2 < regOut3 || regOut2 > regOut1)
    gen Outside table sharedTable pc      = (code, table, sharedTable, pc + 3) where
        code = [Compute Lt regOut2 regOut3 regOut4, Compute Gt regOut2 regOut1 regOut5, Compute Or regOut4 regOut5 regOut1]

instance CodeGen Crem where
    -- Increment
    gen Increm table sharedTable pc       = ([Compute Incr regOut1 reg0 regOut1], table, sharedTable, pc + 1)

    -- Decrement
    gen Decrem table sharedTable pc       = ([Compute Decr regOut1 reg0 regOut1], table, sharedTable, pc + 1)