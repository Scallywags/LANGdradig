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
		,WriteInstr 0 (DirAddr 0) 		-- i een gedeeld getal WHY ADDRESS ZERO???!!
		,Load (ImmValue 11) 6 			
		,WriteInstr 6 (DirAddr 1) 		--tx mag naar regel 11 (de test and set)
		,Jump (Rel 14)					--main should now skip the paralellised instructions
		,TestAndSet (DirAddr 1) 		--spinlock locki - kritiek
		,Receive 6
		,Compute Equ 6 0 6
		,Branch 6 (Rel (-3)) 			--spinlock locki end
		,ReadInstr (DirAddr 0) 			--read i
		,Receive 6
		,Push 6
		,Load (ImmValue 1) 6
		,Pop 5
		,Compute Add 5 6 6 				--i+1
		,WriteInstr 6 (DirAddr 0) 		--i = i + 1
		,WriteInstr 0 (DirAddr 1)
		,Jump (Abs 2) 					--go back to spin
		,Load (ImmValue 27) 6 			--main return.
		,WriteInstr 6 (DirAddr 2)
		,Jump (Rel 14)
		,TestAndSet (DirAddr 2) 		--ty start
		,Receive 6
		,Compute Equ 6 0 6
		,Branch 6 (Rel (-3))
		,ReadInstr (DirAddr 0)
		,Receive 6
		,Push 6
		,Load (ImmValue 1) 6
		,Pop 5
		,Compute Add 5 6 6
		,WriteInstr 6 (DirAddr 0)
		,WriteInstr 0 (DirAddr 2)
		,Jump (Abs 2)
		,ReadInstr (DirAddr 1) 			--main return we want shared(1) to be 0.
		,Receive 6
		,Branch 6 (Rel (-2)) 			--WAIT WHAT? IS THIS A JOIN?
		,ReadInstr (DirAddr 2)			--we want shared(2) to be 0.
		,Receive 6
		,Branch 6 (Rel (-2))
		,Load (ImmValue 49) 6
		,WriteInstr 6 (DirAddr 1) 		--stop child threads
		,WriteInstr 6 (DirAddr 2) 		--stop child threads
		,EndProg]

main :: IO ()
main = sysTest $ replicate 3 prog