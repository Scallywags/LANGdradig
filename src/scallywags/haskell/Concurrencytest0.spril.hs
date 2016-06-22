import HardwareTypes
import Simulation

prog :: [Instruction]
prog =  [Compute Equ 0 1 6
		,Branch 6 (Rel 6)
		,WriteInstr 0 (IndAddr 1)
		,ReadInstr (IndAddr 1)
		,Receive 6
		,Branch 6 (Ind 6)
		,Jump (Rel (-3)) 				--spin nonmain sprockells
		,ReadInstr (DirAddr 1) 			--main: fork
		,Receive 6
		,Compute Equ 6 0 6
		,Branch 6 (Rel (-3)) 			--try again if no success
		,Load (ImmValue 13) 6 			--program counter is not correct
		,WriteInstr 6 (DirAddr 1)
		,Store 0 (DirAddr 1) 			--a is een getal
		,WriteInstr 0 (IndAddr 1) 		--write 0 and jump to spin
		,ReadInstr (IndAddr 1) 			--spin until waken up again
		,Receive 6
		,Branch 6 (Ind 6)
		,Jump (Rel (-3)) 				--loop back
		,ReadInstr (DirAddr 1)
		,Receive 6
		,Branch 6 (Rel (-3))
		,Load (ImmValue 24) 6
		,WriteInstr 6 (DirAddr 1)
		,EndProg]

main :: IO ()
main = sysTest $ replicate 3 prog