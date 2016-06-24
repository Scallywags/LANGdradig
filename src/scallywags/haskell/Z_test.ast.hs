import AST
import Generator

ast :: Prog
ast =  Prog (Decl "a" (IntType):[]) 1 

main :: IO ()
main = writeFile "Z_test.spril.hs" text where
    text =  
            "import HardwareTypes\nimport Simulation\n\n" ++
            "prog :: [Instruction]\n" ++
            "prog = " ++ (show $ generate ast) ++ "\n\n" ++ --TODO also add optimizer
            "main :: IO ()\n" ++ 
            "main = sysTest $ replicate 1 prog"
