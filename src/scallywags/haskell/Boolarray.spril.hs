import HardwareTypes
import Simulation

prog :: [Instruction]
prog = [Compute Equ 0 1 6,Branch 6 (Rel 6),WriteInstr 0 (IndAddr 1),ReadInstr (IndAddr 1),Receive 6,Branch 6 (Ind 6),Jump (Rel (-3)),Load (ImmValue 3) 6,Store 6 (DirAddr 1),Store 0 (DirAddr 2),Store 0 (DirAddr 3),Store 0 (DirAddr 4),Load (ImmValue 3) 5,Store 5 (DirAddr 1),Load (ImmValue 5) 6,Push 6,Load (ImmValue 3) 6,Pop 5,Compute Equ 5 6 6,Store 6 (DirAddr 2),Load (ImmValue 1) 6,Store 6 (DirAddr 3),Load (ImmValue 0) 6,Store 6 (DirAddr 4),Load (ImmValue 1) 6,PrintLocalRange (DirAddr 2) 3 True,Load (ImmValue 27) 6,EndProg]

main :: IO ()
main = sysRun $ replicate 1 prog