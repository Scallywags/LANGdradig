import AST
import Generator

ast :: Prog
ast =  Prog 2 (Fork 1 (Block (Decl "a" (IntType):Expr (Ass "a" ((Int 1337))):[])):Join 1:[])

main :: IO ()
main = writeFile "Concurrencytest0.spril.hs" text where
    text =  
            "import HardwareTypes\nimport Simulation\n\n" ++
            "prog :: [Instruction]\n" ++
            "prog = " ++ (show $ generate ast) ++ "\n\n" ++ --TODO also add optimizer
            "main :: IO ()\n" ++ 
            "main = sysTest $ replicate 2 prog"
