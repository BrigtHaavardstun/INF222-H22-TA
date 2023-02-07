public class Not implements Expr{
    private Expr a;
    @Override
    public ValueDomain2 evaluate() {
        short a = this.evaluate().getValue();
        // a == 0 -> a is false. a!=0 -> a is true.
        if(a == new F().evaluate().getValue()){
            return new T().evaluate();
        } else {
            return new F().evaluate();
        }
    }
}
