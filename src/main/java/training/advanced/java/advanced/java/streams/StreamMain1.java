package training.advanced.java.advanced.java.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamMain1 {
    public static void main(String[] args) {
        List<String> stringsLoc = Arrays.asList("osman",
                                                "ali",
                                                "veli",
                                                "osman",
                                                "ayşe");
        List<String> result1 = new ArrayList<>();
        stringsLoc.stream()
                  .skip(2)
                  .distinct()
                  .peek(s -> result1.add(s))
                  .filter(s -> s.length() > 2)
                  .filter(s -> s.contains("a"))
                  .forEach(System.out::println);

        System.out.println("-------------");
        System.out.println("result1 : " + result1);
    }
}
