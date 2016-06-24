import AST
import Generator

ast :: Prog
ast =  Prog (DeclShared "a" (IntType):Fork "x" (Expr (Ass "a" ((Int 1337))):Expr (Ass "a" (BinOp Times ((Idf "a")) ((Int 2)))):[]):Join "x":Fork "x" (Expr (Ass "a" (BinOp Minus ((Idf "a")) ((Int 1000)))):Expr (Ass "a" (BinOp Minus ((Idf "a")) ((Int 1000)))):[]):Join "x":[]) 

main :: IO ()
main = writeFile "Forktest.spril.hs" text where
    text =  
            "import HardwareTypes\nimport Simulation\n\n" ++
            "prog :: [Instruction]\n" ++
            "prog = " ++ show instructions ++ "\n\n" ++ --TODO also add optimizer
            "main :: IO ()\n" ++ 
            "main = sysTest $ replicate " ++ show (length (t_ids state) + 1) ++ " prog"
                where
                    (instructions, state) = generate ast
