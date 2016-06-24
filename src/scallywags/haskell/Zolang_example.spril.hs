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
		,Load (ImmValue 0) 6
		,Store 6 (DirAddr 1)
		,Load (DirAddr 1) 6
		,Push 6
		,Load (ImmValue 10) 6
		,Pop 5
		,Compute Lt 5 6 6
		,Load (ImmValue 1) 5
		,Compute Xor 6 5 6
		,Branch 6 (Rel 5)
		,Load (DirAddr 1) 6
		,Compute Incr 6 0 6
		,Store 6 (DirAddr 1)
		,Jump (Rel (-11))
		,Load (ImmValue 23) 6
		,EndProg]

main :: IO ()
main = sysTest $ replicate 1 prog