import AST
import Generator

ast :: Prog
ast =  Prog (Decl "lkjlkjkjkj" (BoolType):Decl "b" (BoolType):Decl "a" (IntType):While ((Idf "b")) (Block (Fork "x" (Block (Expr (Ass "a" (BinOp Plus ((Idf "a")) ((Idf "a")))):[])):[])):[])

main :: IO ()
main = writeFile "Test6.spril.hs" text where
    text =  
            "import HardwareTypes\nimport Simulation\n\n" ++
            "prog :: [Instruction]\n" ++
            "prog = " ++ (show $ generate ast) ++ "\n\n" ++ --TODO also add optimizer
            "main :: IO ()\n" ++ 
            "main = sysTest $ replicate 1 prog"
