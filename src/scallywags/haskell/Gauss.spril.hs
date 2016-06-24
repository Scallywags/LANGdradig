import HardwareTypes
import Simulation

prog :: [Instruction]
prog = [Compute Equ 0 1 6,Branch 6 (Rel 6),WriteInstr 0 (IndAddr 1),ReadInstr (IndAddr 1),Receive 6,Branch 6 (Ind 6),Jump (Rel (-3)),Store 0 (DirAddr 1),Store 0 (DirAddr 2),Load (ImmValue 10) 6,Store 6 (DirAddr 2),Store 0 (DirAddr 3),Load (DirAddr 1) 6,Push 6,Load (DirAddr 2) 6,Pop 5,Compute LtE 5 6 6,Load (ImmValue 1) 5,Compute Xor 6 5 6,Branch 6 (Rel 14),Load (DirAddr 3) 6,Push 6,Load (DirAddr 1) 6,Pop 5,Compute Add 5 6 6,Store 6 (DirAddr 3),Load (DirAddr 1) 6,Push 6,Load (ImmValue 1) 6,Pop 5,Compute Add 5 6 6,Store 6 (DirAddr 1),Jump (Rel (-20)),Load (ImmValue 34) 6,EndProg]

main :: IO ()
main = sysTest $ replicate 1 prog