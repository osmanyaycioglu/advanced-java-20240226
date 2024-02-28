package training.advanced.java.advanced.java.newfeatures.lambdas;

@FunctionalInterface
public interface IProcessDouble<T,E,R> {

    R process(T t,E e);

}
