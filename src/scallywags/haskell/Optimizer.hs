{-# LANGUAGE TypeSynonymInstances, FlexibleInstances #-}

module Optimizer where

import AST

class Optimize a where
    optimize :: a -> a

instance Optimize Expr where
    optimize (UnOp Not (UnOp Not e))    = optimize e
    optimize (UnOp Neg (UnOp Neg e))    = optimize e
    optimize (BinOp op e1 e2)           = BinOp op (optimize e1) (optimize e2)
    optimize (TrinOp op e1 e2 e3)       = TrinOp op (optimize e1) (optimize e2) (optimize e3)
    optimize x                          = x



isPureExpr :: Expr -> SSA -> Bool
isPureExpr expr table = case expr of
    Par e               -> isPureExpr e table
    Bool _              -> True
    Idf s               -> lookup s table /= Nothing
    Int _               -> True
    UnOp _ e            -> isPureExpr e table                               -- all UnOps are actually pure, so no need to check for it
    BinOp _ e1 e2       -> isPureExpr e1 table && isPureExpr e2 table       -- all BinOps are actually pure, so no need to check for it
    TrinOp _ e1 e2 e3   -> isPureExpr e1 table && isPureExpr e2 table && isPureExpr e3 table                    --same story here! :D
    _                   -> False --Crem and Ass are not pure.

type Stats = [Stat]

instance Optimize Stats where




    optimize ss         = ss



type SSA = [(String, Expr)]

--eval :: Expr -> StaticFinals -> Maybe Expr