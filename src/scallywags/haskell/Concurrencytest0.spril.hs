import HardwareTypes
import Simulation

prog :: [Instruction]
prog = [Compute Equ 0 1 6,Branch 6 (Rel 6),WriteInstr 0 (IndAddr 1),ReadInstr (IndAddr 1),Receive 6,Branch 6 (Ind 6),Jump (Rel (-3)),Store 0 (DirAddr 1),Load (ImmValue 11) 6,WriteInstr 6 (DirAddr 1),Jump (Rel 18),Load (ImmValue 8) 6,Store 6 (DirAddr 1),Store 0 (DirAddr 2),Load (ImmValue 0) 6,Store 6 (DirAddr 2),Load (ImmValue 19) 6,WriteInstr 6 (DirAddr 2),Jump (Rel 6),Load (ImmValue 1) 6,Store 6 (DirAddr 2),Load (ImmValue 10) 6,Store 6 (DirAddr 1),Jump (Abs 2),ReadInstr (DirAddr 2),Receive 6,Branch 6 (Rel (-2)),Jump (Abs 2),ReadInstr (DirAddr 1),Receive 6,Branch 6 (Rel (-2)),Load (ImmValue 34) 6,WriteInstr 6 (DirAddr 1),WriteInstr 6 (DirAddr 2),EndProg]

main :: IO ()
main = sysTest $ replicate 3 prog