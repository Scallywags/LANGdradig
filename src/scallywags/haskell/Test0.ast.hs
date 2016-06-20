import AST
import Generator

ast :: Prog
ast =  Prog (Decl "intVar" (IntType):Decl "boolVar" (BoolType):Expr (Ass "boolVar" ((Bool True))):IfThenElse (UnOp Not ((Idf "boolVar"))) (Expr (Ass "intVar" ((Int 27)))) (Block (Expr (Ass "intVar" ((Int 31))):Expr (Ass "boolVar" ((Bool True))):[])):[])

main :: IO ()
main = writeFile "Test0.spril.hs" text where
    text =  
            "import HardwareTypes\nimport Simulation\n\n" ++
            "prog :: [Instruction]\n" ++
            "prog = " ++ (show $ generate ast) ++ "\n\n" ++ --TODO also add optimizer
            "main :: IO ()\n" ++ 
            "main = sysTest $ replicate 1 prog"
