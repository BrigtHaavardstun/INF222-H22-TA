public interface ValueDomain2 {
    short getValue();
}

class ValueDomain2C implements ValueDomain2{
    private short a;
    public ValueDomain2C(short a){
        this.a =a;
    }

    public ValueDomain2C(int a){
        this.a =((short)a);
    }

    public short getValue() {
        return a;
    }
}