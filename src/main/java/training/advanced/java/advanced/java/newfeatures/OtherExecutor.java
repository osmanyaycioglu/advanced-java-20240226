package training.advanced.java.advanced.java.newfeatures;

public class OtherExecutor implements IExecute {

    @Override
    public String execute(final String command,
                          final int count) {
        return "bu tamamen farklı " + command + " count : " + count;
    }

    public void deneme(){
        System.out.println("deneme");
    }
}
