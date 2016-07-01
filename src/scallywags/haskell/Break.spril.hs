import HardwareTypes
import Simulation

prog :: [Instruction]
prog = [Compute Equ 0 1 6,Branch 6 (Rel 6),WriteInstr 0 (IndAddr 1),ReadInstr (IndAddr 1),Receive 6,Branch 6 (Ind 6),Jump (Rel (-3)),WriteInstr 0 (DirAddr 1),Load (ImmValue 8) 6,WriteInstr 6 (DirAddr 1),ReadInstr (DirAddr 1),Receive 6,Push 6,Load (ImmValue 324) 6,Pop 5,Compute LtE 5 6 6,Load (ImmValue 1) 5,Compute Xor 6 5 6,Branch 6 (Rel 9),ReadInstr (DirAddr 1),Receive 6,Compute Incr 6 0 6,WriteInstr 6 (DirAddr 1),ReadInstr (DirAddr 1),Receive 6,PrintInt 6,Jump (Rel (-16)),Load (ImmValue 28) 6,EndProg]

main :: IO ()
main = sysRun $ replicate 1 prog