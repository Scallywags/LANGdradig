module Test0 where

import AST

ast :: Prog
ast =  Prog (Decl "intVar" (IntType):Decl "boolVar" (BoolType):IfThenElse (UnOp Not ((Idf "boolVar"))) (Expr (Ass "intVar" ((Int 3)))) (Block (Expr (Ass "intVar" ((Int 2))):Expr (Ass "boolVar" ((Bool True))):[])):[])