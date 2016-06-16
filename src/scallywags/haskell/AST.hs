{-# LANGUAGE TypeSynonymInstances, FlexibleInstances, DeriveGeneric, DeriveAnyClass #-}

module AST where

import GHC.Generics
import FPPrac.Trees
import HardwareTypes
import BasicFunctions

data Prog   = Prog [Stat] deriving (Show, Eq, Read, Generic, ToRoseTree)

data Stat   = Decl String Type
            | Block [Stat]
            | Expr Expr
            | IfThen Expr Stat
            | IfThenElse Expr Stat Stat
            | While Expr Stat
            | Fork String Stat
            | Wait String
            | Sync String Stat
            deriving (Show, Eq, Read, Generic, ToRoseTree)

data Expr   = Par Expr
            | Bool Bool
            | Idf String
            | Int Int
            | UnOp UnOp Expr
            | BinOp BinOp Expr Expr
            | TrinOp TrinOp Expr Expr Expr
            | Crem Crem String
            | Ass String Expr
            deriving (Show, Eq, Read, Generic, ToRoseTree)

data Crem   = Incr
            | Decr
            deriving (Show, Eq, Read, Generic, ToRoseTree)

data TrinOp = Between
            | Inside
            | Outside
            deriving (Show, Eq, Read, Generic, ToRoseTree)

data BinOp  = Plus
            | Minus
            | Times
            | Divide
            | Modulo
            | Power
            | LessThan
            | LessThanEq
            | GreaterThan
            | GreaterThanEq
            | Equal
            | NotEqual
            | And
            | Or
            deriving (Show, Eq, Read, Generic, ToRoseTree)

data UnOp   = Neg
            | Not
            deriving (Show, Eq, Read, Generic, ToRoseTree)

data Type   = IntType
            | BoolType
            | Array Int Type
            deriving (Show, Eq, Read, Generic, ToRoseTree)

type Offset         = Int
type Entry          = (String, Type, Offset)
type Scope          = [Entry]
type SymbolTable    = ([Scope], Offset)

offset :: [Scope] -> String -> Maybe Offset
offset [] identifier                            = Nothing
offset ([]:scopes) identifier                   = offset scopes identifier
offset (((i, t, o):entries):scopes) identifier  | i == identifier   = Just o
                                                | otherwise         = offset (entries:scopes) identifier

generate :: Prog -> [Instruction]
generate p = fst $ gen p ([], 0)

class CodeGen c where
    gen :: c -> SymbolTable -> ([Instruction], SymbolTable)

type Stats = [Stat]

instance CodeGen Stats where
    gen []              table   = ([], table)
    gen (stat:stats)    table   = (statInstrs ++ restInstrs, restTable) where
        (statInstrs, statTable) = gen stat table
        (restInstrs, restTable) = gen stats statTable

instance CodeGen Prog where
    gen (Prog stats) (scopes, offset) = (statInstrs ++ [EndProg], restTable) --TODO set initial memory values such as True and False :-)
        where (statInstrs, restTable) = gen stats ([]:scopes, offset)

regOut :: Int --TODO remove this, use STACK instead
regOut = regE

instance CodeGen Stat where
    --DeclStat
    gen (Decl varName varType) (x:xs, offset)   = (code, table) where
        code        = [] --TODO load default value.
        
        size = case varType of
            IntType     -> 1
            BoolType    -> 1
            Array len _ -> len + 1

        table       = (((varName, varType, offset):x):xs, offset + size)

    --BlockStat
    gen (Block stats) (scopes, offset)          = (statIntrs, (scopes, newOffset)) --we only need to pop the first element so we can reuse 'scopes'.
        where (statIntrs, (_, newOffset)) = gen stats ([]:scopes, offset) --opens a new scope for the stats. will not be reused after the blockstat.

    --ExprStat
    gen (Expr expr) table                       = gen expr table

    --IfThenStat
    gen (IfThen expr stat) table                = (code, restTable) where
        (exprInstrs, exprTable) = gen (UnOp Not expr) table -- skip if and only if expression is false.
        (statInstrs, restTable) = gen stat exprTable
        code = exprInstrs ++ [Branch regOut (Rel $ length statInstrs)] ++ statInstrs

    --IfThenElseStat
    gen (IfThenElse expr stat1 stat2) table     = (code, restTable) where
        (exprInstrs, exprTable)     = gen expr table
        (stat1Instrs, stat1Table)    = gen stat1 exprTable
        (stat2Instrs, restTable)    = gen stat1 stat1Table
        code =  exprInstrs ++ [Branch regOut (Rel (length stat2Instrs + 1))] ++
                stat2Instrs ++ [Jump $ Rel $ length stat1Instrs] ++ stat1Instrs

    --WhileStat
    gen (While expr stat) table     = (code, restTable) where
        (exprInstrs, exprTable) = gen expr table
        (statIntrs, restTable)  = gen stat table
        code = [] --TODO

    --gen (Fork thread_id stat) table  --TODO
    --gen (Wait thread_id) table       --TODO
    --gen (Sync lock stat) table       --TODO

instance CodeGen Expr where
    -- TODO USE STACK FOR RESULT VALUES
    gen (Par expr) table    = gen expr table
      --gen (Bool bool)   = [] --TODO
      --gen (Idf string)  = [] --TODO
      --TODO other expressions

