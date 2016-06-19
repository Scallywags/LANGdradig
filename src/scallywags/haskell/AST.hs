{-# LANGUAGE FlexibleInstances, DeriveGeneric, DeriveAnyClass #-}

module AST where

import GHC.Generics
import FPPrac.Trees

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
            | Array [Expr]                                      --TODO fix codegen for array cases.
            | UnOp UnOp Expr
            | BinOp BinOp Expr Expr
            | TrinOp TrinOp Expr Expr Expr
            | Crem Crem String
            | Ass String Expr
            deriving (Show, Eq, Read, Generic, ToRoseTree)

data Crem   = Increm
            | Decrem
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
            | LogicAnd
            | LogicOr
            deriving (Show, Eq, Read, Generic, ToRoseTree)

data UnOp   = Neg
            | Not
            deriving (Show, Eq, Read, Generic, ToRoseTree)

data Type   = IntType
            | BoolType
            | ArrayType Int Type
            deriving (Show, Eq, Read, Generic, ToRoseTree)

