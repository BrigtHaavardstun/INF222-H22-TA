public class Plus implements Expr{
    private Expr a;
    private Expr b;

    @Override
    public ValueDomain2 evaluate() {
        return new ValueDomain2C(a.evaluate().getValue() + b.evaluate().getValue());
    }
}
