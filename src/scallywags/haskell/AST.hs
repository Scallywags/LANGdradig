module AST where

type NumSprockells = Int
type SprockellID = Int

data Prog   = Prog NumSprockells [Stat] deriving (Show, Eq)

data Stat   = Decl String Type
            | DeclShared String Type
            | Block [Stat]
            | Expr Expr
            | IfThen Expr Stat
            | IfThenElse Expr Stat Stat
            | While Expr Stat
            | Fork SprockellID Stat
            | Join SprockellID
            | Sync String Stat
            deriving (Show, Eq)

data Expr   = Par Expr
            | Bool Bool
            | Idf String
            | Int Int
            | Array [Expr]                                      --TODO fix codegen for array cases.
            | UnOp UnOp Expr
            | BinOp BinOp Expr Expr
            | TrinOp TrinOp Expr Expr Expr
            | Crem Crem String
            | Ass String Expr
            deriving (Show, Eq)

data Crem   = Increm
            | Decrem
            deriving (Show, Eq)

data TrinOp = Between
            | Inside
            | Outside
            deriving (Show, Eq)

data BinOp  = Plus
            | Minus
            | Times
            | Divide
            | Modulo
            | Power
            | LessThan
            | LessThanEq
            | GreaterThan
            | GreaterThanEq
            | Equal
            | NotEqual
            | LogicAnd
            | LogicOr
            deriving (Show, Eq)

data UnOp   = Neg
            | Not
            deriving (Show, Eq)

data Type   = IntType
            | BoolType
            | ArrayType Int Type
            deriving (Show, Eq)

