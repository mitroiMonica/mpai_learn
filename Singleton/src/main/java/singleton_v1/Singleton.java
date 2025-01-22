package singleton_v1;

//lazy instantiation
//if params needed - we transfer them via getInstance method and initialize them with param constructor
public class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    public synchronized static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
