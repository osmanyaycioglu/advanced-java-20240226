package training.advanced.java.advanced.java.newfeatures.lambdas;

@FunctionalInterface
public interface IProcess<T,R> {

    R process(T t);

}
