package training.advanced.java.advanced.java.multithread;

import java.util.concurrent.*;

public class ThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorServiceLoc = Executors.newFixedThreadPool(4);
        executorServiceLoc.execute(()-> System.out.println("hello world"));
        Runnable runnableLoc = ()-> {
            try {
                Thread.sleep(1_000);
            } catch (Exception exp) {
            }
            System.out.println("Bitti");
        };
        for (int i = 0; i < 40; i++) {
            executorServiceLoc.execute(runnableLoc);
        }
        Callable<String> callableLoc = () -> "callable çalıştı";
        Future<String>   submitLoc   = executorServiceLoc.submit(callableLoc);
        System.out.println("Çalışmaya devam ediyorum 1");
        System.out.println("Çalışmaya devam ediyorum 2");
        System.out.println("Çalışmaya devam ediyorum 3");
        String stringLoc = submitLoc.get();
        System.out.println("Cevap geldi : " + stringLoc);
        System.out.println("Main thread öldü");
    }
}
