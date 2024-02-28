package training.advanced.java.advanced.java.newfeatures;

public class ExecutorFactory {

    public static IExecute createExecutor(int index){
        switch (index) {
            case 1:
                return new MyExecutor();
            case 3:
                return new FutureExecutor();
            case 2:
            default:
                return new OtherExecutor();

        }
    }

}
