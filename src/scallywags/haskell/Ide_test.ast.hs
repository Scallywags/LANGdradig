import AST
import Generator

ast :: Prog
ast =  Prog (Decl "a" (BoolType):Expr (Ass "a" ((Bool True))):While ((Idf "a")) (Decl "b" (IntType)):Expr (Ass "b" (BinOp Power ((Idf "b")) ((Int 6)))):Block (Block (Block (Decl "b" (IntType):[]):[]):[]):IfThenElse ((Idf "a")) (Block (Expr (Ass "a" ((Bool False))):Expr (Ass "b" (BinOp Plus ((Idf "b")) ((Int 9)))):[])) (Expr (Ass "b" ((Int 8)))):IfThen (BinOp LessThanEq ((Idf "b")) ((Int 8))) (Block ([])):[])

main :: IO ()
main = writeFile "Ide_test.spril.hs" text where
    text =  
            "import HardwareTypes\nimport Simulation\n\n" ++
            "prog :: [Instruction]\n" ++
            "prog = " ++ (show $ generate ast) ++ "\n\n" ++ --TODO also add optimizer
            "main :: IO ()\n" ++ 
            "main = sysTest $ replicate 1 prog"
