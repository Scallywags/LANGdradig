import AST
import Generator

ast :: Prog
ast =  Prog (DeclShared "i" (IntType):Fork 1 (Block (Sync "locki" (Expr (Ass "i" (BinOp Plus ((Idf "i")) ((Int 1))))):[])):Fork 2 (Block (Sync "locki" (Expr (Ass "i" (BinOp Plus ((Idf "i")) ((Int 1))))):[])):Join 1:Join 2:[]) 3 

main :: IO ()
main = writeFile "Kritiekvoorbeeld.spril.hs" text where
    text =  
            "import HardwareTypes\nimport Simulation\n\n" ++
            "prog :: [Instruction]\n" ++
            "prog = " ++ (show $ generate ast) ++ "\n\n" ++ --TODO also add optimizer
            "main :: IO ()\n" ++ 
            "main = sysTest $ replicate 3 prog"
