import AST
import Generator

ast :: Prog
ast =  Prog (Decl "a" (IntType):Fork 1 (Block (Expr (Ass "a" ((Int 8))):Decl "b" (BoolType):Expr (Ass "b" ((Bool False))):Fork 2 (Block (Expr (Ass "b" ((Bool True))):Expr (Ass "a" ((Int 10))):[])):Join 2:[])):Join 1:[]) 3 

main :: IO ()
main = writeFile "Concurrencytest0.spril.hs" text where
    text =  
            "import HardwareTypes\nimport Simulation\n\n" ++
            "prog :: [Instruction]\n" ++
            "prog = " ++ (show $ generate ast) ++ "\n\n" ++ --TODO also add optimizer
            "main :: IO ()\n" ++ 
            "main = sysTest $ replicate 3 prog"
