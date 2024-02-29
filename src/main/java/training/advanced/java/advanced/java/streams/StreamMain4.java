package training.advanced.java.advanced.java.streams;

import training.advanced.java.advanced.java.annotations.Customer;

import java.util.*;

public class StreamMain4 {
    public static void main(String[] args) {
        List<String> stringsLoc = Arrays.asList("osman",
                                                "ali",
                                                "veli",
                                                "osman",
                                                "ayşe");
        List<String> result1 = new ArrayList<>();
        ArrayList<Customer> reduceLoc = stringsLoc.stream()
                                                  .distinct()
                                                  .map(s -> Customer.builder()
                                                                    .withNameParam(s)
                                                                    .build())
                                                  .filter(c -> c.getName()
                                                                .length() > 2)
                                                  .filter(s -> s.getSurname() == null)
                                                  .reduce(new ArrayList<Customer>(),
                                                          (al, c) -> {
                                                              al.add(c);
                                                              return al;
                                                          },
                                                          (al1, al2) -> {
                                                              al1.addAll(al2);
                                                              return al1;
                                                          });


        System.out.println("-------------");
        System.out.println("result1 : " + result1);

        stringsLoc.stream()
                  .distinct()
                  .map(s -> Customer.builder()
                                    .withNameParam(s)
                                    .build())
                  .filter(c -> c.getName()
                                .length() > 2)
                  .filter(s -> s.getSurname() == null)
                  .reduce(new HashSet<String>(),
                          (hs, c) -> {
                              hs.add(c.getName());
                              return hs;
                          },
                          (al1, al2) -> {
                              al1.addAll(al2);
                              return al1;
                          });
        TreeSet<Character> reduceLoc1 = stringsLoc.stream()
                                                  .distinct()
                                                  .map(s -> Customer.builder()
                                                                    .withNameParam(s)
                                                                    .build())
                                                  .filter(c -> c.getName()
                                                                .length() > 2)
                                                  .filter(s -> s.getSurname() == null)
                                                  .reduce(new TreeSet<Character>(),
                                                          (hs, c) -> {
                                                              char[] charArrayLoc = c.getName()
                                                                                     .toCharArray();
                                                              List<Character> charactersLoc = new ArrayList<>();
                                                              for (char cLoc : charArrayLoc) {
                                                                  charactersLoc.add(cLoc);
                                                              }
                                                              hs.addAll(charactersLoc);
                                                              return hs;
                                                          },
                                                          (al1, al2) -> {
                                                              al1.addAll(al2);
                                                              return al1;
                                                          });
        System.out.println(reduceLoc1);
    }
}
