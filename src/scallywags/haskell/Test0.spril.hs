module Test0Spril where

import HardwareTypes
import Simulation

prog :: [Instruction]
prog = [Store 0 (DirAddr 0),Store 0 (DirAddr 1),Load (DirAddr 1) 6,Load (ImmValue 1) 5,Compute Xor 6 5 6,Branch 6 (Rel 5),Load (ImmValue 31) 6,Store 6 (DirAddr 0),Load (ImmValue 1) 6,Store 6 (DirAddr 1),Jump (Rel 2),Load (ImmValue 27) 6,Store 6 (DirAddr 0),EndProg]

run :: Int -> IO ()
run n = sysTest $ replicate n prog