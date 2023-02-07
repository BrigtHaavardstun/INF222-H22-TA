public interface Expr {
    default ValueDomain2 evaluate(Expr expr){
        ValueDomain2 toReturn = null;
        if (expr instanceof Z){
            toReturn = new ValueDomain2C(0);
        } else if (expr instanceof I){
            Expr exprI = ((I) expr).i;
            ValueDomain2 valueD = evaluate(exprI);
            toReturn = new ValueDomain2C(valueD.getValue() + 1);
        } else if (expr instanceof Plus) {
            Expr a = ((Plus) expr).a;
            ValueDomain2 valueA = evaluate(a);
            Expr b = ((Plus) expr).b;
            ValueDomain2 valueB = evaluate(b);
            toReturn = new ValueDomain2C(valueA.getValue() + valueB.getValue());
        } else if (expr instanceof Mult) {
            Expr a = ((Mult) expr).a;
            ValueDomain2 valueA = evaluate(a);
            Expr b = ((Mult) expr).b;
            ValueDomain2 valueB = evaluate(b);
            toReturn = new ValueDomain2C(valueA.getValue() * valueB.getValue());
        } else if( expr instanceof Minus){
            Expr a = ((Minus) expr).a;
            ValueDomain2 valueA = evaluate(a);
            Expr b = ((Minus) expr).b;
            ValueDomain2 valueB = evaluate(b);
            short valA = valueA.getValue();
            short valB = valueB.getValue();
            if (valA < valB){
                toReturn = new ValueDomain2C(0);
            } else {
                toReturn = new ValueDomain2C(valA-valB);
            }

        } else {
            throw new IllegalArgumentException("We have not defined evaluator for this type! " + expr);
        }

        return toReturn;


    }
}

class Z implements Expr{}

class I implements Expr{
    Expr i;
}

class Plus implements Expr{
    Expr a;
    Expr b;
}

class Mult implements Expr{
    Expr a;
    Expr b;
}

class Minus implements Expr{
    Expr a;
    Expr b;
}