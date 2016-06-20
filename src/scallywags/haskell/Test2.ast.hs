import AST
import Generator

ast :: Prog
ast =  Prog (Decl "a" (IntType):Decl "b" (BoolType):Decl "c" (IntType):While (BinOp LessThAnEq ((Idf "a")( ((Int 8))) (Expr (Ass "c" (BinOp Power ((Idf "c")( ((Int 6))))):[])

main :: IO ()
main = writeFile "Test2.spril.hs" text where
    text =  
            "import HardwareTypes\nimport Simulation\n\n" ++
            "prog :: [Instruction]\n" ++
            "prog = " ++ (show $ generate ast) ++ "\n\n" ++ --TODO also add optimizer
            "main :: IO ()\n" ++ 
            "main = sysTest $ replicate 1 prog"
