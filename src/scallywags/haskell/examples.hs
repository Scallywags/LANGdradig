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

sharedmem :: [Instruction]
sharedmem = [Load (ImmValue 2) regA
            ,Compute NEq regSprID regA regE
            ,Branch regE (Rel 4)
            ,Load (ImmValue 1337) regE                                   --sprockell 2 specific thing
            ,WriteInstr regE (DirAddr 0)
            ,Jump (Rel 8)                                                --jump to join
            ,Nop
            ,Nop
            ,Nop
            ,ReadInstr (DirAddr 0)                                       --other sprockells specific thing
            ,Receive regB
            ,Store regB (DirAddr 1)
            ,EndProg                                                     --TODO loop infinitely based on shared mem addr
            ,Load (ImmValue 314) regC
            ,EndProg
            ]

spin :: [Instruction]
spin =  [Compute Equ regSprID reg0 regE
        ,Branch regE (Rel 7)
        ,ReadInstr (IndAddr regSprID)               --read from 'personal' shared memory location
        ,Receive regA                               --store value in regA
        ,Compute Equ regA reg0 regE                 --if regA didn't change (still equal to zero) then:
        ,Branch regE (Rel (-3))                     --try again.
        ,Store regA (DirAddr 1)                     --else: store the value found in shared memory in local memory.
        ,EndProg
        ] ++ replicate 100 Nop ++
        [Load (ImmValue 1337) regA
        ,WriteInstr regA (DirAddr 1)
        ,EndProg
        ]

testLocalMem    = sysTest [locmem]
testAdd         = sysTest [addAB]
testSharedMem   = sysTest [sharedmem, sharedmem, sharedmem]
testSpin        = sysTest [spin, spin]

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