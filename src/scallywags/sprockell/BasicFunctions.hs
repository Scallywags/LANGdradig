module BasicFunctions where

-- ==========================================================================================================
-- Some elementary constants and Functions
-- ==========================================================================================================
reg0          = 0    :: Int                                 -- names for registers. reg0 is ALWAYS 0
regSprID      = 1    :: Int                                 -- regSprID: contains the sprockellID
regA          = 2    :: Int                                 -- registers A-E for other usage
regB          = 3    :: Int
regC          = 4    :: Int
regD          = 5    :: Int
regE          = 6    :: Int

intBool True  = 1                                               -- Bool-to-Int
intBool False = 0

x +>> xs = [x] ++ init xs                                       -- shift value into buffer
xs <<+ x = tail xs ++ [x]

f  $>  xs = map f xs
fs |$| xs = zipWith (\f x -> f x) fs xs                         -- parallel application of a list of functions
                                                                -- to an equally long list of arguments

(!)  :: [a] -> Int -> a                                         -- list indexing
xs ! i = xs !! i

(<~) :: [a] -> (Int, a) -> [a]                                  -- put value x at address i in xs
xs <~ (i,x) = take i xs ++ [x] ++ drop (i+1) xs

(<~!) :: [a] -> (Int, a) -> [a]                                 -- ibid, but leave address 0 unchanged
xs <~! (i,x)    | i == 0        = xs
                | otherwise     = xs <~ (i,x)

x ∈ xs =  x `elem` xs

concatWith x [] = []                                            -- concats a list of lists with a "gluing element" x
concatWith x [y] = y
concatWith x (y:ys) = y ++ [x] ++ concatWith x ys

ljustify n x = x ++ replicate (n - length x) ' '                -- adds spaces upto n positions for outlining;
rjustify n x = replicate (n - length x) ' ' ++ x                -- may be used for your own show-function


