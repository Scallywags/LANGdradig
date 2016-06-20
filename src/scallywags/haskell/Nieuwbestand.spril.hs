import HardwareTypes
import Simulation

prog :: [Instruction]
prog = [Store 0 (DirAddr 1),Load (ImmValue 1) 6,Store 6 (DirAddr 1),Store 0 (DirAddr 2),Load (ImmValue 18) 6,Load (ImmValue (-1)) 5,Compute Mul 6 5 6,Store 6 (DirAddr 2),Load (ImmValue 1) 6,Load (ImmValue 1) 5,Compute Xor 6 5 6,Branch 6 (Rel 4),Load (ImmValue 0) 6,Store 6 (DirAddr 1),Jump (Rel (-6)),EndProg]

main :: IO ()
main = sysTest $ replicate 1 prog