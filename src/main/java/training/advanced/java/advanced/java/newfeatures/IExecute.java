package training.advanced.java.advanced.java.newfeatures;

@FunctionalInterface
public interface IExecute {

    int fieldDeneme = 10;
    // public static final int fieldDeneme = 10;

    String execute(String command,int count);


    default String test(String command) {
        return execute(command, 1);
    }

    static String staticTest(String abc){
        return "test";
    }

}
