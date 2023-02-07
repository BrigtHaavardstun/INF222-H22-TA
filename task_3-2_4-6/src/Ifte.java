public class Ifte implements Expr{
    private Expr a;
    private Expr b;
    private Expr c;

    public Ifte(Expr a, Expr b, Expr c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public ValueDomain2 evaluate(){
        short a = this.a.evaluate().getValue();
        ValueDomain2 b = this.b.evaluate();
        ValueDomain2 c = this.c.evaluate();

        // a != false -> a is true.
        if (a != new F().evaluate().getValue()){
            return b;
        } else {
            return c;
        }
    }
}
