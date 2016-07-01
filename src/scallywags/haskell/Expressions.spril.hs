import HardwareTypes
import Simulation

prog :: [Instruction]
prog = [Compute Equ 0 1 6,Branch 6 (Rel 6),WriteInstr 0 (IndAddr 1),ReadInstr (IndAddr 1),Receive 6,Branch 6 (Ind 6),Jump (Rel (-3)),WriteInstr 0 (DirAddr 1),Load (ImmValue 5) 6,Push 6,Load (ImmValue 3) 6,Push 6,Load (ImmValue 2) 6,Push 6,Load (ImmValue 4) 6,Pop 5,Compute Pow 5 6 6,Pop 5,Compute Mul 5 6 6,Pop 5,Compute Add 5 6 6,Push 6,Load (ImmValue 2) 6,Push 6,Load (ImmValue 3) 6,Pop 5,Compute Add 5 6 6,Push 6,Load (ImmValue 2) 6,Push 6,Load (ImmValue 2) 6,Push 6,Load (ImmValue 3) 6,Pop 5,Compute Pow 5 6 6,Pop 5,Compute Add 5 6 6,Pop 5,Compute Mul 5 6 6,Pop 5,Compute Gt 5 6 6,WriteInstr 6 (DirAddr 1),ReadInstr (DirAddr 1),Receive 6,PrintBool 6,Load (ImmValue 46) 6,EndProg]

main :: IO ()
main = sysRun $ replicate 1 prog