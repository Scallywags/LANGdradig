import HardwareTypes
import Simulation

prog :: [Instruction]
prog = [Compute Equ 0 1 6,Branch 6 (Rel 6),WriteInstr 0 (IndAddr 1),ReadInstr (IndAddr 1),Receive 6,Branch 6 (Ind 6),Jump (Rel (-3)),Load (ImmValue 5) 6,Store 6 (DirAddr 1),Store 0 (DirAddr 2),Store 0 (DirAddr 3),Store 0 (DirAddr 4),Store 0 (DirAddr 5),Store 0 (DirAddr 6),Load (ImmValue 5) 6,Store 6 (DirAddr 7),Store 0 (DirAddr 8),Store 0 (DirAddr 9),Store 0 (DirAddr 10),Store 0 (DirAddr 11),Store 0 (DirAddr 12),Store 0 (DirAddr 13),Load (ImmValue 5) 5,Store 5 (DirAddr 1),Load (ImmValue 5) 6,Store 6 (DirAddr 2),Load (ImmValue 4) 6,Store 6 (DirAddr 3),Load (ImmValue 3) 6,Store 6 (DirAddr 4),Load (ImmValue 2) 6,Store 6 (DirAddr 5),Load (ImmValue 1) 6,Store 6 (DirAddr 6),Load (ImmValue 1) 6,Load (ImmValue 5) 5,Store 5 (DirAddr 7),Load (ImmValue 5) 6,Store 6 (DirAddr 8),Load (ImmValue 4) 6,Store 6 (DirAddr 9),Load (ImmValue 3) 6,Store 6 (DirAddr 10),Load (ImmValue 2) 6,Store 6 (DirAddr 11),Load (ImmValue 1) 6,Store 6 (DirAddr 12),Load (ImmValue 7) 6,Load (ImmValue 1) 6,Store 6 (DirAddr 15),Load (ImmValue 7) 6,Store 6 (DirAddr 15),Load (ImmValue 1) 6,Store 6 (DirAddr 18),Store 0 (DirAddr 17),Load (DirAddr 17) 6,Compute Incr 6 0 6,Store 6 (DirAddr 17),Load (DirAddr 15) 5,Load (IndAddr 5) 5,Compute LtE 6 5 6,Load (DirAddr 18) 4,Compute And 6 4 3,Load (ImmValue 1) 2,Compute Xor 3 2 6,Branch 6 (Rel 14),Load (DirAddr 17) 6,Load (DirAddr 15) 5,Compute Add 6 5 4,Load (IndAddr 4) 3,Load (DirAddr 16) 5,Compute Add 6 5 4,Load (IndAddr 4) 2,Compute NEq 3 2 4,Load (ImmValue 1) 5,Compute Xor 4 5 6,Branch 6 (Rel 2),Store 0 (DirAddr 18),Jump (Rel (-23)),Load (DirAddr 18) 6,Store 6 (DirAddr 13),Load (DirAddr 13) 6,PrintBool 6,PrintLocalRange (DirAddr 2) 5,PrintLocalRange (DirAddr 8) 5,Load (ImmValue 86) 6,EndProg]

main :: IO ()
main = sysTest $ replicate 1 prog