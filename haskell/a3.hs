{-
    if(T < (Succ Zero) * (Succ (Succ T)))
    {
        T + T
    }
    else
    {
        (Succ Zero) < F
    }
-}


module A3 where
import BTL3
import qualified BTL2

data Expr' = Z 
        | I Expr' 
        | T 
        | F deriving (Eq, Show)

type ValueDomain' = Expr'

eval' :: BTL2.Expr -> ValueDomain'
eval' e = toExpr' $ BTL2.eval' e

toExpr' :: BTL2.Expr-> ValueDomain'
toExpr' BTLqualified2.T = T
toExpr' BTL2.F = F
toExpr' BTL2.Z = Z
toExpr' (BTL2.I e) = case toExpr' e of
                    (I e2) -> I( I e2)
                    Z -> (I Z)
                    _ -> error "Expression did not evaluate to a Natural"
toExpr' _ = error "Expression is not a valid expr type"


--3.2.2

fromVD'' :: ValueDomain''->ValueDomain'
fromVD'' (VI i) = (iterate I Z) !! i
fromVD'' (VB True) = T
fromVD'' (VB False) = F

toVD'' :: ValueDomain' -> ValueDomain''
toVD'' Z = VI 0
toVD'' I i = VI $ toInt i
toVD'' T = VB True
toVD'' F = VB False

toInt :: Expr' -> Integer
toInt Z = 0
toInt (I i) =1 + toInt i


assertISO1 a = a == toVD'' (fromVD'' a)
assertISO2 b = b == fromVD'' (toVD'' b)
assertISO a b = assertISO1 a && assertISO2 b