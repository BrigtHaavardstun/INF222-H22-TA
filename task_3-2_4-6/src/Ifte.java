public class Ifte implements Expr{
    private final Expr a;
    private final Expr b;
    private final Expr c;

    public Ifte(Expr a, Expr b, Expr c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public ValueDomain2 evaluate() throws IllegalAccessException {
        boolean a = this.a.evaluate().getBoolean();
        ValueDomain2 b = this.b.evaluate();
        ValueDomain2 c = this.c.evaluate();

        // a != false -> a is true.
        if (a){
            return b;
        } else {
            return c;
        }
    }
}
