public interface ValueDomain2 {
    short getValue();
}

class ValueDomain2C implements ValueDomain2{
    private short a; // int16

    /**
     * Create a new ValueDomain2 class with a given short.
     * @param a
     */
    public ValueDomain2C(short a)
    {
        this.a =a;
    }

    /**
     * Lets us write new ValueDomain2C(5); 5 is normally read as a int, and hence this would parse.
     * @param a
     */
    public ValueDomain2C(int a){
        if(a < 0){
            a = 0;
        }
        this.a =((short)a);
    }

    /**
     * Get value of this ValueDomain2 class
     * @return
     */
    public short getValue() {
        return a;
    }

    /**
     * Print the value of the ValueDomain2C class.
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(getValue());
    }
}