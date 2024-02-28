package training.advanced.java.advanced.java.newfeatures.lambdas;

import training.advanced.java.advanced.java.newfeatures.FutureExecutor;
import training.advanced.java.advanced.java.newfeatures.IExecute;

public class LambdaMain1 {
    public static void main(String[] args) {
        int test = 10;
        IExecute executorLoc = new IExecute() {
            @Override
            public String execute(final String command,
                                  final int count) {
                return "iç implementation " + command + " count : " + count + " test : " + test;
            }
        };

        System.out.println(executorLoc.execute("delete",
                                               1));

        IExecute executeLoc = (a1, b1) -> "lambda " + a1 + " count : " + b1 + " test : " + test;
        System.out.println(executeLoc.execute("delete",
                                              1));
        implMethod((a1, b1) -> "method daki lambda " + a1 + " count : " + b1 + " test : " + test,
                   "update");

        ITest iTestLoc = w -> w.length();
        ITest iTestLoc1 = w -> {
            System.out.println("Processing : " + w +  " test : " + test);
            return w.length();
        };
        ITest iTestLoc2 = LambdaMain1::abc;
        LambdaMain1 lambdaMain1Loc = new LambdaMain1();
        ITest iTestLoc3 = lambdaMain1Loc::xyz;

    }

    public static void implMethod(IExecute executeParam,
                                  String command) {
        System.out.println(executeParam.execute(command,
                                                4));
    }

    public static Integer abc(String str) {
        System.out.println("ABC Processing : " + str);
        return str.length();
    }

    public  Integer xyz(String str) {
        System.out.println("XYZ Processing : " + str);
        return str.length();
    }

}
