
    
{-
3.1.1
The concrete syntax for
    Ifte (Le T (Mult ( I Z) ( I ( I T))) ) 
        ( Plus T T) 
        (Le ( I Z) F)
would look something like this

    if (T < (Succ Zero) * (Succ (Succ T))) 
    {
        T + T
    } 
    else{
        (Succ Zero) < F
    }

3.1.3
An AST does not have any meaning on its own. Depending on the evaulator it might make sense or it might not. 
This is demonstated in 3.1.2 were the result depends on the evaluator.

-}

--3.3
--Note: Think there might have been a typo in the task and it was supposed to be Expr' instead of Expr
module Solution where
import BTL3
import qualified BTL2


data Expr' 
    = Z 
    | I Expr' -- Typo in assignment, should be Expr'
    | T 
    | F
    deriving (Eq)--needed for 3.3.4

type ValueDomain' = Expr'-- Typo in assignment, should be Expr'

--3.3.1
eval' :: BTL2.Expr->ValueDomain'
eval' = toEval'. BTL2.eval' --Eval using BTL2's eval and then cast to Expr'

toEval' :: BTL2.Expr->ValueDomain'
toEval' BTL2.T = T
toEval' BTL2.F = F
toEval' BTL2.Z = Z
toEval' (BTL2.I e) = case toEval' e of --Check that Succ is applied to a valid type
                (I e2) -> I (I e2)
                Z -> I Z
                _ -> error "Expression did not evaluate to a Natural"
toEval' _ = error "Expression did not evaluate to a valid result"

--3.3.2
fromVD'' :: ValueDomain''->Expr'
fromVD'' (BTL3.VI i) = (iterate I Z) !! (fromInteger i)
fromVD'' (BTL3.VB True) = T
fromVD'' (BTL3.VB False) = F

--3.3.3
toVD'' :: Expr' -> ValueDomain''
toVD'' Z = BTL3.VI 0
toVD'' a@(I i) = VI $ toInt a
toVD'' T = BTL3.VB True
toVD'' F = BTL3.VB False

toInt :: Expr'->Integer
toInt (I i) = 1 + toInt i
toInt Z = 0

--3.3.4
assertIso :: BTL3.ValueDomain'' -> ValueDomain' -> Bool
assertIso a b = assertIso1 a && assertIso2 b 

assertIso1 :: BTL3.ValueDomain'' -> Bool
assertIso1 a = a == toVD'' (fromVD'' a)

assertIso2 :: ValueDomain' -> Bool
assertIso2 b = b == fromVD'' (toVD'' b)