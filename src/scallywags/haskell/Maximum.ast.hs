import AST
import Generator

ast :: Prog
ast =  Prog (Decl "arr" (ArrayType 10 IntType):Expr (Ass "arr" ((Array ((Int 4):(Int 9):(Int 7):(Int 8):(Int 3):(Int 5):(Int 1):(Int 2):(Int 10):(Int 6):[])))):Decl "i" (IntType):Expr (Ass "i" ((Int 1))):Decl "max" (IntType):Expr (Ass "max" (Spot "arr" ((Idf "i")))):Decl "temp" (IntType):While (BinOp LessThanEq ((Idf "i")) (Idf "arr")) (Block (Expr (Ass "temp" (Spot "arr" ((Idf "i")))):IfThen (BinOp GreaterThan ((Idf "temp")) ((Idf "max"))) (Expr (Ass "max" ((Idf "temp")))):Expr (Crem Increm "i"):[])):Print ((Idf "max")) IntType:[]) 

main :: IO ()
main = writeFile "Maximum.spril.hs" text where
    text =              "import HardwareTypes\nimport Simulation\n\n" ++
            "prog :: [Instruction]\n" ++
            "prog = " ++ show instructions ++ "\n\n" ++ --TODO also add optimizer
            "main :: IO ()\n" ++ 
            "main = sysRun $ replicate " ++ show (length (t_ids state) + 1) ++ " prog"
                where (instructions, state) = generate ast
