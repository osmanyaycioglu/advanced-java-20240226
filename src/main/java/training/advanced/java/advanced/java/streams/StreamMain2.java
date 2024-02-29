package training.advanced.java.advanced.java.streams;

import training.advanced.java.advanced.java.annotations.Customer;
import training.advanced.java.advanced.java.oo.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamMain2 {
    public static void main(String[] args) {
        List<String> stringsLoc = Arrays.asList("osman",
                                                "ali",
                                                "veli",
                                                "osman",
                                                "ayşe");
        List<String> result1 = new ArrayList<>();
        stringsLoc.stream()
                  .distinct()
                  .map(s -> Customer.builder()
                                    .withNameParam(s)
                                    .build())
                  .filter(c -> c.getName()
                                .length() > 2)
                  .filter(s -> s.getSurname() == null)
                  .forEach(System.out::println);

        System.out.println("-------------");
        System.out.println("result1 : " + result1);
    }
}
