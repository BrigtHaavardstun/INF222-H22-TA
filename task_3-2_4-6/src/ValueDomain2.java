public interface ValueDomain2 {
    short getShort() throws IllegalAccessException;
    boolean getBoolean() throws IllegalAccessException;
}

class ValueDomain2C implements ValueDomain2{
    private short a; // int16
    private boolean b;

    private boolean isShort;

    /**
     * Create a new ValueDomain2 class with a given short.
     * @param a
     */
    public ValueDomain2C(short a)
    {
        this.a =a;
        this.isShort = true;
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
        this.isShort = true;
    }

   public ValueDomain2C(boolean b){
        this.b = b;
        this.isShort = false;
   }


    /**
     * Print the value of the ValueDomain2C class.
     * @return
     */
    @Override
    public String toString() {
        if(isShort){
            return String.valueOf(a);
        }
        else{
            return String.valueOf(b);
        }
    }

    @Override
    public short getShort() throws IllegalAccessException {
        if(isShort) {
            return a;
        }
        throw new IllegalAccessException("Can not ask for short when a bool is stored");
    }

    @Override
    public boolean getBoolean() throws IllegalAccessException {
        if(! isShort) {
            return b;
        }
        throw new IllegalAccessException("Can not ask for bool when a short is stored");

    }
}