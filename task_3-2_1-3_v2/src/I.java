public class I implements Expr{

    private Expr i;


    @Override
    public ValueDomain2 evaluate() {
        return new ValueDomain2C(i.evaluate().getValue()+ 1);
    }
}
