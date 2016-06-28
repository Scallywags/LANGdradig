import HardwareTypes
import Simulation

prog :: [Instruction]
prog = [Compute Equ 0 1 6,Branch 6 (Rel 6),WriteInstr 0 (IndAddr 1),ReadInstr (IndAddr 1),Receive 6,Branch 6 (Ind 6),Jump (Rel (-3)),WriteInstr 0 (DirAddr 3),WriteInstr 0 (DirAddr 4),Load (ImmValue 12) 6,WriteInstr 6 (DirAddr 1),Jump (Rel 6),Load (ImmValue 8) 6,WriteInstr 6 (DirAddr 3),Load (ImmValue 10) 6,WriteInstr 6 (DirAddr 4),Jump (Abs 2),ReadInstr (DirAddr 1),Receive 6,Branch 6 (Rel (-2)),Load (ImmValue 23) 6,WriteInstr 6 (DirAddr 1),Jump (Rel 17),Load (ImmValue 9) 6,WriteInstr 6 (DirAddr 3),WriteInstr 0 (DirAddr 5),Load (ImmValue 29) 6,WriteInstr 6 (DirAddr 2),Jump (Rel 7),Store 0 (DirAddr 0),Load (ImmValue 13) 6,WriteInstr 6 (DirAddr 5),Load (ImmValue 8) 6,WriteInstr 6 (DirAddr 4),Jump (Abs 2),ReadInstr (DirAddr 2),Receive 6,Branch 6 (Rel (-2)),Jump (Abs 2),ReadInstr (DirAddr 1),Receive 6,Branch 6 (Rel (-2)),ReadInstr (DirAddr 4),Receive 6,PrintInt 6,Load (ImmValue 48) 6,WriteInstr 6 (DirAddr 1),WriteInstr 6 (DirAddr 2),EndProg]

main :: IO ()
main = sysTest $ replicate 3 prog