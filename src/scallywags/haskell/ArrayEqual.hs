import HardwareTypes
import Simulation

locI 	= 1 :: Int
locEq	= 2 :: Int

instrs :: [Instruction]
instrs = 	[Load (ImmValue 1) regOut5 			--equal = true
			,Load (ImmValue 0) regOut4			--i = 0

			--,Load (ImmValue 0) regOut3 			--x=0
			--,Load (ImmValue 0) regOut2			--y=0

			,Compute Add regOut4 regOut5 regOut4 	-- i+=1

			,Store regOut4 (DirAddr locI)
			,Store regOut5 (DirAddr locEq)
			,Load (IndAdd regOut2) regOut3


			]

--array1: regOut2
--array2: regOut1