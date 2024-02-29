package training.advanced.java.advanced.java.streams;

import training.advanced.java.advanced.java.annotations.Customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain9 {
    public static void main(String[] args) {
        List<String> stringsLoc = Arrays.asList("osman",
                                                "ali",
                                                "veli",
                                                "osman",
                                                "ayşe");
        List<Customer> collectLoc = stringsLoc.stream()
                                              .distinct()
                                              .map(s -> Customer.builder()
                                                                .withNameParam(s)
                                                                .build())
                                              .filter(c -> c.getName()
                                                            .length() > 2)
                                              .filter(s -> s.getSurname() == null)
                                              .collect(new MyCollector<Customer>());

        System.out.println(collectLoc);

    }
}
