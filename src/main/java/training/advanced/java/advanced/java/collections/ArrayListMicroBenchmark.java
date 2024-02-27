package training.advanced.java.advanced.java.collections;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMicroBenchmark {

    public static void main(String[] args) throws Exception {
        List<String> stringListLoc = new ArrayList<>(1_200_000);

        for (int i = 0; i < 20_000; i++) {
            stringListLoc.add("test");
            stringListLoc.get(i);
        }

        for (int i = 0; i < 20_000; i++) {
            stringListLoc.remove(0);
        }

        Thread.sleep(1_000);
        System.gc();
        Thread.sleep(1_000);

        long delta = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            stringListLoc.add("test");
        }

        System.out.println("Add delta : " + (System.currentTimeMillis() - delta));

        delta = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            stringListLoc.get(i);
        }

        System.out.println("Get delta : " + (System.currentTimeMillis() - delta));

        delta = System.currentTimeMillis();
        for (String stringLoc : stringListLoc) {

        }
        System.out.println("Tra delta : " + (System.currentTimeMillis() - delta));

        delta = System.currentTimeMillis();
        for (int i = 0; i < 1_000; i++) {
            stringListLoc.remove(0);
        }

        System.out.println("Remove delta : " + (System.currentTimeMillis() - delta));

        delta = System.currentTimeMillis();
        for (int i = 0; i < 1_000; i++) {
            stringListLoc.contains(i);
        }

        System.out.println("Contains delta : " + (System.currentTimeMillis() - delta));

    }
}
