{-# LANGUAGE TypeSynonymInstances, FlexibleInstances, DeriveAnyClass #-}

module Generator where

import AST
import HardwareTypes hiding (pc)
import BasicFunctions

type Offset         = Int
type Entry          = (String, Type, Offset)
type Scope          = [Entry]

data CompileState = CompileState 
    {   localVars :: [Scope]
    ,   sharedVars :: [Scope]
    ,   locks :: [(String, Offset)]
    ,   t_ids :: [(String, Offset)]
    ,   nextLocalOffset :: Offset
    ,   nextSharedOffset :: Offset
    ,   pc :: Int
    } deriving (Show)

startState :: CompileState
startState = CompileState
    {   localVars = []
    ,   sharedVars = []
    ,   locks = []
    ,   t_ids = []
    ,   nextLocalOffset = 1
    ,   nextSharedOffset = 0
    ,   pc = 0
    }

offset :: [Scope] -> String -> Maybe Offset
offset [] identifier                            = Nothing
offset ([]:scopes) identifier                   = offset scopes identifier
offset (((i, t, o):entries):scopes) identifier  | i == identifier   = Just o
                                                | otherwise         = offset (entries:scopes) identifier

t_offset :: [(String, Offset)] -> String -> Maybe Offset
t_offset table string = lookup string table

entry :: [Scope] -> String -> Maybe Entry
entry [] identifier                             = Nothing
entry ([]:scopes) identifier                    = entry scopes identifier
entry (((i, t, o):entries):scopes) identifier   | i == identifier   = Just (i, t, o)
                                                | otherwise         = entry (entries:scopes) identifier

regOut1 :: Int
regOut1 = regE

regOut2 :: Int
regOut2 = regD

regOut3 :: Int
regOut3 = regC

regOut4 :: Int
regOut4 = regB

regOut5 :: Int
regOut5 = regA

generate :: Prog -> ([Instruction], CompileState)
generate p@(Prog stmnts) = (instructions, endstate)
    where (instructions, endstate@CompileState{t_ids=t_ids}) = gen p startState {nextSharedOffset=length t_ids+1}

class CodeGen c where
    gen :: c -> CompileState -> ([Instruction], CompileState)

type Stats = [Stat]
type Exprs = [Expr]

instance CodeGen Stats where
    gen [] compState    = ([], compState)
    gen (stat:stats)   compState    = (statInstrs ++ restInstrs, restState) where
        (statInstrs, statState) = gen stat compState
        (restInstrs, restState) = gen stats statState

instance CodeGen Exprs where
    gen [] compState    = ([], compState)
    gen (expr:exprs)    compState   = (exprInstrs ++ restInstrs, restState) where
        (exprInstrs, exprState) = gen expr compState
        (restInstrs, restState) = gen exprs exprState

instance CodeGen Prog where
    gen (Prog stats) cs@CompileState{localVars=lv, sharedVars=sv, pc=pc}    = (code, statState{pc=restPc}) where
        (statInstrs, statState@CompileState{t_ids=t_ids, pc=statPc}) = gen stats cs{localVars=[]:lv, sharedVars=[]:sv, pc=pc+2+5} --length spinChilds + length isId0

        spinChilds = [WriteInstr reg0 (IndAddr regSprID), ReadInstr (IndAddr regSprID), Receive regOut1, Branch regOut1 (Ind regOut1), Jump (Rel (-3))]
        isSprockellID0 = [Compute Equ reg0 regSprID regOut1, Branch regOut1 (Rel (length spinChilds + 1))]
        numSprockells = length t_ids + 1
        endprogLocation = length isSprockellID0 + length spinChilds + length statInstrs + 1 + numSprockells - 1
        shutdownOtherThreadsInstr = [Load (ImmValue endprogLocation) regOut1] ++ [WriteInstr regOut1 (DirAddr addr) | addr <- [1..numSprockells - 1]]

        code = isSprockellID0 ++ spinChilds ++ statInstrs ++ shutdownOtherThreadsInstr ++ [EndProg]
        restPc = length isSprockellID0 + length spinChilds + statPc + length shutdownOtherThreadsInstr + 1

instance CodeGen Stat where
    --DeclStat
    gen (Decl varName varType) cs@CompileState{localVars=scope:scopes, nextLocalOffset=offset, pc=pc} = (code, restState) where
        size = case varType of
            IntType     -> 1
            BoolType    -> 1
            ArrayType len _ -> len + 1
        code        = case varType of
            IntType                 ->  [Store reg0 (DirAddr offset)]    --default value for Int is 0
            BoolType                ->  [Store reg0 (DirAddr offset)]    --default value for Bool is 0
            ArrayType len elemType  ->  [Load (ImmValue len) regOut1, Store regOut1 (DirAddr offset)] ++
                                        [Store reg0 (DirAddr dirAddr) | dirAddr <- [offset+1..offset+len+1]]
                                        --default value for arrays is all zeros.
        restState = cs{localVars=((varName, varType, offset):scope):scopes, nextLocalOffset=offset+size, pc=pc+length code}

    --BlockStat
    gen (Block stats) cs@CompileState{localVars=scopes}     = (statIntrs, statState{localVars=scopes}) where --we only need to pop the first element so we can reuse 'scopes'.
        (statIntrs, statState) = gen stats cs{localVars=[]:scopes} --opens a new scope for the stats. will not be reused after the blockstat.

    --ExprStat
    gen (Expr expr) compileState                            = gen expr compileState

    --IfThenStat
    gen (IfThen expr stat) cs@CompileState{pc=pc}           = (code, statState{pc=pc+length code}) where
        invertedExpr = case expr of                             -- small optimization
            UnOp Not e -> e
            _ -> UnOp Not expr
        (exprInstrs, exprState@CompileState{pc=exprPc})  = gen invertedExpr cs     -- only jump if expression is false
        (statInstrs, statState)                          = gen stat exprState{pc=exprPc+1}
        code = exprInstrs ++ [Branch regOut1 (Rel (length statInstrs + 1))] ++ statInstrs

    --IfThenElseStat
    gen (IfThenElse expr stat1 stat2) cs@CompileState{pc=pc}    = (code, stat1State{pc=pc+length code}) where
        (exprInstrs, exprState@CompileState{pc=exprPc})      = gen expr cs
        (stat1Instrs, stat1State)                            = gen stat1 stat2State{pc=stat2Pc+1}
        (stat2Instrs, stat2State@CompileState{pc=stat2Pc})   = gen stat2 exprState{pc=exprPc+1}
        code =  exprInstrs ++ [Branch regOut1 (Rel (length stat2Instrs + 2))] ++
                stat2Instrs ++ [Jump $ Rel (length stat1Instrs+1)] ++ stat1Instrs   --if not expr stat2 else stat1

    --WhileStat
    gen (While expr stat) cs@CompileState{pc=pc}               = (code, statState{pc=pc+length code}) where
        invertedExpr = case expr of                      -- small optimization
            UnOp Not e -> e
            _ -> UnOp Not expr
        (exprInstrs, exprState@CompileState{pc=exprPc})  = gen invertedExpr cs   -- jump past while if and only if expression is false.
        (statInstrs, statState)                          = gen stat exprState{pc=exprPc+1}
        code = exprInstrs ++ [Branch regOut1 (Rel (length statInstrs + 2))] ++ statInstrs ++ [Jump (Rel $ -(length exprInstrs + length statInstrs + 1))]

    --DeclShared
    gen (DeclShared varName varType) cs@CompileState{sharedVars=scope:scopes, nextSharedOffset=offset, pc=pc}  = (code, restState) where          
        size = case varType of
            IntType     -> 1
            BoolType    -> 1
            ArrayType len _ -> len + 1
        code        = case varType of
            IntType                 ->  [WriteInstr reg0 (DirAddr offset)]    --default value for Int is 0
            BoolType                ->  [WriteInstr reg0 (DirAddr offset)]    --default value for Bool is 0
            ArrayType len elemType  ->  [Load (ImmValue len) regOut1, WriteInstr regOut1 (DirAddr offset)] ++
                                        [WriteInstr reg0 (DirAddr dirAddr) | dirAddr <- [offset+1..offset+len+1]]
                                        --default value for arrays is all zeros. fix in case the elements are arrays themselves

        restState = cs{sharedVars=((varName, varType, offset):scope):scopes, nextSharedOffset=offset+size, pc=pc+length code}

    --ForkStat
    gen (Fork spr_id stats) cs@CompileState{localVars=lv, sharedVars=sv, nextLocalOffset=nlo, nextSharedOffset=nso, pc=pc, t_ids=t_ids} = (code, restState) where
        jumpPc = pc + 3 --length forkInstrs

        addrM = t_offset t_ids spr_id
        addr = case addrM of
            Just a      -> a
            Nothing     -> case t_ids of
                []  -> 1
                _   -> maximum (map snd t_ids) + 1

        newT_ids = case addrM of
            Just _      -> t_ids
            Nothing     -> (spr_id, addr):t_ids

        forkInstrs = [Load (ImmValue jumpPc) regOut1, WriteInstr regOut1 (DirAddr addr), Jump (Rel (length statInstrs + length spinInstrs + 1))] --make the other sprockell jump to new programcounter
        spinInstrs = [Jump (Abs 2)]

        (statInstrs, statState@CompileState{nextSharedOffset=nso}) = gen (Block stats) cs{localVars=[[]], nextLocalOffset=1, sharedVars=[]:sv, t_ids=newT_ids, pc=pc+length forkInstrs}
        code = forkInstrs ++ statInstrs ++ spinInstrs
        restState = statState{localVars=lv, nextLocalOffset=nlo, sharedVars=sv, pc=pc+length code}

    --JoinStat
    gen (Join spr_id) cs@CompileState{pc=pc, t_ids=t_ids} = (code, cs{pc=pc+length code}) where
        Just addr = t_offset t_ids spr_id --should always work.
        code = [ReadInstr (DirAddr addr), Receive regOut1, Branch regOut1 (Rel (-2))]

    --SyncStat
    gen (Sync lock stat) cs@CompileState{sharedVars=scope:scopes, nextSharedOffset=offset, locks=locks, pc=pc} = (code, restState) where
        lockOffsetMaybe   = t_offset locks lock
        dirAddr = case lockOffsetMaybe of
            Just addr   -> addr
            Nothing     -> offset

        newLocks = case lockOffsetMaybe of
            Just addr   -> locks
            Nothing     -> (lock, offset):locks

        nso = case lockOffsetMaybe of
            Just addr   -> offset
            Nothing     -> offset + 1

        (statInstrs, statState) = gen stat cs{pc=pc+length spinInstrs}
        spinInstrs = [TestAndSet (DirAddr dirAddr), Receive regOut1, Compute Equ regOut1 reg0 regOut1, Branch regOut1 (Rel (-3))]

        code = spinInstrs ++ statInstrs ++ [WriteInstr reg0 (DirAddr dirAddr)]
        restState = statState{nextSharedOffset=nso, locks=newLocks, pc=pc+length code}

    --PrintStat
    gen (Print expr exprType) cs@CompileState{localVars=lv, sharedVars=sv, pc=pc}  = (code, cs{pc=pc+length code}) where
        (exprCode, exprState) = gen expr cs
        code = case exprType of
            IntType             -> exprCode ++ [PrintInt regOut1]
            BoolType            -> exprCode ++ [PrintBool regOut1]
            ArrayType len t     -> case expr of
                Idf identifier  -> case offset lv identifier of
                    Just addr   -> [PrintLocalRange (DirAddr (addr+1)) len] --TODO give type as extra argument
                    Nothing     -> case offset sv identifier of
                        Just addr   -> [PrintSharedRange (DirAddr (addr+1)) len]
                        Nothing     -> error ("variable " ++ identifier ++ " not found.")
                _               -> [] --not supported.

instance CodeGen Expr where
    -- ParExpr
    gen (Par expr) compileState                                             = gen expr compileState

    -- BoolExpr
    gen (Bool bool) cs@CompileState{pc=pc}                                  = ([Load (ImmValue $ intBool bool) regOut1], cs{pc=pc+1})

    -- IdfExpr
    gen (Idf string) cs@CompileState{localVars=lv, sharedVars=sv, pc=pc}    = (code, cs{pc=pc+length code}) where
        localEntryMaybe      = entry lv string
        sharedEntryMaybe     = entry sv string
        code = case localEntryMaybe of
            Just (_, t, localAddr)  -> case t of
                IntType         -> [Load (DirAddr localAddr) regOut1]
                BoolType        -> [Load (DirAddr localAddr) regOut1]
                ArrayType _ _   -> [Load (ImmValue localAddr) regOut1]
            Nothing          -> case sharedEntryMaybe of
                Just (_, t, sharedAddr) -> case t of
                    IntType         -> [ReadInstr (DirAddr sharedAddr), Receive regOut1]
                    BoolType        -> [ReadInstr (DirAddr sharedAddr), Receive regOut1]
                    ArrayType _ _   -> [Load (ImmValue sharedAddr) regOut1]
                Nothing             -> error ("variable " ++ string ++ " not found.")

    --LengthExpr
    gen (Length expr) cs@CompileState{localVars=lv, sharedVars=sv, pc=pc} = (code, cs{pc=pc+length code}) where
        code = case expr of
            Idf string      -> case offset lv string of
                Just localAddr  -> [Load (DirAddr localAddr) regOut1]
                Nothing         -> case offset sv string of
                    Just sharedAddr -> [ReadInstr (DirAddr sharedAddr), Receive regOut1]
                    Nothing         -> error ("variable " ++ string ++ " not found.")

            Array exprs     -> [Load (ImmValue (length exprs)) regOut1]

    -- IntExpr
    gen (Int int) cs@CompileState{pc=pc}                                    = ([Load (ImmValue int) regOut1], cs{pc=pc+1})
    
    -- UnOpExpr
    gen (UnOp op expr) cs@CompileState{pc=pc}                               = (code, unopState{pc=pc+length code}) where
        (exprInstrs, exprState@CompileState{pc=exprPc})     = gen expr cs
        (unopInstrs, unopState)                             = gen op exprState
        code = exprInstrs ++ unopInstrs

    -- BinOpExpr
    gen (BinOp op expr1 expr2) cs@CompileState{localVars=lv, sharedVars=sv, pc=pc, nextLocalOffset=nlo}       = (code, restState) where
        
        (code, restState) = case expr1 of
            Array exprs1 -> case op of
                Equal -> case expr2 of
                    Array exprs2 -> (codez, cs{pc=pc+length codez}) where
                        (arr1Code, arr1State) = gen expr1 cs
                        (arr2Code, arr2State) = gen expr2 arr1State{nextLocalOffset=nlo+length exprs1}
                        nextAddr = nextLocalOffset arr2State + length exprs2
                        arr1StartAddr   = nextAddr+1
                        arr2StartAddr   = nextAddr+2

                        codez = arr1Code ++ [Store regOut1 (DirAddr (arr1StartAddr))] ++
                                arr2Code ++ [Store regOut1 (DirAddr (arr2StartAddr))] ++
                                arrayEqual arr1StartAddr False arr2StartAddr False (nextAddr+3)

                    Idf idf2 -> (codez, cs{pc=pc+length codez}) where
                        (arr1Code, arr1State) = gen expr1 cs

                        nextAddr = nextLocalOffset arr1State
                        arr1StartAddr   = nextAddr+1
                        arr2StartAddr   = nextAddr+2

                        codez = arr1Code ++ [Store regOut1 (DirAddr (arr1StartAddr))] ++
                                case offset lv idf2 of
                                    Just localOffset    -> [Load (ImmValue localOffset) regOut1, Store regOut1 (DirAddr arr2StartAddr)] ++
                                        arrayEqual arr1StartAddr False arr2StartAddr False (nextAddr+3)
                                    Nothing             -> case offset sv idf2 of
                                        Just sharedOffset   -> [Load (ImmValue sharedOffset) regOut1, Store regOut1 (DirAddr arr2StartAddr)] ++
                                            arrayEqual arr1StartAddr False arr2StartAddr True (nextAddr+3)
                                        Nothing         -> error ("variable " ++ idf2 ++ " not found.")

                NotEqual -> gen (UnOp Not (BinOp Equal expr1 expr2)) cs
            
            Idf idf -> case op of
                Equal -> case expr2 of
                    Array exprs2 -> (codez, cs{pc=pc+length codez}) where
                        (arr2Code, arr2State) = gen expr2 cs
                        
                        nextAddr = nextLocalOffset arr2State
                        arr1StartAddr   = nextAddr+1
                        arr2StartAddr   = nextAddr+2

                        codez = case offset lv idf of
                            Just localOffset    ->  [Load (ImmValue localOffset) regOut1, Store regOut1 (DirAddr arr1StartAddr)] ++
                                                    arr2Code ++ [Store regOut1 (DirAddr arr2StartAddr)] ++
                                                    arrayEqual arr1StartAddr False arr2StartAddr False (nextAddr+3)
                            Nothing             -> case offset sv idf of
                                Just sharedOffset   ->  [Load (ImmValue sharedOffset) regOut1, Store regOut1 (DirAddr arr1StartAddr)] ++
                                                        arr2Code ++ [Store regOut1 (DirAddr arr2StartAddr)] ++
                                                        arrayEqual arr1StartAddr True arr2StartAddr False (nextAddr+3)
                                Nothing             -> error ("variable " ++ idf ++ " not found.")

                    Idf idf2 -> (codez, cs{pc=pc+length codez}) where
                        nextAddr = nextLocalOffset cs
                        arr1StartAddr = nextAddr+1
                        arr2StartAddr = nextAddr+2

                        codez = case offset lv idf of
                            Just localOffset    ->  [Load (ImmValue localOffset) regOut1, Store regOut1 (DirAddr arr1StartAddr)] ++ case offset lv idf2 of
                                Just localOffset2   ->  [Load (ImmValue localOffset2) regOut1, Store regOut1 (DirAddr arr1StartAddr)] ++
                                                        arrayEqual arr1StartAddr False arr2StartAddr False (nextAddr+3)
                                Nothing             ->  case offset sv idf2 of
                                    Just sharedOffset2  ->  [Load (ImmValue sharedOffset2) regOut1, Store regOut1 (DirAddr arr2StartAddr)] ++
                                                            arrayEqual arr1StartAddr False arr2StartAddr True (nextAddr+3)
                                    Nothing             -> error ("variable " ++ idf2 ++ " not found.")
                            Nothing             -> case offset sv idf of
                                Just sharedOffset   -> [Load (ImmValue sharedOffset) regOut1, Store regOut1 (DirAddr arr1StartAddr)] ++ case offset lv idf2 of
                                    Just localOffset2   ->  [Load (ImmValue localOffset2) regOut1, Store regOut1 (DirAddr arr1StartAddr)] ++
                                                            arrayEqual arr1StartAddr True arr2StartAddr False (nextAddr+3)
                                    Nothing             ->  case offset sv idf2 of
                                        Just sharedOffset2  ->  [Load (ImmValue sharedOffset2) regOut1, Store regOut1 (DirAddr arr2StartAddr)] ++
                                                                arrayEqual arr1StartAddr True arr2StartAddr True (nextAddr+3)
                                        Nothing             -> error ("variable " ++ idf2 ++ " not found.")
                                Nothing             -> error ("variable " ++ idf ++ " not found.")

                NotEqual -> gen (UnOp Not (BinOp Equal expr1 expr2)) cs
            
            _ ->    (expr1Instrs ++ [Push regOut1] ++ expr2Instrs ++ [Pop regOut2] ++ opInstrs, opState{pc=pc+length code}) where
                        (expr1Instrs, expr1State@CompileState{pc=expr1Pc})  = gen expr1 cs
                        (expr2Instrs, expr2State@CompileState{pc=expr2Pc})  = gen expr2 expr1State{pc=expr1Pc+1}
                        (opInstrs, opState)                                 = gen op expr2State{pc=expr2Pc+1}


    -- TrinOpExpr
    gen (TrinOp op expr lower upper) cs@CompileState{pc=pc}   = (code, opState{pc=pc+length code}) where
        (exprInstrs, exprState@CompileState{pc=exprPc})      = gen expr cs
        (lowerInstrs, lowerState@CompileState{pc=lowerPc})   = gen lower exprState{pc=exprPc+1}
        (upperInstrs, upperState@CompileState{pc=upperPc})   = gen upper lowerState{pc=lowerPc+1}
        (opInstrs, opState)                     = gen op upperState{pc=upperPc+2}
        code = exprInstrs ++ [Push regOut1] ++ lowerInstrs ++ [Push regOut1] ++ upperInstrs ++ [Pop regOut3, Pop regOut2] ++ opInstrs

    -- CrementExpr
    gen (Crem crem string) cs@CompileState{localVars=lv, sharedVars=sv, pc=pc} = (code, crementState{pc=pc+length code}) where
        localAddrMaybe = offset lv string
        sharedAddrMaybe = offset sv string

        (crementInstrs, crementState)   = case localAddrMaybe of
            Just addr   -> gen crem cs{pc=pc+1}
            Nothing     -> case sharedAddrMaybe of
                Just addr   -> gen crem cs{pc=pc+2}
                Nothing     -> error ("variable " ++ string ++ " not found.")

        code = case localAddrMaybe of
            Just localAddr  -> [Load (DirAddr localAddr) regOut1] ++ crementInstrs ++ [Store regOut1 (DirAddr localAddr)]
            Nothing         -> case sharedAddrMaybe of
                Just sharedAddr     -> [ReadInstr (DirAddr sharedAddr), Receive regOut1] ++ crementInstrs ++ [WriteInstr regOut1 (DirAddr sharedAddr)]
                Nothing             -> error ("variable " ++ string ++ " not found.")

    -- AssignExpr
    gen (Ass string expr) cs@CompileState{localVars=lv, sharedVars=sv, pc=pc} = (code, exprState{pc=pc+length code}) where
        (exprCode, exprState)   = gen expr cs

        localEntryMaybe  = entry lv string
        sharedEntryMaybe = entry sv string

        code = case localEntryMaybe of
            Just (localAddr, t, o)  -> case t of
                IntType                 -> exprCode ++ [Store regOut1 (DirAddr o)]
                BoolType                -> exprCode ++ [Store regOut1 (DirAddr o)]
                ArrayType len _         -> case expr of 
                    Array exprs -> fst (gen expr cs{nextLocalOffset=o}) -- The Tricks are real! :D
                    Idf idf     -> case offset lv idf of
                        Just off    -> concat [[Load (DirAddr (off+i)) regOut2, Store regOut2 (DirAddr (o+i))] | i <- [1..len]]
                        Nothing     -> case offset sv idf of
                            Just off    -> concat [[ReadInstr (DirAddr (off+i)), Receive regOut2, Store regOut2 (DirAddr (o+i))] | i <- [1..len]]
                            Nothing     -> error ("variable " ++ idf ++ " not found.")

            Nothing                 -> case sharedEntryMaybe of
                Just (sharedAddr, t, o) -> case t of
                    IntType                 -> exprCode ++ [WriteInstr regOut1 (DirAddr o)]
                    BoolType                -> exprCode ++ [WriteInstr regOut1 (DirAddr o)]
                    ArrayType len _         -> case expr of
                        Array exprs     -> fst (gen assExprs cs) where
                            assExprs = [SpotAss string (Int i) (exprs!!(i-1)) | i <- [1..len]]
                        Idf idf     -> case offset lv idf of
                            Just off    -> concat [[Load (DirAddr (off+i)) regOut2, WriteInstr regOut2 (DirAddr (o+i))] | i <- [1..len]]
                            Nothing     -> case offset sv idf of
                                Just off    -> concat [[ReadInstr (DirAddr (off+i)), Receive regOut2, WriteInstr regOut2 (DirAddr (o+i))] | i <- [1..len]]
                                Nothing     -> error ("variable " ++ idf ++ " not found.")
                Nothing                 -> error ("variable " ++ string ++ " not found.") 

    -- SpotExpr
    gen (Spot identifier indexExpr) cs@CompileState{localVars=lv, sharedVars=sv, pc=pc} = (code, exprState{pc=pc+length code}) where
            (indexCode, exprState)    = gen indexExpr cs

            code = indexCode ++ case offset lv identifier of
                Just addr   -> [Load (ImmValue addr) regOut2, Compute Add regOut1 regOut2 regOut1, Load (IndAddr regOut1) regOut1]

                Nothing     -> case offset sv identifier of
                    Just addr   -> [Load (ImmValue addr) regOut2, Compute Add regOut1 regOut2 regOut1, ReadInstr (IndAddr regOut1), Receive regOut1]

                    Nothing     -> error ("variable " ++ identifier ++ " not found.")

    -- SpotAssExpr
    gen (SpotAss identifier indexExpr valExpr) cs@CompileState{localVars=lv, sharedVars=sv, pc=pc} = (code, valState{pc=pc+length code}) where
        (indexCode, indexExprState@CompileState{pc=indexPc})    = gen indexExpr cs
        (valCode, valState)                                     = gen valExpr indexExprState{pc=indexPc+1}

        code = indexCode ++ [Push regOut1] ++ valCode ++ [Pop regOut2] ++ case offset lv identifier of --index: regOut2, newValue: regOut1
            Just addr   -> [Load (ImmValue addr) regOut3, Compute Add regOut2 regOut3 regOut4, Store regOut1 (IndAddr regOut4)]

            Nothing     -> case offset sv identifier of
                Just addr   -> [Load (ImmValue addr) regOut3, Compute Add regOut2 regOut3 regOut4, WriteInstr regOut1 (IndAddr regOut4)]

                Nothing     -> error ("variable " ++ identifier ++ " not found.")

    -- ArrayExpr
    gen (Array exprs) cs@CompileState{localVars=lv, nextLocalOffset=nlo, pc=pc} = (code, exprsState{nextLocalOffset=nlo, pc=pc+length code}) where
        (exprsCode, exprsState) = evalAndStore exprs cs{nextLocalOffset=nlo+1, pc=pc+2}
        code = [Load (ImmValue (length exprs)) regOut2, Store regOut2 (DirAddr nlo)] ++ exprsCode ++ [Load (ImmValue nlo) regOut1]

        evalAndStore :: [Expr] -> CompileState -> ([Instruction], CompileState)
        evalAndStore [] cs@CompileState{nextLocalOffset=nlo}      = ([], cs{nextLocalOffset=nlo+1})
        evalAndStore (e:es) cs  = (code, restState) where
            (exprCode, exprState@CompileState{nextLocalOffset=exprNLO}) = gen e cs
            (restCode, restState)                                       = evalAndStore es exprState{nextLocalOffset=exprNLO+1}
            code = exprCode ++ [Store regOut1 (DirAddr exprNLO)] ++ restCode

instance CodeGen UnOp where
    -- NegExpr
    gen Neg cs@CompileState{pc=pc}  = ([Load (ImmValue (-1)) regOut2, Compute Mul regOut1 regOut2 regOut1], cs{pc=pc+2})

    -- NotExpr
    gen Not cs@CompileState{pc=pc}  = ([Load (ImmValue $ intBool True) regOut2, Compute Xor regOut1 regOut2 regOut1], cs{pc=pc+2})

instance CodeGen BinOp where
    -- Plus
    gen Plus cs@CompileState{pc=pc}           = ([Compute Add regOut2 regOut1 regOut1], cs{pc=pc+1})

    -- Minus
    gen Minus cs@CompileState{pc=pc}           = ([Compute Sub regOut2 regOut1 regOut1], cs{pc=pc+1})

    -- Times
    gen Times cs@CompileState{pc=pc}            = ([Compute Mul regOut2 regOut1 regOut1], cs{pc=pc+1})

    -- Divide
    gen Divide cs@CompileState{pc=pc}           = ([Compute Div regOut2 regOut1 regOut1], cs{pc=pc+1})

    -- Modulo
    gen Modulo cs@CompileState{pc=pc}           = ([Compute Mod regOut2 regOut1 regOut1], cs{pc=pc+1})

    -- Power
    gen Power cs@CompileState{pc=pc}            = ([Compute Pow regOut2 regOut1 regOut1], cs{pc=pc+1})

    -- LessThan
    gen LessThan cs@CompileState{pc=pc}         = ([Compute Lt regOut2 regOut1 regOut1], cs{pc=pc+1})

    -- LessThanEq
    gen LessThanEq cs@CompileState{pc=pc}       = ([Compute LtE regOut2 regOut1 regOut1], cs{pc=pc+1})

    -- GreaterThan
    gen GreaterThan cs@CompileState{pc=pc}      = ([Compute Gt regOut2 regOut1 regOut1], cs{pc=pc+1})

    -- GreaterThanEq
    gen GreaterThanEq cs@CompileState{pc=pc}    = ([Compute GtE regOut2 regOut1 regOut1], cs{pc=pc+1})

    -- Equal
    gen Equal cs@CompileState{pc=pc}            = ([Compute Equ regOut2 regOut1 regOut1], cs{pc=pc+1})

    -- NotEqual
    gen NotEqual cs@CompileState{pc=pc}         = ([Compute NEq regOut2 regOut1 regOut1], cs{pc=pc+1})

    -- And
    gen LogicAnd cs@CompileState{pc=pc}         = ([Compute And regOut2 regOut1 regOut1], cs{pc=pc+1})

    -- Or
    gen LogicOr cs@CompileState{pc=pc}          = ([Compute Or regOut2 regOut1 regOut1], cs{pc=pc+1})

instance CodeGen TrinOp where
    -- Between (regOut3 < regOut2 < regOut1) ----> (regOut3 < regOut2 && regOut2 < regOut1)
    gen Between cs@CompileState{pc=pc}      = (code, cs{pc=pc+3}) where
        code = [Compute Lt regOut3 regOut2 regOut4, Compute Lt regOut2 regOut1 regOut5, Compute And regOut4 regOut5 regOut1]

    -- Inside (regOut3 <= regOut2 <= regOut1) ----> (regOut3 <= regOut2 && regOut2 <= regOut1)
    gen Inside cs@CompileState{pc=pc}      = (code,  cs{pc=pc+3}) where
        code = [Compute LtE regOut3 regOut2 regOut4, Compute LtE regOut2 regOut1 regOut5, Compute And regOut4 regOut5 regOut1]

    -- Outside (regOut2 < regOut3 || regOut2 > regOut1)
    gen Outside cs@CompileState{pc=pc}      = (code, cs{pc=pc+3}) where
        code = [Compute Lt regOut2 regOut3 regOut4, Compute Gt regOut2 regOut1 regOut5, Compute Or regOut4 regOut5 regOut1]

instance CodeGen Crem where
    -- Increment
    gen Increm cs@CompileState{pc=pc}       = ([Compute Incr regOut1 reg0 regOut1], cs{pc=pc+1})

    -- Decrement
    gen Decrem cs@CompileState{pc=pc}       = ([Compute Decr regOut1 reg0 regOut1], cs{pc=pc+1})



arrayEqual :: Offset -> Bool -> Offset -> Bool -> Offset -> [Instruction]
arrayEqual arr1StartAddr arr1Shared arr2StartAddr arr2Shared nextFreeOffset = code
    where
        i = nextFreeOffset
        equal = nextFreeOffset + 1
        code =  [Store reg0 (DirAddr equal), Store reg0 (DirAddr i)] ++
                [Load (DirAddr i) regOut1 --BEGIN WHILE
                ,Compute Incr regOut1 reg0 regOut1
                ,Store regOut1 (DirAddr i) --verhoog i
                                
                ,Load (DirAddr arr1StartAddr) regOut2
                ,Load (IndAddr regOut2) regOut2         --first elem of arr1
                                
                ,Compute LtE regOut1 regOut1 regOut1     --i <= len arr1
                                
                ,Load (DirAddr equal) regOut3           --equal
                ,Compute And regOut1 regOut3 regOut4    --i <= len arr1 && equal

                ,Load (ImmValue 1) regOut5
                ,Compute Xor regOut4 regOut5 regOut1    --branch if (i <= len arr1 && equal) is false

                ,Branch regOut1 (Rel (14 + intBool arr1Shared + intBool arr2Shared))    --jump to afterwhile
                ,Load (DirAddr i) regOut1               --i

                ,Load (DirAddr arr1StartAddr) regOut2               -- base offset a
                ,Compute Add regOut1 regOut2 regOut3] ++            -- i+offset a
                if arr1Shared
                    then [ReadInstr (IndAddr regOut3), Receive regOut4]
                    else [Load (IndAddr regOut3) regOut4] ++        --a[i]

                [Load (DirAddr arr2StartAddr) regOut2               -- base offset b
                ,Compute Add regOut1 regOut2 regOut3] ++            -- i+offset b
                if arr2Shared
                    then [ReadInstr (IndAddr regOut3), Receive regOut4]
                    else [Load (IndAddr regOut3) regOut5] ++       -- b[i]

                [Compute NEq regOut4 regOut5 regOut3    -- x != y
                ,Load (ImmValue 1) regOut2
                ,Compute Xor regOut3 regOut2 regOut1    -- not (x!=y)

                ,Branch regOut1 (Rel 2)                 --skip (equal becomes false)
                ,Store 0 (DirAddr equal)                --equal = false
                ,Jump (Rel ((-23) - intBool arr1Shared - intBool arr2Shared))

                ,Load (DirAddr equal) regOut1           --return equal                   
                ]
