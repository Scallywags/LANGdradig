import AST
import Generator

ast :: Prog
ast =  Prog (Decl "a" (BoolType):Expr (Ass "a" ((Bool True))):Decl "b" (IntType):Expr (Ass "b" (UnOp Neg ((Int 18)))):While ((Bool True)) (Expr (Ass "a" ((Bool False)))):[])

main :: IO ()
main = writeFile "Nieuwbestand.spril.hs" text where
    text =  
            "import HardwareTypes\nimport Simulation\n\n" ++
            "prog :: [Instruction]\n" ++
            "prog = " ++ (show $ generate ast) ++ "\n\n" ++ --TODO also add optimizer
            "main :: IO ()\n" ++ 
            "main = sysTest $ replicate 1 prog"
