package training.advanced.java.advanced.java.multithread;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

public class CounterThread extends Thread {

    public static          long          counter       = 0;
    public static          AtomicLong    acounter      = new AtomicLong();
    public static          long          scounter      = 0;
    public static          long          lcounter      = 0;
    public static volatile long          vcounter      = 0;
    public static          ReentrantLock reentrantLock = new ReentrantLock();


    public static void increaseWithLock() {
        reentrantLock.lock();
        try {
            lcounter++;
        } catch (Exception exp) {
        } finally {
            reentrantLock.unlock();
        }
    }

    public static synchronized void increase() {
        scounter++;
    }

    public static void increase2() {
        synchronized (CounterThread.class) {
            scounter++;
        }
    }

    // Yanlış
    public synchronized void increaseLocal() {
        scounter++;
    }

    // Yanlış
    public void increaseLocal2() {
        synchronized (this) {
            scounter++;
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 5_000_000; i++) {
            counter++;
            acounter.incrementAndGet();
            increase();
            increaseWithLock();
            if (interrupted()) {
                return;
            }
            vcounter++;
            //            try {
//                Thread.sleep(1_000);
//            } catch (Exception exp) {
//            }

        }
        System.out.println("I am out " + getName());
    }

}
