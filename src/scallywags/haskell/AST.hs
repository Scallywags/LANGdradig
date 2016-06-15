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
            deriving (Show, Eq, Read, Generic, ToRoseTree)
            --TODO fork/join etc.

data Expr   = Prim Prim
            | UnOp UnOp Expr
            | BinOp BinOp Expr Expr
            | Ass String Expr
            deriving (Show, Eq, Read, Generic, ToRoseTree)

data BinOp  = Plus
            | Minus
            | Times
            | Divide
            | Modulo
            | Power
            | LessThen
            | LessThenEq
            | GreaterThen
            | GreaterThenEq
            | Equal
            | NotEqual
            | And
            | Or
            deriving (Show, Eq, Read, Generic, ToRoseTree)

data UnOp   = Min
            | Not
            | Incr
            | Decr
            deriving (Show, Eq, Read, Generic, ToRoseTree)

data Prim   = Par Expr
            | Boolean Bool
            | Idf String
            | Numb Int
            deriving (Show, Eq, Read, Generic, ToRoseTree)

data Type   = IntType
            | BoolType
            deriving (Show, Eq, Read, Generic, ToRoseTree)