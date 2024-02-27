package training.advanced.java.advanced.java.oo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Car implements Comparable<Car> {
    private String name;
    private String model;
    private String color;
    private int x;
    private int y;


    public void forward(int metre){
        // ... code
    }

    public void bacward(int metre){
    }

    public void turn(int metre){
    }


    @Override
    public int compareTo(final Car o) {
        return o.name.compareTo(name);
    }
}
