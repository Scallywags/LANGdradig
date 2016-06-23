import HardwareTypes
import Simulation

prog :: [Instruction]
prog = [Compute Equ 0 1 6,Branch 6 (Rel 6),WriteInstr 0 (IndAddr 1),ReadInstr (IndAddr 1),Receive 6,Branch 6 (Ind 6),Jump (Rel (-3)),Load (ImmValue 10) 6,WriteInstr 6 (DirAddr 1),Jump (Rel 5),Store 0 (DirAddr 1),Load (ImmValue 1337) 6,Store 6 (DirAddr 1),Jump (Abs 2),ReadInstr (DirAddr 1),Receive 6,Branch 6 (Rel (-2)),Load (ImmValue 19) 6,WriteInstr 6 (DirAddr 1),EndProg]

main :: IO ()
main = sysTest $ replicate 2 prog