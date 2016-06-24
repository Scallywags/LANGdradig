import AST
import Generator

ast :: Prog
ast =  Prog (DeclShared "i" (IntType):Decl "locki" (BoolType):Fork "tx" (Block (Sync "locki" (Expr (Ass "i" (BinOp Plus ((Idf "i")) ((Int 1))))):[])):Fork "ty" (Block (Sync "locki" (Expr (Ass "i" (BinOp Plus ((Idf "i")) ((Int 1))))):[])):Join "tx":Join "ty":[]) 

main :: IO ()
main = writeFile "Kritiekvoorbeeld.spril.hs" text where
    text =  
            "import HardwareTypes\nimport Simulation\n\n" ++
            "prog :: [Instruction]\n" ++
            "prog = " ++ show instructions ++ "\n\n" ++ --TODO also add optimizer
            "main :: IO ()\n" ++ 
            "main = sysTest $ replicate " ++ show (length (t_ids state) + 1) ++ " prog"
                where
                    (instructions, state) = generate ast
