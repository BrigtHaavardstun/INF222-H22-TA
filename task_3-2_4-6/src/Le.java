public class Le implements Expr{
    private Expr a;
    private Expr b;

    public Le(Expr a, Expr b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public ValueDomain2 evaluate() {
        short a = this.a.evaluate().getValue();
        short b = this.b.evaluate().getValue();

        if(a <= b){
            return new T().evaluate();
        } else {
            return new F().evaluate();
        }
    }
}
