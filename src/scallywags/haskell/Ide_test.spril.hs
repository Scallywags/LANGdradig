import HardwareTypes
import Simulation

prog :: [Instruction]
prog = [Store 0 (DirAddr 1),Load (ImmValue 1) 6,Store 6 (DirAddr 1),Load (DirAddr 1) 6,Load (ImmValue 1) 5,Compute Xor 6 5 6,Branch 6 (Rel 3),Store 0 (DirAddr 2),Jump (Rel (-5)),Load (DirAddr 2) 6,Push 6,Load (ImmValue 6) 6,Pop 5,Compute Pow 5 6 6,Store 6 (DirAddr 2),Store 0 (DirAddr 3),Load (DirAddr 1) 6,Branch 6 (Rel 4),Load (ImmValue 8) 6,Store 6 (DirAddr 2),Jump (Rel 9),Load (ImmValue 0) 6,Store 6 (DirAddr 1),Load (DirAddr 2) 6,Push 6,Load (ImmValue 9) 6,Pop 5,Compute Add 5 6 6,Store 6 (DirAddr 2),Load (DirAddr 2) 6,Push 6,Load (ImmValue 8) 6,Pop 5,Compute LtE 5 6 6,Load (ImmValue 1) 5,Compute Xor 6 5 6,Branch 6 (Rel 1),EndProg]

main :: IO ()
main = sysTest $ replicate 1 prog