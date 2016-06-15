module Examples where

import BasicFunctions
import HardwareTypes
import Sprockell
import System
import Simulation

addAB :: [Instruction]
addAB = [Load (ImmValue 5) regA
        ,Load (ImmValue 3) regB
        ,Compute Add regA regB regC
        ,EndProg
        ]

locmem :: [Instruction]
locmem =    [Load (ImmValue 7) regA             -- regA := 7
            ,Store regA (DirAddr 2)             -- mem(2) := regA
            ,Load (ImmValue 2) regB             -- regB := 2
            ,Load (IndAddr regB) regC           -- regC := mem(regB)
            ,EndProg
            ]

testLocalMem    = sysTest [locmem]
testAdd         = sysTest [addAB]


{-
intVar is een geheel getal.                 //zet intVar in het geheugen.
boolVar is een waarheid.                    //zet boolVar in het geheugen.
als niet boolVar dan                        //evaleer de boolean, doe een conditional branch
    intVar wordt 3.                         //zet een nieuwe waarde voor intVar in het geheugen
anders                                      
    doe
        intVar wordt 2.
        boolVar wordt waar.
    klaar.
-}