import HardwareTypes
import Simulation

prog :: [Instruction]
prog = [Compute Equ 0 1 6,Branch 6 (Rel 6),WriteInstr 0 (IndAddr 1),ReadInstr (IndAddr 1),Receive 6,Branch 6 (Ind 6),Jump (Rel (-3)),WriteInstr 0 (DirAddr 2),WriteInstr 0 (DirAddr 3),Load (ImmValue 12) 6,WriteInstr 6 (DirAddr 1),Jump (Rel 14),Load (ImmValue 1337) 6,WriteInstr 6 (DirAddr 2),Store 0 (DirAddr 1),Load (ImmValue 2) 6,Store 6 (DirAddr 1),ReadInstr (DirAddr 2),Receive 6,Push 6,Load (DirAddr 1) 6,Pop 5,Compute Mul 5 6 6,WriteInstr 6 (DirAddr 3),Jump (Abs 2),Store 0 (DirAddr 2),ReadInstr (DirAddr 1),Receive 6,Branch 6 (Rel (-2)),ReadInstr (DirAddr 3),Receive 6,Store 6 (DirAddr 2),Load (ImmValue 35) 6,WriteInstr 6 (DirAddr 1),Jump (Rel 4),Load (ImmValue 600) 6,WriteInstr 6 (DirAddr 2),Jump (Abs 2),Store 0 (DirAddr 3),Load (DirAddr 3) 6,Push 6,Load (ImmValue 66) 6,Pop 5,Compute Add 5 6 6,Store 6 (DirAddr 3),ReadInstr (DirAddr 1),Receive 6,Branch 6 (Rel (-2)),Load (ImmValue 50) 6,WriteInstr 6 (DirAddr 1),EndProg]

main :: IO ()
main = sysTest $ replicate 2 prog