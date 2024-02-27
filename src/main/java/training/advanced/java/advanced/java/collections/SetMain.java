package training.advanced.java.advanced.java.collections;

import training.advanced.java.advanced.java.oo.Car;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetMain {
    public static void main(String[] args) {
        Set<Car> stringsLoc5 = new TreeSet<>();

        Set<String> stringsLoc = new HashSet<>();
        stringsLoc.add("1");
        stringsLoc.add("2");
        stringsLoc.add("3");
        stringsLoc.add("4");
        stringsLoc.add("5");
        stringsLoc.add("6");
        stringsLoc.add("7");
        stringsLoc.add("8");
        stringsLoc.add("9");
        stringsLoc.add("10");
        System.out.println(stringsLoc);

        Set<String> stringsLoc2 = new HashSet<>();
        stringsLoc2.add("5");
        stringsLoc2.add("6");
        stringsLoc2.add("7");
        stringsLoc2.add("8");
        stringsLoc2.add("9");
        stringsLoc2.add("10");
        stringsLoc2.add("11");
        stringsLoc2.add("12");
        stringsLoc2.add("13");
        stringsLoc2.add("14");
        System.out.println(stringsLoc2);

        Set<String> tempLoc = new HashSet<>(stringsLoc);
        tempLoc.retainAll(stringsLoc2);
        System.out.println(tempLoc);

        Set<String> tempLoc2 = new HashSet<>(stringsLoc);
        tempLoc2.removeAll(stringsLoc2);
        System.out.println(tempLoc2);

        Set<String> tempLoc4 = new HashSet<>(stringsLoc);
        tempLoc4.addAll(stringsLoc2);
        System.out.println(tempLoc4);

        Set<String> tempLoc3 = new HashSet<>(stringsLoc);
        System.out.println("alt küme : " + tempLoc3.containsAll(stringsLoc2));

//        stringsLoc.addAll();
//        stringsLoc.containsAll();
//        stringsLoc.retainAll();
//        stringsLoc.removeAll();
    }
}
