public class Or implements Expr{
    private Expr a;
    private Expr b;

    @Override
    public ValueDomain2 evaluate() {
        short a = this.a.evaluate().getValue();
        short b = this.b.evaluate().getValue();
        if (a != 0 || b != 0){
            return new T().evaluate();
        }
        return new F().evaluate();
    }
}
