import HardwareTypes
import Simulation

prog :: [Instruction]
prog = [Compute Equ 0 1 6,Branch 6 (Rel 6),WriteInstr 0 (IndAddr 1),ReadInstr (IndAddr 1),Receive 6,Branch 6 (Ind 6),Jump (Rel (-3)),Store 0 (DirAddr 1),Store 0 (DirAddr 2),Store 0 (DirAddr 3),Load (ImmValue 20) 6,Store 6 (DirAddr 3),Load (DirAddr 3) 6,Push 6,Load (ImmValue 0) 6,Pop 5,Compute Gt 5 6 6,Load (ImmValue 1) 5,Compute Xor 6 5 6,Branch 6 (Rel 23),Load (DirAddr 3) 6,Compute Decr 6 0 6,Store 6 (DirAddr 3),Load (DirAddr 1) 6,Push 6,Load (ImmValue 3) 6,Pop 5,Compute Mul 5 6 6,Push 6,Load (ImmValue 1) 6,Pop 5,Compute Add 5 6 6,Store 6 (DirAddr 1),Load (DirAddr 2) 6,Load (ImmValue 1) 5,Compute Xor 6 5 6,Store 6 (DirAddr 2),Load (DirAddr 1) 6,PrintInt 6,Load (DirAddr 2) 6,PrintBool 6,Jump (Rel (-29)),Load (ImmValue 43) 6,EndProg]

main :: IO ()
main = sysRun $ replicate 1 prog