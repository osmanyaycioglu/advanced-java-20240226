package training.advanced.java.advanced.java.multithread;

public class ThreadMain {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            CounterThread threadLoc = new CounterThread();
            threadLoc.setName("CT-" + i);
            threadLoc.start();
        }
        try {
         Thread.sleep(5_000);
        } catch (Exception exp) {
        }
        System.out.println(CounterThread.counter);
        System.out.println(CounterThread.acounter);
        System.out.println(CounterThread.scounter);
        System.out.println(CounterThread.lcounter);
        System.out.println(CounterThread.vcounter);
    }
}
