public class Mult implements Expr{
    private Expr a;
    private Expr b;

    public Mult(Expr a, Expr b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public ValueDomain2 evaluate() {
        return new ValueDomain2C(a.evaluate().getValue()*b.evaluate().getValue());
    }
}
