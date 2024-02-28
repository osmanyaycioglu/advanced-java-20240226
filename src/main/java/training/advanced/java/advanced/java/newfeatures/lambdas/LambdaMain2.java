package training.advanced.java.advanced.java.newfeatures.lambdas;

import java.util.Scanner;

public class LambdaMain2 {
    public static void main(String[] args) {
        IProcess<String,Integer> processStr = s -> s.length();
        IProcess<String,String> processStr2 = s -> s + " processed";

        try (Scanner scannerLoc = new Scanner(System.in)) {
            System.out.println("bana sayı ver : ");
            double vLoc = scannerLoc.nextDouble();
            System.out.println("girdiğiniz sayı : " + vLoc);
            System.out.println("bana başka sayı ver : ");
            double vLoc2 = scannerLoc.nextDouble();
            System.out.println("Toplamı : " + (vLoc + vLoc2));

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
