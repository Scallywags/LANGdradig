module Examples where

import BasicFunctions
import HardwareTypes
import Sprockell
import System
import Simulation
import AST

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

crash :: [Instruction]
crash = [Jump $ Rel 0]

spinChilds :: [Instruction]
spinChilds =    [WriteInstr reg0 (IndAddr regSprID)
                ,Compute Equ reg0 regSprID regA
                ,Branch regA (Rel 5)
                ,ReadInstr (IndAddr regSprID)
                ,Receive regA
                ,Branch regA (Ind regA)
                ,Jump (Rel (-3))
                ,Load (ImmValue 9) regA
                ,WriteInstr regA (DirAddr 1)
                ,EndProg
                ]

forkjoin :: [Instruction]
forkjoin    =   [WriteInstr reg0 (IndAddr regSprID)
                ,Compute Equ reg0 regSprID regA
                ,Branch regA (Rel 10)
                ,ReadInstr (IndAddr regSprID)
                ,Receive regA
                ,Jump (Ind regA)
                ,Compute Add regA reg0 regB
                ,ReadInstr (IndAddr regSprID)
                ,Receive regA
                ,Jump (Ind regA)
                

                ,Load (ImmValue 6) regA
                ,Nop
                ,Nop
                ,Nop
                ,Nop
                ,WriteInstr regA (DirAddr 1)
                ,WriteInstr regA (DirAddr 2)
                ,Load (ImmValue 1337) regA
                ,Nop
                ,Nop
                ,Nop
                ,WriteInstr regA (DirAddr 3)
                ,Load (ImmValue 27) regA
                ,Nop
                ,Nop
                ,WriteInstr regA (DirAddr 1)
                ,WriteInstr regA (DirAddr 2)
                ,EndProg
                ]

receive :: [Instruction]
receive = [Load (ImmValue 1337) regB] ++ [WriteInstr regB (DirAddr 0)] ++ replicate 20 Nop ++ [ReadInstr (DirAddr 0)] ++ [Receive regA, Nop, EndProg]

programcount :: [Instruction]
programcount = [Jump (Abs 0)]

testLocalMem    = sysTest [locmem]
testAdd         = sysTest [addAB]
testSharedMem   = sysTest [sharedmem, sharedmem, sharedmem]
testSpin        = sysTest [spin, spin]
testSpinChilds  = sysTest [spinChilds, spinChilds]
testCrash       = sysTest [crash]
testForkJoin    = sysTest $ replicate 3 forkjoin

--exampleAST :: Prog
--exampleAST = Prog 


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