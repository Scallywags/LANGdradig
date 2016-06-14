{-# LANGUAGE RecordWildCards #-}

module System where

import Data.Maybe

import BasicFunctions
import HardwareTypes
import Sprockell


-- ===================================================================================
shMem :: (SharedMem, RequestFifo)
         -> IndRequests
         -> ((SharedMem, RequestFifo), (SprID,Reply))

shMem (sharedMem,requestFifo) chRequests = ((sharedMem',requestFifo'), (i,reply))
        where
          (i,req)  | not $ null requestFifo   = head requestFifo
                   | otherwise                = (0, NoRequest)

          (reply, sharedMem')   = case req of
                NoRequest                          -> ( Nothing            , sharedMem )
                ReadReq a                          -> ( Just (sharedMem!a) , sharedMem )
                WriteReq v a                       -> ( Nothing            , sharedMem <~ (a,v))
                TestReq a     | sharedMem!a == 0   -> ( Just 1             , sharedMem <~ (a,1))
                              | otherwise          -> ( Just 0             , sharedMem )

          requestFifo'  = drop 1 requestFifo ++ filter ((/=NoRequest).snd) chRequests

-- ===================================================================================
transfer :: (RequestChannels, ReplyChannels)
                -> (ParRequests, (SprID, Reply))
                -> ((RequestChannels, ReplyChannels), (ParReplies, IndRequests))

transfer (requestChnls,replyChnls) (sprRequests,(i,shMemReply)) = ( (requestChnls',replyChnls'), (outReplies,outRequests) )
        where
          -- ->->->->
          outRequests   = zip [0..] $ map head requestChnls                                             -- <<== TODO: abstract away from softare/hardware
          requestChnls' = zipWith (<<+) requestChnls sprRequests

          -- <-<-<-<-
          n             = length replyChnls                                                             -- <<== TODO: abstraction difficult:
          inReplies     = replicate n Nothing <~ (i,shMemReply)                                         --              no parameter n in CLaSH
          outReplies    = map head replyChnls
          replyChnls'   = zipWith (<<+) replyChnls inReplies

-- ===================================================================================
system :: Int -> [InstructionMem] -> SystemState -> t -> SystemState

system nrOfSprs instrss systemState _ = systemState'
        where
          SystemState{..} = systemState

          -- Sprockells
          (sprStates',sprRequests)                              = unzip $ sprockell $> instrss |$| sprStates |$| chReplies

          -- Communication
          ((requestChnls',replyChnls'), (chReplies,chRequests)) = transfer (requestChnls,replyChnls) (sprRequests,(i,shMemReply))

          -- Shared Memory
          ((sharedMem',requestFifo'), (i,shMemReply))           = shMem (sharedMem,requestFifo) chRequests

          systemState' = SystemState
                { sprStates     = sprStates'
                , requestChnls  = requestChnls'
                , replyChnls    = replyChnls'
                , requestFifo   = requestFifo'
                , sharedMem     = sharedMem'
                }
