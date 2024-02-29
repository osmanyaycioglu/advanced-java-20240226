package training.advanced.java.advanced.java.streams;

import training.advanced.java.advanced.java.annotations.Customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Stream;

public class StreamMain7 {
    public static void main(String[] args) {
        List<String> stringsLoc = Arrays.asList("osman",
                                                "ali",
                                                "veli",
                                                "osman",
                                                "ayşe");
        IntSummaryStatistics intSummaryStatisticsLoc = stringsLoc.stream()
                                                                 .distinct()
                                                                 .mapToInt(s -> s.length())
                                                                 .summaryStatistics();

        System.out.println("-------------");
        System.out.println("result1 : " + intSummaryStatisticsLoc);
    }
}
