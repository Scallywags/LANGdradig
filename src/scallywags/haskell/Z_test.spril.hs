import HardwareTypes
import Simulation

prog :: [Instruction]
prog = [Compute Equ 0 1 6,Branch 6 (Rel 6),WriteInstr 0 (IndAddr 1),ReadInstr (IndAddr 1),Receive 6,Branch 6 (Ind 6),Jump (Rel (-3)),Store 0 (DirAddr 1),Load (ImmValue 9) 6,EndProg]

main :: IO ()
main = sysTest $ replicate 1 prog