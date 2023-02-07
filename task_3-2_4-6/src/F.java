public class F implements Expr{

    /**
     * Zero is false.
     * @return
     */
    @Override
    public ValueDomain2 evaluate() {
        return new ValueDomain2C(0);
    }
}
