public class Plus implements Expr{
    private final Expr a;
    private final Expr b;

    public Plus(Expr a, Expr b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public ValueDomain2 evaluate() throws IllegalAccessException {
        return new ValueDomain2C(a.evaluate().getShort() + b.evaluate().getShort());
    }
}
