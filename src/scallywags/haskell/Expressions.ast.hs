import AST
import Generator

ast :: Prog
ast =  Prog (DeclShared "b" (BoolType):Expr (Ass "b" (BinOp GreaterThan (BinOp Plus ((Int 5)) (BinOp Times ((Int 3)) (BinOp Power ((Int 2)) ((Int 4))))) (BinOp Times ((Par (BinOp Plus ((Int 2)) ((Int 3))))) ((Par (BinOp Plus ((Int 2)) (BinOp Power ((Int 2)) ((Int 3))))))))):IfThenElse (UnOp Not ((Idf "b"))) (Block (Print (BinOp Plus ((Int 5)) (BinOp Times ((Int 3)) (BinOp Power ((Int 2)) ((Int 4))))) (IntType):Print (BinOp Times ((Par (BinOp Plus ((Int 2)) ((Int 3))))) ((Par (BinOp Plus ((Int 2)) (BinOp Power ((Int 2)) ((Int 3))))))) (IntType):[])) (Block (Print (BinOp Times ((Par (BinOp Plus ((Int 2)) ((Int 3))))) ((Par (BinOp Plus ((Int 2)) (BinOp Power ((Int 2)) ((Int 3))))))) (IntType):Print (BinOp Plus ((Int 5)) (BinOp Times ((Int 3)) (BinOp Power ((Int 2)) ((Int 4))))) (IntType):[])):[]) 

main :: IO ()
main = writeFile "Expressions.spril.hs" text where
    text =  "import HardwareTypes\nimport Simulation\n\n" ++
            "prog :: [Instruction]\n" ++
            "prog = " ++ show instructions ++ "\n\n" ++ --RIP no optimizer :(
            "main :: IO ()\n" ++ 
            "main = sysRun $ replicate " ++ show (length (t_ids state) + 1) ++ " prog"
                where (instructions, state) = generate ast
