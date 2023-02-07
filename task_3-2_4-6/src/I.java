public class I implements Expr{

    private final Expr i;

    public I(Expr i) {
        this.i = i;
    }


    @Override
    public ValueDomain2 evaluate() throws IllegalAccessException {
        return new ValueDomain2C(i.evaluate().getShort()+ 1);
    }
}
