module Simulation where

import BasicFunctions
import HardwareTypes
import Sprockell
import System

-- ====================================================================================================
-- Sprockell Test
-- ====================================================================================================

sprockellSim :: [Instruction]
                -> SprockellState
                -> [Reply]
                -> [(Instruction, SprockellState, Request)]

sprockellSim instrs s []     = []
sprockellSim instrs s (i:is) | instr /= EndProg    = (instr,s',o) : sprockellSim instrs s' is
                             | otherwise           = []
                where
                  (s',o) = sprockell instrs s i
                  instr  = instrs ! pc s

localMemSize = 64 :: Int
regbankSize  = 8  :: Int

initSprockellState :: Value -> SprockellState
initSprockellState sprID = SprState
        { pc       = 0
        , sp       = localMemSize
        , regbank  = replicate regbankSize 0 <~ (regSprID,sprID)
        , localMem = replicate localMemSize 0
        }

sprTest :: Value -> [Instruction] -> [Reply] -> IO ()
sprTest sprID instrs input = putStr
                           $ unlines
                           $ map show
                           $ sprockellSim instrs (initSprockellState sprID) input

-- ====================================================================================================
-- System Test
-- ====================================================================================================
data Tick  = Tick        deriving (Eq,Show)
type Clock = [Tick]
clock :: Clock
clock = repeat Tick

systemSim :: [[Instruction]] -> SystemState -> Clock -> [([Instruction],SystemState)]
systemSim instrss s []     = []
systemSim instrss s (t:ts) | not sysHalted = (instrs,s') : systemSim instrss s' ts
                           | otherwise     = []
                where
                  instrs    = zipWith (!) instrss (map pc $ sprStates s)
                  s'        = system nrOfSprockells instrss s t
                  sysHalted = and $ map (==EndProg) $ zipWith (!!) instrss $ map pc $ sprStates s

nrOfSprockells  = 4 :: Int
shMemSize       = 32 :: Int
channelDelay    = 4 :: Int

initSystemState = SystemState
        { sprStates     = map initSprockellState [0 .. nrOfSprockells-1]
        , requestChnls  = replicate nrOfSprockells $ replicate channelDelay NoRequest
        , replyChnls    = replicate nrOfSprockells $ replicate channelDelay Nothing
        , requestFifo   = []
        , sharedMem     = replicate shMemSize 0
        }

myShow (instrs,s) = show instrs ++ "\n" ++
                    (unlines $ map show $ sprStates s) ++
                    show (requestChnls s) ++ "\n" ++
                    show (replyChnls s) ++"\n" ++
                    show (requestFifo s) ++ "\n" ++
                    show (sharedMem s)

printOnlyShow :: ([Instruction], SystemState) -> String
printOnlyShow ([], _)                                                   = ""
printOnlyShow (i:is, systemState@SystemState{sprStates=state:states, sharedMem=sharedMem})   = aString where
    aString = case i of
        PrintInt regIndex   -> show (regbank state !! regIndex) ++ "\n" ++ printOnlyShow (is, systemState{sprStates=states})
        
        PrintBool regIndex  -> showBool (boolInt (regbank state !! regIndex)) ++ "\n" ++ printOnlyShow (is, systemState{sprStates=states})
        
        PrintLocalRange addr range asBool -> case addr of
            DirAddr offset      -> (if asBool then show $ map (showBool . boolInt) vals else show vals) ++ "\n" ++ printOnlyShow (is, systemState{sprStates=states})
                                      where vals = take range $ drop offset $ localMem state
            IndAddr regIndex    -> (if asBool then show $ map (showBool . boolInt) vals else show vals) ++ "\n" ++ printOnlyShow (is, systemState{sprStates=states})
                                      where vals = take range $ drop (regbank state !! regIndex) $ localMem state

        PrintSharedRange addr range asBool -> case addr of
            DirAddr offset      -> (if asBool then show $ map (showBool . boolInt) vals else show vals) ++ "\n" ++ printOnlyShow (is, systemState{sprStates=states})
                                      where vals = (take range $ drop offset $ sharedMem)
            IndAddr regIndex    -> (if asBool then show $ map (showBool . boolInt) vals else show vals) ++ "\n" ++ printOnlyShow (is, systemState{sprStates=states})
                                      where vals = take range $ drop (regbank state !! regIndex) $ sharedMem

        Debug string            -> string ++ "\n" ++ printOnlyShow (is, systemState{sprStates=states})

        _                       -> printOnlyShow (is, systemState{sprStates=states})

showBool :: Bool -> String
showBool True = "waar"
showBool False = "onwaar"

sysRun :: [[Instruction]] -> IO ()
sysRun instrss = putStr
               $ concat
               $ map printOnlyShow
               $ systemSim instrss initSystemState clock

sysTest :: [[Instruction]] -> IO ()                             -- instrss: list of instructions per Sprockell
sysTest instrss = putStr                                        -- putStr: standard Haskell IO-function
                $ unlines
                $ map (++"\n")
                $ map myShow
                $ systemSim instrss initSystemState clock

