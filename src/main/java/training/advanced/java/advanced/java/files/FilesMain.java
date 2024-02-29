package training.advanced.java.advanced.java.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FilesMain {
    public static void main(String[] args) {
        try {
            List<String> listLoc = Files.readAllLines(Paths.get("customer.txt"));
            System.out.println(listLoc);
            for (String stringLoc : listLoc) {
                String[] splitLoc = stringLoc.split(",");
                System.out.println(Arrays.toString(splitLoc));
            }
        } catch (Exception eParam) {
            eParam.printStackTrace();
        }
    }
}
