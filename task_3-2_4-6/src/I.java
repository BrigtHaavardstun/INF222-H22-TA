public class I implements Expr{

    private Expr i;

    public I(Expr i) {
        this.i = i;
    }


    @Override
    public ValueDomain2 evaluate() {
        return new ValueDomain2C(i.evaluate().getValue()+ 1);
    }
}
