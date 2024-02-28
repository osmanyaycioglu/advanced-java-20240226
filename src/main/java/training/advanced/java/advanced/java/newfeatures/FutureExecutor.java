package training.advanced.java.advanced.java.newfeatures;

public class FutureExecutor implements IExecute {

    @Override
    public String execute(final String command,
                          final int count) {
        return "gelecekteki hali " + command + " count : " + count;
    }

}
