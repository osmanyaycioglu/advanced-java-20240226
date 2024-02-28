package training.advanced.java.advanced.java.newfeatures.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.*;

public class LambdaMain3 {
    public static void main(String[] args) {
        IProcess<String, Integer> processStr  = String::length;
        Function<String, String>  functionLoc = s -> s + " function returned";
        BiFunction<String,String,Integer> biFunctionLoc = (s1,s2) -> s1.length() + s2.length();

        String                    applyLoc    = functionLoc.apply("osman");
        System.out.println(applyLoc);

        Consumer<String> consumerLoc  = (String sParam) -> System.out.println("Test : " + sParam);
        Consumer<String> consumerLoc2 = sParam -> System.out.println("Test : " + sParam);
        BiConsumer<String,String> biConsumerLoc = (s1,s2) -> System.out.println(s1 + " " + s2);

        consumerLoc2.accept("osman");

        List<String> stringsLoc = Arrays.asList("osman",
                                                "ali",
                                                "veli",
                                                "ayşe");
        for (String stringLoc : stringsLoc) {
            System.out.println(stringLoc);
        }
        System.out.println("-----------------------");
        stringsLoc.forEach(System.out::println);

        Predicate<String> checkStr = s -> s.length() > 5;
        BiPredicate<String,String> compareStrs = (s1,s2) -> s1.length() > s2.length();

        System.out.println("-----------------------");
        if (checkStr.test("mehmet")) {
            System.out.println("Evet");
        }

        Supplier<String> stringSupplierLoc = () -> "osman";
        String           stringLoc         = stringSupplierLoc.get();
        System.out.println("sonuç : " + stringLoc);
    }
}
