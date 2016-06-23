import HardwareTypes
import Simulation

prog :: [Instruction]
prog = [Compute Equ 0 1 6,Branch 6 (Rel 6),WriteInstr 0 (IndAddr 1),ReadInstr (IndAddr 1),Receive 6,Branch 6 (Ind 6),Jump (Rel (-3)),WriteInstr 0 (DirAddr 3),Store 0 (DirAddr 1),Load (ImmValue 12) 6,WriteInstr 6 (DirAddr 1),Jump (Rel 14),TestAndSet (DirAddr 4),Receive 6,Compute Equ 6 0 6,Branch 6 (Rel (-3)),ReadInstr (DirAddr 3),Receive 6,Push 6,Load (ImmValue 1) 6,Pop 5,Compute Add 5 6 6,WriteInstr 6 (DirAddr 3),WriteInstr 0 (DirAddr 4),Jump (Abs 2),Load (ImmValue 28) 6,WriteInstr 6 (DirAddr 2),Jump (Rel 14),TestAndSet (DirAddr 5),Receive 6,Compute Equ 6 0 6,Branch 6 (Rel (-3)),ReadInstr (DirAddr 3),Receive 6,Push 6,Load (ImmValue 1) 6,Pop 5,Compute Add 5 6 6,WriteInstr 6 (DirAddr 3),WriteInstr 0 (DirAddr 5),Jump (Abs 2),ReadInstr (DirAddr 1),Receive 6,Branch 6 (Rel (-2)),ReadInstr (DirAddr 2),Receive 6,Branch 6 (Rel (-2)),Load (ImmValue 50) 6,WriteInstr 6 (DirAddr 1),WriteInstr 6 (DirAddr 2),EndProg]

main :: IO ()
main = sysTest $ replicate 3 prog