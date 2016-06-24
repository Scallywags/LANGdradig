import AST
import Generator

ast :: Prog
ast =  Prog (DeclShared "a" (IntType):Expr (Ass "a" ((Int 2134325))):Expr (Ass "a" ((Int 12344))):[])

main :: IO ()
main = writeFile "Concurrencytest0.spril.hs" text where
    text =  
            "import HardwareTypes\nimport Simulation\n\n" ++
            "prog :: [Instruction]\n" ++
            "prog = " ++ show instructions ++ "\n\n" ++ --TODO also add optimizer
            "main :: IO ()\n" ++ 
            "main = sysTest $ replicate " ++ show (length (t_ids state) + 1) ++ " prog"
            	where
            		(instructions, state) = generate ast
