package training.advanced.java.advanced.java.multithread;

public class MySingleton {
    private static volatile MySingleton mySingleton;

    private MySingleton() {
    }

    public static  MySingleton getInstance() {      // TH1 TH2
        if (mySingleton == null) {                  // TH1 TH2
            synchronized(MySingleton.class) {       // TH1 TH2
                if (mySingleton == null) {           // TH1
                    mySingleton = new MySingleton();    // TH1
                }
            }
        }
        return mySingleton;
    }
}
