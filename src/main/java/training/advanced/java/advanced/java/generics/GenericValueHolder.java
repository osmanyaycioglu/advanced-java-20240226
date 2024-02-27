package training.advanced.java.advanced.java.generics;

public class GenericValueHolder<T> {

    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(final T valueParam) {
        value = valueParam;
    }

}
