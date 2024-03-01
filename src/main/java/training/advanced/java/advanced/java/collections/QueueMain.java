package training.advanced.java.advanced.java.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.*;

public class QueueMain {
    public static void main(String[] args) {
        Queue<String> stringsLoc = new ArrayBlockingQueue<>(1_000); // FIFO
        String        pollLoc    = stringsLoc.poll();

        BlockingQueue<String> bstringsLoc = new ArrayBlockingQueue<>(1_000); // FIFO
        try {
            String takeLoc = bstringsLoc.poll(3, TimeUnit.SECONDS);
            System.out.println("timeout mu? : " + takeLoc);
        } catch (Exception eParam) {
            eParam.printStackTrace();
        }

        Deque<String>         dequeLoc         = new ArrayDeque<>(); // FIFO FILO LIFO LILO
        dequeLoc.poll();
        dequeLoc.pollFirst();
        dequeLoc.pollLast();
        dequeLoc.add("osman");
        dequeLoc.addFirst("first");
        dequeLoc.addLast("last");
        BlockingDeque<String> blockingDequeLoc = new LinkedBlockingDeque<>();
        try {
            blockingDequeLoc.take();
            blockingDequeLoc.takeFirst();
            blockingDequeLoc.takeLast();
        } catch (InterruptedException eParam) {
            eParam.printStackTrace();
        }


    }
}
