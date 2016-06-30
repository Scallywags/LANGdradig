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
		,Load (ImmValue 3) 6
		,Store 6 (DirAddr 1)
		,Store 0 (DirAddr 2)
		,Store 0 (DirAddr 3)
		,Store 0 (DirAddr 4)
		,Store 0 (DirAddr 5)
		,Load (ImmValue 3) 6
		,Store 6 (DirAddr 5)
		,Store 0 (DirAddr 6)
		,Store 0 (DirAddr 7)
		,Store 0 (DirAddr 8)
		,Store 0 (DirAddr 9)
		,Load (ImmValue 3) 5
		,Store 5 (DirAddr 1)
		,Load (ImmValue 1) 6
		,Store 6 (DirAddr 2)
		,Load (ImmValue 2) 6
		,Store 6 (DirAddr 3)
		,Load (ImmValue 3) 6
		,Store 6 (DirAddr 4)
		,Load (ImmValue 1) 6
		,Load (ImmValue 3) 5
		,Store 5 (DirAddr 5)
		,Load (ImmValue 1) 6
		,Store 6 (DirAddr 6)
		,Load (ImmValue 2) 6
		,Store 6 (DirAddr 7)
		,Load (ImmValue 3) 6
		,Store 6 (DirAddr 8)
		,Load (ImmValue 5) 6
		,Store 0 (DirAddr 19)			--equal is een stelling
		,Load (ImmValue 1) 6
		,Store 6 (DirAddr 19)			-- equal is waar
		,Store 0 (DirAddr 20) 			-- i is een getal
		,Store 0 (DirAddr 21)			-- x is een getal
		,Store 0 (DirAddr 22)			-- y is een getal
		,Load (DirAddr 20) 6			-- BEGIN_WHILE
		,Compute Incr 6 0 6
		,Store 6 (DirAddr 20)			-- verhoog i
		,Push 6
		,Load (DirAddr 1) 6				-- eerste element van arr1
		,Pop 5
		,Compute LtE 5 6 6				-- i <= len arr1
		,Push 6
		,Load (DirAddr 19) 6
		,Pop 5
		,Compute And 5 6 6				-- i <= len arr1 && equal
		,Load (ImmValue 1) 5
		,Compute Xor 6 5 6
		,Branch 6 (Rel 22) 				--jump to end if not equal.
		,Load (DirAddr 20) 6			--i
		,Load (ImmValue 1) 5			--base offset a
		,Compute Add 6 5 6				--i+offset a
		,Load (IndAddr 6) 6				--a[i]
		,Store 6 (DirAddr 21)			--x = a[i]
		,Load (DirAddr 20) 6			--i
		,Load (ImmValue 5) 5			--base offset b
		,Compute Add 6 5 6				--i+offset b
		,Load (IndAddr 6) 6				--b[i]
		,Store 6 (DirAddr 22)			--y = b[i]
		,Load (DirAddr 21) 6			
		,Push 6
		,Load (DirAddr 22) 6
		,Pop 5
		,Compute NEq 5 6 6				--x != y
		,Load (ImmValue 1) 5			
		,Compute Xor 6 5 6
		,Branch 6 (Rel 3)				--if not (x != y) skip this.
		,Load (ImmValue 0) 6
		,Store 6 (DirAddr 19)			--equal is onwaar
		,Jump (Rel (-34))				--jump back to BEGIN_WHILE
		,Load (DirAddr 19) 6			--END_WHILE
		,PrintBool 6					--laat equal zien.
		,Load (ImmValue 81) 6
		,EndProg]

main :: IO ()
main = sysTest $ replicate 1 prog

--TODO fix offsets!!!!!!
--TODO adjust AST