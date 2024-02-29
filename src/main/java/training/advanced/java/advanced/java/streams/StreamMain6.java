package training.advanced.java.advanced.java.streams;

import training.advanced.java.advanced.java.annotations.Customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamMain6 {
    public static void main(String[] args) {
        List<String> stringsLoc = Arrays.asList("osman",
                                                "ali",
                                                "veli",
                                                "osman",
                                                "ayşe");
        boolean bLoc = stringsLoc.stream()
                                 .distinct()
                                 .map(s -> Customer.builder()
                                                   .withNameParam(s)
                                                   .build())
                                 .filter(c -> c.getName()
                                               .length() > 2)
                                 .filter(s -> s.getSurname() == null)
                                 .peek(c -> System.out.println("before allMatch : " + c))
                                 .allMatch(c -> c.getName()
                                                 .contains("a"));

        System.out.println("-------------");
        System.out.println("result1 : " + bLoc);
        boolean bLoc1 = stringsLoc.stream()
                                  .distinct()
                                  .map(s -> Customer.builder()
                                                    .withNameParam(s)
                                                    .build())
                                  .filter(c -> c.getName()
                                                .length() > 2)
                                  .filter(s -> s.getSurname() == null)
                                  .peek(c -> System.out.println("before allMatch : " + c))
                                  .noneMatch(c -> c.getName()
                                                   .contains("a"));
        System.out.println("result2 : " + bLoc1);
        System.out.println("---------------------------------------");

        Optional<Customer> anyLoc = stringsLoc.stream()
                                              .distinct()
                                              .map(s -> Customer.builder()
                                                                .withNameParam(s)
                                                                .build())
                                              .filter(c -> c.getName()
                                                            .length() > 2)
                                              .filter(s -> s.getSurname() == null)
                                              .peek(c -> System.out.println("before allMatch : " + c))
                                              .findAny();

        Customer customerLoc = anyLoc.orElse(null);
        System.out.println("result3 : " + customerLoc);

    }
}
