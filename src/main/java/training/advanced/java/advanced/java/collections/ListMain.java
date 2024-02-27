package training.advanced.java.advanced.java.collections;

import java.util.ArrayList;
import java.util.List;

public class ListMain {
    public static void main(String[] args) {
        List<String> stringListLoc = new ArrayList<>();

        String[] stringsLoc  = new String[10];
        String[] stringsLoc2 = new String[20];
        System.arraycopy(stringsLoc,
                         0,
                         stringsLoc2,
                         0,
                         10);

        // ArrayList ler ekle sıralı yada index ile işlelerde kullanılır
        stringListLoc.add("osman");
        stringListLoc.add("ali");
        stringListLoc.add("veli");
        stringListLoc.add("ayşe");

        for (String stringLoc : stringListLoc) {
            System.out.println(stringLoc);
        }
        String stringLoc = stringListLoc.get(3);

        stringListLoc.remove(2);
    }
}
