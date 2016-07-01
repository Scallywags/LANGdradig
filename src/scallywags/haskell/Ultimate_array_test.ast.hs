import AST
import Generator

ast :: Prog
ast =  Prog (Decl "a" (ArrayType 5 IntType):Decl "b" (ArrayType 5 IntType):Decl "c" (BoolType):Expr (Ass "a" ((Array ((Int 5):(Int 4):(Int 3):(Int 2):(Int 1):[])))):Expr (Ass "b" ((Array ((Int 5):(Int 4):(Int 3):(Int 2):(Int 1):[])))):Expr (Ass "c" (BinOp Equal ((Idf "a")) ((Idf "b")))):Print ((Idf "c")) (BoolType):Expr (Ass "b" ((Array ((Int 5):(Int 4):(Int 3):(Int 2):(Int 5):[])))):Expr (Ass "c" (BinOp Equal ((Idf "a")) ((Idf "b")))):Print ((Idf "c")) (BoolType):Expr (Ass "c" (BinOp NotEqual ((Idf "a")) ((Idf "b")))):Print ((Idf "c")) (BoolType):Expr (Ass "c" (BinOp Equal ((Array ((Int 1):(Int 2):(Int 3):[]))) ((Array ((Int 1):(Int 2):(Int 3):[]))))):Print ((Idf "c")) (BoolType):Expr (Ass "c" (BinOp NotEqual ((Array ((Int 1):(Int 2):(Int 3):[]))) ((Array ((Int 1):(Int 2):(Int 3):[]))))):Print ((Idf "c")) (BoolType):Expr (Ass "c" (BinOp Equal ((Idf "a")) ((Array ((Int 5):(Int 4):(Int 3):(Int 2):(Int 1):[]))))):Print ((Idf "c")) (BoolType):Expr (Ass "c" (BinOp Equal ((Array ((Int 5):(Int 4):(Int 3):(Int 2):(Int 1):[]))) ((Idf "a")))):Print ((Idf "c")) (BoolType):[]) 

main :: IO ()
main = writeFile "Ultimate_array_test.spril.hs" text where
    text =  "import HardwareTypes\nimport Simulation\n\n" ++
            "prog :: [Instruction]\n" ++
            "prog = " ++ show instructions ++ "\n\n" ++ --RIP no optimizer :(
            "main :: IO ()\n" ++ 
            "main = sysRun $ replicate " ++ show (length (t_ids state) + 1) ++ " prog"
                where (instructions, state) = generate ast
