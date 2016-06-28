import AST
import Generator

ast :: Prog
ast =  Prog (DeclShared "a" (IntType):DeclShared "b" (IntType):Fork "x" (Expr (Ass "a" ((Int 8))):Expr (Ass "b" ((Int 10))):[]):Join "x":Fork "x" (Expr (Ass "a" ((Int 9))):DeclShared "c" (IntType):Fork "test" (Decl "d" (BoolType):Expr (Ass "c" ((Int 13))):Expr (Ass "b" ((Int 8))):[]):Join "test":[]):Join "x":Print ((Idf "b")) IntType:[]) 

main :: IO ()
main = writeFile "Concurrencytest2.spril.hs" text where
    text =              "import HardwareTypes\nimport Simulation\n\n" ++
            "prog :: [Instruction]\n" ++
            "prog = " ++ show instructions ++ "\n\n" ++ --TODO also add optimizer
            "main :: IO ()\n" ++ 
            "main = sysTest $ replicate " ++ show (length (t_ids state) + 1) ++ " prog"
                where (instructions, state) = generate ast
