module Test0Spril where

import HardwareTypes
import Simulation

prog :: [Instruction]
prog = [Store 0 (DirAddr 1),Store 0 (DirAddr 2),Load (ImmValue 1) 6,Store 6 (DirAddr 2),Load (DirAddr 2) 6,Load (ImmValue 1) 5,Compute Xor 6 5 6,Branch 6 (Rel 6),Load (ImmValue 31) 6,Store 6 (DirAddr 1),Load (ImmValue 1) 6,Store 6 (DirAddr 2),Jump (Rel 3),Load (ImmValue 27) 6,Store 6 (DirAddr 1),EndProg]

run :: Int -> IO ()
run n = sysTest $ replicate n prog