import AST
import Generator

ast :: Prog
ast =  Prog (Decl "a" (ArrayType 3 IntType):Decl "b" (ArrayType 3 IntType):Expr (Ass "a" ((Array ((Int 1):(Int 2):(Int 3):[])))):Expr (Ass "b" ((Array ((Int 1):(Int 2):(Int 3):[])))):Decl "equal" (BoolType):Expr (Ass "equal" ((Bool True))):Decl "i" (IntType):Decl "x" (IntType):Decl "y" (IntType):While (BinOp LogicAnd (BinOp LessThanEq (Crem Increm "i") (Length (Idf "a"))) ((Idf "equal"))) (Block (Expr (Ass "x" (Spot ((Idf "a")) ((Idf "i")))):Expr (Ass "y" (Spot ((Idf "b")) ((Idf "i")))):IfThen (BinOp NotEqual ((Idf "x")) ((Idf "y"))) (Expr (Ass "equal" ((Bool False)))):[])):Print ((Idf "equal")) (BoolType):[]) 

main :: IO ()
main = writeFile "Arrayloop.spril.hs" text where
    text =  "import HardwareTypes\nimport Simulation\n\n" ++
            "prog :: [Instruction]\n" ++
            "prog = " ++ show instructions ++ "\n\n" ++ --RIP no optimizer :(
            "main :: IO ()\n" ++ 
            "main = sysRun $ replicate " ++ show (length (t_ids state) + 1) ++ " prog"
                where (instructions, state) = generate ast
