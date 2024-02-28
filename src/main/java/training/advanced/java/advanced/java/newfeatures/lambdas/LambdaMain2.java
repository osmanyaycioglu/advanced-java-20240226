package training.advanced.java.advanced.java.newfeatures.lambdas;

public class LambdaMain2 {
    public static void main(String[] args) {
        IProcess<String,Integer> processStr = s -> s.length();
        IProcess<String,String> processStr2 = s -> s + " processed";
    }
}
