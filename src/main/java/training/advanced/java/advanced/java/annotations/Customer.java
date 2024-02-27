package training.advanced.java.advanced.java.annotations;

import lombok.Data;
import training.advanced.java.advanced.java.enums.EGender;


@Data
public class Customer {
    private String name;
    private String surname;
    long counter;
    private EGender gender = EGender.FEMALE;

}
