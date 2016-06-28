import AST
import Generator

ast :: Prog
ast =  Prog (Decl "i" (IntType):Decl "j" (IntType):Decl "arr" (ArrayType 6 IntType):Expr (Ass "arr" ((Array ((Int 8):(Int 7):(Int 6):(Int 5):(Int 4):(Int 3):[])))):Decl "temp" (IntType):Decl "len" (IntType):Expr (Ass "len" (Idf "arr")):While (BinOp LessThanEq (Crem Increm "i") (BinOp Divide ((Idf "len")) ((Int 2)))) (Block (Expr (Ass "j" (BinOp Plus (BinOp Minus ((Idf "len")) ((Idf "i"))) ((Int 1)))):Expr (Ass "temp" (Spot "arr" ((Idf "i")))):Expr (SpotAss "arr" ((Idf "i")) (Spot "arr" ((Idf "j")))):Expr (SpotAss "arr" ((Idf "j")) ((Idf "temp"))):[])):Print ((Idf "arr")) (ArrayType 6 IntType):[]) 

main :: IO ()
main = writeFile "Reverse.spril.hs" text where
    text =  "import HardwareTypes\nimport Simulation\n\n" ++
            "prog :: [Instruction]\n" ++
            "prog = " ++ show instructions ++ "\n\n" ++ --TODO also add optimizer
            "main :: IO ()\n" ++ 
            "main = sysRun $ replicate " ++ show (length (t_ids state) + 1) ++ " prog"
                where (instructions, state) = generate ast
