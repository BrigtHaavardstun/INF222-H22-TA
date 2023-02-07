public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        // Create the boolean expression found in BTL2.hs
        Expr expr0 = new Z(); // 0
        Expr expr1 = new  I(new I( new I(new Z()))); // 3
        Expr expr2 = new Plus(new Mult(new I(new I(new Z())), new I(new I(new I(new Z())))), new I( new Z())); // 7
        Expr expr3 = new Minus(expr2,expr1); // 4
        Expr expr4 = new Mult(expr1,new Plus(expr2, expr3)); // 33
        Expr expr5 = new Plus(new Mult(expr0, expr1), new Minus(expr2, expr4)); // 0: 0*3 + 7-33 -> 0
        Expr expr6 = new Minus(new I(new Mult(expr4, expr4)), new Plus(expr4,expr4)); // 1024: 1 + 33*33 - 66 -> 1024
        Expr expr7 = new Ifte(new Le(expr1, expr3), expr5, expr6); // 0: 3<=4 -> expr5 -> 0.
        Expr expr8 = new T(); // True
        Expr expr9 = new F(); // False
        Expr expr10 = new And(expr8,expr9); // False
        Expr expr11 = new Or(expr8,expr9); // True
        Expr expr12 = new Not(expr10); //True
        Expr expr13 = new Ifte(expr11, new Le(expr4,expr5), expr12); // False




        // Evaluate at them and check the output
        System.out.println("expr0: " + expr0.evaluate());
        System.out.println("expr1: " + expr1.evaluate());
        System.out.println("expr2: " + expr2.evaluate());
        System.out.println("expr3: " + expr3.evaluate());
        System.out.println("expr4: " + expr4.evaluate());
        System.out.println("expr5: " + expr5.evaluate());
        System.out.println("expr6: " + expr6.evaluate());
        System.out.println("expr7: " + expr7.evaluate());
        System.out.println("expr8: " + expr8.evaluate());
        System.out.println("expr9: " + expr9.evaluate());
        System.out.println("expr10: " + expr10.evaluate());
        System.out.println("expr11: " + expr11.evaluate());
        System.out.println("expr12: " + expr12.evaluate());
        System.out.println("expr13: " + expr13.evaluate());



    }
}