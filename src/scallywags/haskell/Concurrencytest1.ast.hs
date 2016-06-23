import AST
import Generator

ast :: Prog
ast =  Prog (DeclShared "a" (IntType):DeclShared "c" (IntType):Fork 1 (Block (Expr (Ass "a" ((Int 1337))):Decl "b" (IntType):Expr (Ass "b" ((Int 2))):Expr (Ass "c" (BinOp Times ((Idf "a")) ((Idf "b")))):[])):Decl "d" (IntType):Join 1:Expr (Ass "d" ((Idf "c"))):Fork 1 (Expr (Ass "a" ((Int 600)))):Decl "e" (IntType):Join 1:Expr (Ass "e" (BinOp Plus ((Idf "a")) ((Int 66)))):[]) 2 

main :: IO ()
main = writeFile "Concurrencytest1.spril.hs" text where
    text =  
            "import HardwareTypes\nimport Simulation\n\n" ++
            "prog :: [Instruction]\n" ++
            "prog = " ++ (show $ generate ast) ++ "\n\n" ++ --TODO also add optimizer
            "main :: IO ()\n" ++ 
            "main = sysTest $ replicate 2 prog"
