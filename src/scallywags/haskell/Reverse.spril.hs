import HardwareTypes
import Simulation

prog :: [Instruction]
prog = [Compute Equ 0 1 6
		,Branch 6 (Rel 6)
		,WriteInstr 0 (IndAddr 1)
		,ReadInstr (IndAddr 1)
		,Receive 6
		,Branch 6 (Ind 6)
		,Jump (Rel (-3))
		,Store 0 (DirAddr 1)
		,Store 0 (DirAddr 2)
		,Load (ImmValue 6) 6
		,Store 6 (DirAddr 3)
		,Store 0 (DirAddr 4)
		,Store 0 (DirAddr 5)
		,Store 0 (DirAddr 6)
		,Store 0 (DirAddr 7)
		,Store 0 (DirAddr 8)
		,Store 0 (DirAddr 9)
		,Store 0 (DirAddr 10)
		,Load (ImmValue 1) 6
		,Push 6
		,Load (ImmValue 8) 6
		,Pop 5
		,Load (ImmValue 3) 4
		,Compute Add 5 4 3
		,Store 6 (IndAddr 3)
		,Load (ImmValue 2) 6
		,Push 6
		,Load (ImmValue 7) 6
		,Pop 5
		,Load (ImmValue 3) 4
		,Compute Add 5 4 3
		,Store 6 (IndAddr 3)
		,Load (ImmValue 3) 6
		,Push 6
		,Load (ImmValue 6) 6
		,Pop 5
		,Load (ImmValue 3) 4
		,Compute Add 5 4 3
		,Store 6 (IndAddr 3)
		,Load (ImmValue 4) 6
		,Push 6
		,Load (ImmValue 5) 6
		,Pop 5
		,Load (ImmValue 3) 4
		,Compute Add 5 4 3
		,Store 6 (IndAddr 3)
		,Load (ImmValue 5) 6
		,Push 6
		,Load (ImmValue 4) 6
		,Pop 5
		,Load (ImmValue 3) 4
		,Compute Add 5 4 3
		,Store 6 (IndAddr 3)
		,Load (ImmValue 6) 6
		,Push 6
		,Load (ImmValue 3) 6
		,Pop 5
		,Load (ImmValue 3) 4
		,Compute Add 5 4 3
		,Store 6 (IndAddr 3)
		,Store 0 (DirAddr 10)
		,Store 0 (DirAddr 11)
		,Load (DirAddr 3) 6
		,Store 6 (DirAddr 11)
		,Load (DirAddr 1) 6
		,Compute Incr 6 0 6
		,Store 6 (DirAddr 1)
		,Push 6
		,Load (DirAddr 11) 6
		,Push 6
		,Load (ImmValue 2) 6
		,Pop 5
		,Compute Div 5 6 6
		,Pop 5
		,Compute LtE 5 6 6
		,Load (ImmValue 1) 5
		,Compute Xor 6 5 6
		,Branch 6 (Rel 34)
		,Load (DirAddr 11) 6
		,Push 6
		,Load (DirAddr 1) 6
		,Pop 5
		,Compute Sub 5 6 6
		,Push 6
		,Load (ImmValue 1) 6
		,Pop 5
		,Compute Add 5 6 6
		,Store 6 (DirAddr 2)
		,Load (DirAddr 1) 6
		,Load (ImmValue 3) 5
		,Compute Add 6 5 6
		,Load (IndAddr 6) 6
		,Store 6 (DirAddr 10)
		,Load (DirAddr 1) 6
		,Push 6
		,Load (DirAddr 2) 6
		,Load (ImmValue 3) 5
		,Compute Add 6 5 6
		,Load (IndAddr 6) 6
		,Pop 5
		,Load (ImmValue 3) 4
		,Compute Add 5 4 3
		,Store 6 (IndAddr 3)
		,Load (DirAddr 2) 6
		,Push 6
		,Load (DirAddr 10) 6
		,Pop 5
		,Load (ImmValue 3) 4
		,Compute Add 5 4 3
		,Store 6 (IndAddr 3)
		,Jump (Rel (-46))
		,PrintLocalRange (DirAddr 4) 6
		,Load (ImmValue 113) 6
		,EndProg]

main :: IO ()
main = sysRun $ replicate 1 prog