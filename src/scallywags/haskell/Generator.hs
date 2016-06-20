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
generate p = fst $ gen p ([], 1) --WHY CAN'T WE START AT ADDRESS ZERO?!!!

class CodeGen c where
    gen :: c -> SymbolTable -> ([Instruction], SymbolTable)

type Stats = [Stat]

instance CodeGen Stats where
    gen []              table   = ([], table)
    gen (stat:stats)    table   = (statInstrs ++ restInstrs, restTable) where
        (statInstrs, statTable) = gen stat table
        (restInstrs, restTable) = gen stats statTable

instance CodeGen Prog where
    gen (Prog stats) (scopes, offset) = (statInstrs ++ [EndProg], restTable)
        where (statInstrs, restTable) = gen stats ([]:scopes, offset)

instance CodeGen Stat where
    --DeclStat
    gen (Decl varName varType) (x:xs, offset)   = (code, table) where        
        size = case varType of
            IntType     -> 1
            BoolType    -> 1
            ArrayType len _ -> len + 1

        table       = (((varName, varType, offset):x):xs, offset + size)
        code        = case varType of
            IntType                 ->  [Store reg0 (DirAddr offset)]    --default value for Int is 0
            BoolType                ->  [Store reg0 (DirAddr offset)]    --default value for Bool is 0
            ArrayType len elemType  ->  [Load (ImmValue len) regOut1, Store regOut1 (DirAddr offset)] ++
                                        [Store reg0 (DirAddr dirAddr) | dirAddr <- [offset+1..offset+len]]
                                        --default value for arrays is all zeros. fix in case the elements are arrays themselves

    --BlockStat
    gen (Block stats) (scopes, offset)          = (statIntrs, (scopes, newOffset)) --we only need to pop the first element so we can reuse 'scopes'.
        where (statIntrs, (_, newOffset)) = gen stats ([]:scopes, offset) --opens a new scope for the stats. will not be reused after the blockstat.

    --ExprStat
    gen (Expr expr) table                       = gen expr table

    --IfThenStat
    gen (IfThen expr stat) table                = (code, restTable) where
        invertedExpr = case expr of
            UnOp Not e -> e
            _ -> UnOp Not expr
        (exprInstrs, exprTable) = gen invertedExpr table        -- only jump if expression is false
        (statInstrs, restTable) = gen stat exprTable
        code = exprInstrs ++ [Branch regOut1 (Rel (length statInstrs + 1))] ++ statInstrs

    --IfThenElseStat
    gen (IfThenElse expr stat1 stat2) table     = (code, restTable) where
        (exprInstrs, exprTable)     = gen expr table
        (stat1Instrs, stat1Table)   = gen stat1 exprTable
        (stat2Instrs, restTable)    = gen stat2 stat1Table
        code =  exprInstrs ++ [Branch regOut1 (Rel (length stat2Instrs + 2))] ++
                stat2Instrs ++ [Jump $ Rel (length stat1Instrs+1)] ++ stat1Instrs   --if not expr stat2 else stat1

    --WhileStat
    gen (While expr stat) table                 = (code, restTable) where
        invertedExpr = case expr of
            UnOp Not e -> e
            _ -> UnOp Not expr
        (exprInstrs, exprTable) = gen invertedExpr table -- jump past while if and only if expression is false.
        (statInstrs, restTable) = gen stat exprTable
        code = exprInstrs ++ [Branch regOut1 (Rel (length statInstrs + 2))] ++ statInstrs ++ [Jump (Rel $ -(length exprInstrs + length statInstrs + 1))]

    --gen (Fork thread_id stat) table  --TODO
    --gen (Wait thread_id) table       --TODO
    --gen (Sync lock stat) table       --TODO

instance CodeGen Expr where
    -- ParExpr
    gen (Par expr) table                    = gen expr table

    -- BoolExpr
    gen (Bool bool) table                   = ([Load (ImmValue $ intBool bool) regOut1], table)

    -- IdfExpr
    gen (Idf string) table                  = ([Load (DirAddr $ offset (fst table) string) regOut1], table)

    -- IntExpr
    gen (Int int) table                     = ([Load (ImmValue int) regOut1], table)
    
    -- UnOpExpr
    gen (UnOp op expr) table                = (exprInstrs ++ unopInstrs, restTable) where
        (exprInstrs, exprTable) = gen expr table
        (unopInstrs, restTable) = gen op exprTable

    -- BinOpExpr
    gen (BinOp op expr1 expr2) table        = (code, restTable) where
        (expr1Instrs, expr1Table)   = gen expr1 table
        (expr2Instrs, expr2Table)   = gen expr2 expr1Table
        (opInstrs, restTable)       = gen op expr2Table
        code = expr1Instrs ++ [Push regOut1] ++ expr2Instrs ++ [Pop regOut2] ++ opInstrs

    -- TrinOpExpr
    gen (TrinOp op expr lower upper) table  = (code, restTable) where
        (exprInstrs, exprTable)     = gen expr table
        (lowerInstrs, lowerTable)   = gen lower exprTable
        (upperInstrs, upperTable)   = gen upper lowerTable
        (opInstrs, restTable)       = gen op upperTable
        code = exprInstrs ++ [Push regOut1] ++ lowerInstrs ++ [Push regOut1] ++ upperInstrs ++ [Pop regOut3, Pop regOut2] ++ opInstrs

    -- CrementExpr
    gen (Crem crem string) table    = (code, crementTable) where
        dirAddr = offset (fst table) string
        (crementInstrs, crementTable)   = gen crem table
        code = [Load (DirAddr dirAddr) regOut1] ++ crementInstrs ++ [Store regOut1 (DirAddr dirAddr)]

    -- AssignExpr
    gen (Ass string expr) table             = (code, restTable) where
        (exprCode, restTable)   = gen expr table
        dirAddr = offset (fst restTable) string
        code = exprCode ++ [Store regOut1 (DirAddr dirAddr)]

        --TODO make this work correctly for arrays; there is no array expression yet... xD

instance CodeGen UnOp where
    -- NegExpr
    gen Neg table   = ([Load (ImmValue (-1)) regOut2, Compute Mul regOut1 regOut2 regOut1], table)

    -- NotExpr
    gen Not table   = ([Load (ImmValue $ intBool True) regOut2, Compute Xor regOut1 regOut2 regOut1], table)

instance CodeGen BinOp where
    -- Plus
    gen Plus table          = ([Compute Add regOut2 regOut1 regOut1], table)

    -- Minus
    gen Minus table         = ([Compute Sub regOut2 regOut1 regOut1], table)

    -- Times
    gen Times table         = ([Compute Mul regOut2 regOut1 regOut1], table)

    -- Divide
    gen Divide table        = ([Compute Div regOut2 regOut1 regOut1], table)

    -- Modulo
    gen Modulo table        = ([Compute Mod regOut2 regOut1 regOut1], table)

    -- Power
    gen Power table         = ([Compute Pow regOut2 regOut1 regOut1], table)

    -- LessThan
    gen LessThan table      = ([Compute Lt regOut2 regOut1 regOut1], table)

    -- LessThanEq
    gen LessThanEq table    = ([Compute LtE regOut2 regOut1 regOut1], table)

    -- GreaterThan
    gen GreaterThan table   = ([Compute Gt regOut2 regOut1 regOut1], table)

    -- GreaterThanEq
    gen GreaterThanEq table = ([Compute GtE regOut2 regOut1 regOut1], table)

    -- Equal
    gen Equal table         = ([Compute Equ regOut2 regOut1 regOut1], table)

    -- NotEqual
    gen NotEqual table      = ([Compute NEq regOut2 regOut1 regOut1], table)

    -- And
    gen LogicAnd table      = ([Compute And regOut2 regOut1 regOut1], table)

    -- Or
    gen LogicOr table       = ([Compute Or regOut2 regOut1 regOut1], table)

instance CodeGen TrinOp where
    -- Between (regOut3 < regOut2 < regOut1) ----> (regOut3 < regOut2 && regOut2 < regOut1)
    gen Between table       = (code, table) where
        code = [Compute Lt regOut3 regOut2 regOut4, Compute Lt regOut2 regOut1 regOut5, Compute And regOut4 regOut5 regOut1]

    -- Inside (regOut3 <= regOut2 <= regOut1) ----> (regOut3 <= regOut2 && regOut2 <= regOut1)
    gen Inside table        = (code, table) where
        code = [Compute LtE regOut3 regOut2 regOut4, Compute LtE regOut2 regOut1 regOut5, Compute And regOut4 regOut5 regOut1]

    -- Outside (regOut2 < regOut3 || regOut2 > regOut1)
    gen Outside table       = (code, table) where
        code = [Compute Lt regOut2 regOut3 regOut4, Compute Gt regOut2 regOut1 regOut5, Compute Or regOut4 regOut5 regOut1]

instance CodeGen Crem where
    -- Increment
    gen Increm table    = ([Compute Incr regOut1 reg0 regOut1], table)

    -- Decrement
    gen Decrem table    = ([Compute Decr regOut1 reg0 regOut1], table)