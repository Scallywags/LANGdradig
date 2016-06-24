import HardwareTypes
import Simulation

prog :: [Instruction]
prog = [Compute Equ 0 1 6,Branch 6 (Rel 6),WriteInstr 0 (IndAddr 1),ReadInstr (IndAddr 1),Receive 6,Branch 6 (Ind 6),Jump (Rel (-3)),WriteInstr 0 (DirAddr 2),Load (ImmValue 11) 6,WriteInstr 6 (DirAddr 1),Jump (Rel 11),Load (ImmValue 1337) 6,WriteInstr 6 (DirAddr 2),ReadInstr (DirAddr 2),Receive 6,Push 6,Load (ImmValue 2) 6,Pop 5,Compute Mul 5 6 6,WriteInstr 6 (DirAddr 2),Jump (Abs 2),ReadInstr (DirAddr 1),Receive 6,Branch 6 (Rel (-2)),Load (ImmValue 27) 6,WriteInstr 6 (DirAddr 1),Jump (Rel 16),ReadInstr (DirAddr 2),Receive 6,Push 6,Load (ImmValue 1000) 6,Pop 5,Compute Sub 5 6 6,WriteInstr 6 (DirAddr 2),ReadInstr (DirAddr 2),Receive 6,Push 6,Load (ImmValue 1000) 6,Pop 5,Compute Sub 5 6 6,WriteInstr 6 (DirAddr 2),Jump (Abs 2),ReadInstr (DirAddr 1),Receive 6,Branch 6 (Rel (-2)),Load (ImmValue 47) 6,WriteInstr 6 (DirAddr 1),EndProg]

main :: IO ()
main = sysTest $ replicate 2 prog