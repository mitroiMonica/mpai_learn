package singleton_v2;

//eager instantiation
//but now we cannot use params for the instance
public class Singleton {
    public static final Singleton instance = new Singleton();

    //or we can use static constructor:
//    static {
//        instance = new Singleton();
//    }

    private Singleton() {
    }
}
