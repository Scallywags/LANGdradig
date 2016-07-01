import AST
import Generator

ast :: Prog
ast =  Prog (Decl "c" (ArrayType 3 BoolType):Expr (Ass "c" ((Array (BinOp Equal ((Int 5)) ((Int 3)):(Bool True):(Bool False):[])))):Print ((Idf "c")) (ArrayType 3 BoolType):[]) 

main :: IO ()
main = writeFile "Boolarray.spril.hs" text where
    text =  "import HardwareTypes\nimport Simulation\n\n" ++
            "prog :: [Instruction]\n" ++
            "prog = " ++ show instructions ++ "\n\n" ++ --RIP no optimizer :(
            "main :: IO ()\n" ++ 
            "main = sysRun $ replicate " ++ show (length (t_ids state) + 1) ++ " prog"
                where (instructions, state) = generate ast
