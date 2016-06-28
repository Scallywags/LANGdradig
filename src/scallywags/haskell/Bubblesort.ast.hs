import AST
import Generator

ast :: Prog
ast =  Prog (Decl "arr" (ArrayType 5 IntType):Expr (Ass "arr" ((Array ((Int 5):(Int 4):(Int 1):(Int 2):(Int 3):[])))):Decl "i" (IntType):Decl "j" (IntType):Decl "temp" (IntType):Decl "len" (IntType):Expr (Ass "len" (Idf "arr")):While (BinOp LessThanEq (Crem Increm "j") ((Idf "len"))) (Block (Expr (Ass "i" ((Int 1))):While (BinOp LessThanEq (Crem Increm "i") (BinOp Plus (BinOp Minus ((Idf "len")) ((Idf "j"))) ((Int 1)))) (Block (IfThen (BinOp GreaterThan (Spot "arr" ((Par (BinOp Minus ((Idf "i")) ((Int 1)))))) (Spot "arr" ((Idf "i")))) (Block (Expr (Ass "temp" (Spot "arr" ((Idf "i")))):Expr (SpotAss "arr" ((Idf "i")) (Spot "arr" ((Par (BinOp Minus ((Idf "i")) ((Int 1))))))):Expr (SpotAss "arr" ((Par (BinOp Minus ((Idf "i")) ((Int 1))))) ((Idf "temp"))):[])):[])):[])):Print ((Idf "arr")) (ArrayType 5 IntType):[]) 

main :: IO ()
main = writeFile "Bubblesort.spril.hs" text where
    text =  "import HardwareTypes\nimport Simulation\n\n" ++
            "prog :: [Instruction]\n" ++
            "prog = " ++ show instructions ++ "\n\n" ++ --TODO also add optimizer
            "main :: IO ()\n" ++ 
            "main = sysRun $ replicate " ++ show (length (t_ids state) + 1) ++ " prog"
                where (instructions, state) = generate ast
