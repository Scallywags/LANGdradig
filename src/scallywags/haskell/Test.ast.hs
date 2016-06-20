import AST
import Generator

ast :: Prog
ast =  Prog (Decl "a" (IntType):Expr (Ass "a" ((Int 3))):Decl "b" (BoolType):Expr (Ass "b" ((Bool True))):IfThen ((Idf "b")) (Expr (Ass "a" ((Int 5)))):Decl "oke" (IntType):Decl "anouk" (IntType):Expr (Ass "anouk" ((Idf "oke"))):IfThen (BinOp LessThanEq ((Idf "anouk")) ((Int 9))) (Expr (Ass "anouk" ((Int 10)))):Fork "x" (Block (Expr (Ass "a" ((Int 1))):Expr (Ass "a" ((Int 2))):[])):[])

main :: IO ()
main = writeFile "Test.spril.hs" text where
    text =  
            "import HardwareTypes\nimport Simulation\n\n" ++
            "prog :: [Instruction]\n" ++
            "prog = " ++ (show $ generate ast) ++ "\n\n" ++ --TODO also add optimizer
            "main :: IO ()\n" ++ 
            "main = sysTest $ replicate 1 prog"
