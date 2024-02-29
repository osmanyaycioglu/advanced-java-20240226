package training.advanced.java.advanced.java.streams;

import training.advanced.java.advanced.java.annotations.Customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMain5 {
    public static void main(String[] args) {
        List<String> stringsLoc = Arrays.asList("osman",
                                                "ali",
                                                "veli",
                                                "osman",
                                                "ayşe");
        Set<Character> collectLoc = stringsLoc.stream()
                                              .distinct()
                                              .map(s -> Customer.builder()
                                                                .withNameParam(s)
                                                                .build())
                                              .filter(c -> c.getName()
                                                            .length() > 2)
                                              .filter(s -> s.getSurname() == null)
                                              .flatMap(c -> {
                                                  char[] charArrayLoc = c.getName()
                                                                         .toCharArray();
                                                  List<Character> charactersLoc = new ArrayList<>();
                                                  for (char cLoc : charArrayLoc) {
                                                      charactersLoc.add(cLoc);
                                                  }
                                                  return charactersLoc.stream();
                                              })
                                              .collect(Collectors.toSet());


        System.out.println("-------------");
        System.out.println("result : " + collectLoc);

        Set<Stream<Character>> collectLoc1 = stringsLoc.stream()
                                                       .distinct()
                                                       .map(s -> Customer.builder()
                                                                         .withNameParam(s)
                                                                         .build())
                                                       .filter(c -> c.getName()
                                                                     .length() > 2)
                                                       .filter(s -> s.getSurname() == null)
                                                       .map(c -> {
                                                           char[] charArrayLoc = c.getName()
                                                                                  .toCharArray();
                                                           List<Character> charactersLoc = new ArrayList<>();
                                                           for (char cLoc : charArrayLoc) {
                                                               charactersLoc.add(cLoc);
                                                           }
                                                           return charactersLoc.stream();
                                                       })
                                                       .collect(Collectors.toSet());

    }
}
