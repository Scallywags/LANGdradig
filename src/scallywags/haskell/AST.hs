{-# LANGUAGE FlexibleInstances, DeriveGeneric, DeriveAnyClass #-}

module AST where

import GHC.Generics
import FPPrac.Trees
import HardwareTypes

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
            | Idf MemAddr
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
            | Array Type
            deriving (Show, Eq, Read, Generic, ToRoseTree)

class CodeGen c where
      gen :: c -> [Instruction]

instance CodeGen Prog where
      gen (Prog statements)               = concatMap gen statements

instance CodeGen Stat where
      gen (Decl varName varType)          = [] --TODO
      gen (Block stats)                   = concatMapgen stats
      gen (Expr expr)                     = gen expression
      gen (IfThen expr stat)              = [] --TODO
      gen (IfThenElse expr stat1 stat2)   = [] --TODO
      gen (While expr stat)               = [] --TODO
      gen (Fork thread_id stat)           = [] --TODO
      gen (Wait thread_id)                = [] --TODO
      gen (Sync lock stat)                = [] --TODO

instance CodeGen Expr where
      gen (Par expr)    = gen expr
      gen (Bool bool)   = []
      gen (Idf string)  = []