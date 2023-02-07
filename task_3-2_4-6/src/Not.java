public class Not implements Expr{
    private final Expr a;

    public Not(Expr a) {
        this.a = a;
    }

    @Override
    public ValueDomain2 evaluate() throws IllegalAccessException {
        boolean a = this.a.evaluate().getBoolean();
        return new ValueDomain2C(!a);

    }
}
