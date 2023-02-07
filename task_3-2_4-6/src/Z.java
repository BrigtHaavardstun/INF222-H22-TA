public class Z implements Expr {
    @Override
    public ValueDomain2 evaluate() {
        return new ValueDomain2C(0);
    }
}
