public class And implements Expr{
    private final Expr a;
    private final Expr b;

    public And(Expr a, Expr b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public ValueDomain2 evaluate() throws IllegalAccessException {
        boolean a = this.a.evaluate().getBoolean();
        boolean b = this.b.evaluate().getBoolean();
        if (a && b){
            return new T().evaluate();
        }
        return new F().evaluate();
    }
}
