package training.advanced.java.advanced.java.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapMain {
    public static void main(String[] args) {
        Map<String, String> mapLoc = new HashMap<>();
        mapLoc.put("osman",
                   "deneme1");
        mapLoc.put("osman",
                   "deneme2");
        mapLoc.put("ali",
                   "deneme2");
        mapLoc.put("veli",
                   "deneme2");
        mapLoc.put("ayşe",
                   "deneme2");

        System.out.println(mapLoc);

        Set<String> keysLoc = mapLoc.keySet();
        for (String keyLoc : keysLoc) {
            String stringLoc = mapLoc.get(keyLoc);
            System.out.println("Key : " + keyLoc + " value : " + stringLoc);
        }

        Collection<String> valuesLoc = mapLoc.values();
        for (String valueLoc : valuesLoc) {
            System.out.println(valueLoc);
        }

        Set<Map.Entry<String, String>> entriesLoc = mapLoc.entrySet();
        for (Map.Entry<String, String> entryLoc : entriesLoc) {
            System.out.println("Key : " + entryLoc.getKey() + " Value : " + entryLoc.getValue());
        }
    }
}
