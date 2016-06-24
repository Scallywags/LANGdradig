import AST
import Generator

ast :: Prog
ast =  Prog (Decl "i" (IntType):Decl "plafond" (IntType):Expr (Ass "plafond" ((Int 10))):Decl "som" (IntType):While (BinOp LessThanEq ((Idf "i")) ((Idf "plafond"))) (Block (Expr (Ass "som" (BinOp Plus ((Idf "som")) ((Idf "i")))):Expr (Ass "i" (BinOp Plus ((Idf "i")) ((Int 1)))):[])):[]) 

main :: IO ()
main = writeFile "Gauss.spril.hs" text where
    text =  
            "import HardwareTypes\nimport Simulation\n\n" ++
            "prog :: [Instruction]\n" ++
            "prog = " ++ show instructions ++ "\n\n" ++ --TODO also add optimizer
            "main :: IO ()\n" ++ 
            "main = sysTest $ replicate " ++ show (length (t_ids state) + 1) ++ " prog"
                where
                    (instructions, state) = generate ast
