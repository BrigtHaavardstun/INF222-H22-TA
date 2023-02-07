public class Le implements Expr{
    private final Expr a;
    private final Expr b;

    public Le(Expr a, Expr b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public ValueDomain2 evaluate() throws IllegalAccessException {
        short a = this.a.evaluate().getShort();
        short b = this.b.evaluate().getShort();

        if(a <= b){
            return new T().evaluate();
        } else {
            return new F().evaluate();
        }
    }
}
