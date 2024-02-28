package training.advanced.java.advanced.java.newfeatures;

public class ExecutorMain {
    public static void main(String[] args) {
        IExecute executorLoc = ExecutorFactory.createExecutor(3);
        String addLoc = executorLoc.execute("add",
                                            10);
        System.out.println("sonuç : " + addLoc);
    }
}
