import AST
import Generator

ast :: Prog
ast =  Prog (DeclShared "a" (IntType):Expr (Ass "a" ((Int 8))):While (BinOp LessThanEq ((Idf "a")) ((Int 324))) (Block (Expr (Crem Increm "a"):Print ((Idf "a")) (IntType):[])):[]) 

main :: IO ()
main = writeFile "Break.spril.hs" text where
    text =  "import HardwareTypes\nimport Simulation\n\n" ++
            "prog :: [Instruction]\n" ++
            "prog = " ++ show instructions ++ "\n\n" ++ --RIP no optimizer :(
            "main :: IO ()\n" ++ 
            "main = sysRun $ replicate " ++ show (length (t_ids state) + 1) ++ " prog"
                where (instructions, state) = generate ast
