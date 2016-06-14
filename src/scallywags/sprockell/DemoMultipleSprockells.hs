module DemoMultipleSprockells where

import BasicFunctions
import HardwareTypes
import Sprockell
import System
import Simulation

prog :: [Instruction]
prog = [
           Branch regSprID (Rel 6)
         , Load (ImmValue 12) regC
         , WriteInstr regC (DirAddr 1) -- Sprockell 1 must jump to second EndProg
         , WriteInstr regC (DirAddr 2) -- Sprockell 2 must jump to second EndProg
         , WriteInstr regC (DirAddr 3) -- Sprockell 3 must jump to second EndProg
         , Jump (Abs 11)               -- Sprockell 0 jumps to first EndProg
         -- BEGIN: loop
         , ReadInstr (IndAddr regSprID)
         , Receive regA
         , Compute Equal regA reg0 regB
         , Branch regB (Rel (-3))
         -- END: loop
         , Jump (Ind regA)

         -- 11: Sprockell 0 is sent here
         , EndProg

         -- 12: Sprockells 1, 2 and 3 are sent here
         , EndProg
       ]

demoTest = sysTest [prog,prog,prog,prog]

