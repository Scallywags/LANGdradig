import HardwareTypes
import Simulation

prog :: [Instruction]
prog = 	[Compute Equ 0 1 6
		,Branch 6 (Rel 6)
		,WriteInstr 0 (IndAddr 1)
		,ReadInstr (IndAddr 1)
		,Receive 6
		,Branch 6 (Ind 6)
		,Jump (Rel (-3))
		,TestAndSet (DirAddr 0) 			--main start fork
		,Receive 6
		,Compute Equ 6 0 6
		,Branch 6 (Rel (-3))
		,Load (ImmValue 6) 6
		,WriteInstr 6 (DirAddr 0)			--fork
		,WriteInstr 0 (IndAddr 1)
		,ReadInstr (IndAddr 1)
		,Receive 6
		,Branch 6 (Ind 6)
		,Jump (Rel (-3))
		,ReadInstr (DirAddr 0)
		,Receive 6
		,Branch 6 (Rel (-3))
		,Load (ImmValue 24) 6
		,WriteInstr 6 (DirAddr 1)
		,EndProg
		]

main :: IO ()
main = sysTest $ replicate 2 prog