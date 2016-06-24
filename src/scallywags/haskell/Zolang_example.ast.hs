import AST
import Generator

ast :: Prog
ast =  Prog (Decl "b" (IntType):Expr (Ass "b" ((Int 0))):While (BinOp LessThan ((Idf "b")) ((Int 10))) (Expr (Crem Increm "b")):[]) 

main :: IO ()
main = writeFile "Zolang_example.spril.hs" text where
    text =  
            "import HardwareTypes\nimport Simulation\n\n" ++
            "prog :: [Instruction]\n" ++
            "prog = " ++ show instructions ++ "\n\n" ++ --TODO also add optimizer
            "main :: IO ()\n" ++ 
            "main = sysTest $ replicate " ++ show (length (t_ids state) + 1) ++ " prog"
                where
                    (instructions, state) = generate ast
