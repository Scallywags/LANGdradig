import AST
import Generator

ast :: Prog
ast =  Prog (Decl "a" (IntType):Decl "b" (BoolType):Decl "i" (IntType):Expr (Ass "i" ((Int 20))):While (BinOp GreaterThan ((Idf "i")) ((Int 0))) (Block (Expr (Crem Decrem "i"):Expr (Ass "a" (BinOp Plus (BinOp Times ((Idf "a")) ((Int 3))) ((Int 1)))):Expr (Ass "b" (UnOp Not ((Idf "b")))):Print ((Idf "a")) IntType:Print ((Idf "b")) BoolType:[])):[]) 

main :: IO ()
main = writeFile "Print.spril.hs" text where
    text =  
            "import HardwareTypes\nimport Simulation\n\n" ++
            "prog :: [Instruction]\n" ++
            "prog = " ++ show instructions ++ "\n\n" ++ --TODO also add optimizer
            "main :: IO ()\n" ++ 
            "main = sysRun $ replicate " ++ show (length (t_ids state) + 1) ++ " prog"
                where
                    (instructions, state) = generate ast
