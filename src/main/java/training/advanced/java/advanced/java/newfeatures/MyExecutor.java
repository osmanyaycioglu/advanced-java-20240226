package training.advanced.java.advanced.java.newfeatures;

public class MyExecutor implements IExecute {

    @Override
    public String execute(final String command,
                          final int count) {
        return "değişmiş hali " + command + " count : " + count;
    }

    public void deneme(){
        System.out.println("deneme");
    }
}
