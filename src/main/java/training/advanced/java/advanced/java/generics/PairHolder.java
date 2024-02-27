package training.advanced.java.advanced.java.generics;

public class PairHolder<T,E> {

    private final T pair1;
    private final E pair2;

    public PairHolder(final T pair1Param,
                      final E pair2Param) {
        pair1 = pair1Param;
        pair2 = pair2Param;
    }

    public T getPair1() {
        return pair1;
    }

    public E getPair2() {
        return pair2;
    }
}
