import HardwareTypes
import Simulation

prog :: [Instruction]
prog = [Store 0 (DirAddr 1),Store 0 (DirAddr 2),Store 0 (DirAddr 3),Load (DirAddr 1) 6,Push 6,Load (ImmValue 8) 6,Pop 5,Compute LtE 5 6 6,Load (ImmValue 1) 5,Compute Xor 6 5 6,Branch 6 (Rel 14),Load (DirAddr 3) 6,Push 6,Load (ImmValue 6) 6,Pop 5,Compute Pow 5 6 6,Store 6 (DirAddr 3),Load (DirAddr 1) 6,Push 6,Load (ImmValue 1) 6,Pop 5,Compute Add 5 6 6,Store 6 (DirAddr 1),Jump (Rel (-20)),EndProg]

main :: IO ()
main = sysTest $ replicate 1 prog