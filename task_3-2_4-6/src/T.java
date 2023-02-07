public class T implements Expr{
    /**
     * We say that a value evaluates to true if it is not 0.
     * @return
     */
    @Override
    public ValueDomain2 evaluate() {
        return new ValueDomain2C(true);
    }
}
