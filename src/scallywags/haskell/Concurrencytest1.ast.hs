import AST
import Generator

ast :: Prog
ast =  Prog (DeclShared "a" (IntType):DeclShared "c" (IntType):Fork "x" (Expr (Ass "a" ((Int 1337))):Decl "b" (IntType):Expr (Ass "b" ((Int 2))):Expr (Ass "c" (BinOp Times ((Idf "a")) ((Idf "b")))):[]):Decl "d" (IntType):Join "x":Expr (Ass "d" ((Idf "c"))):Fork "x" (Expr (Ass "a" ((Int 600))):[]):Decl "e" (IntType):Join "x":Expr (Ass "e" (BinOp Plus ((Idf "a")) ((Int 66)))):[]) 

main :: IO ()
main = writeFile "Concurrencytest1.spril.hs" text where
    text =  
            "import HardwareTypes\nimport Simulation\n\n" ++
            "prog :: [Instruction]\n" ++
            "prog = " ++ show instructions ++ "\n\n" ++ --TODO also add optimizer
            "main :: IO ()\n" ++ 
            "main = sysTest $ replicate " ++ show (length (t_ids state) + 1) ++ " prog"
                where
                    (instructions, state) = generate ast
