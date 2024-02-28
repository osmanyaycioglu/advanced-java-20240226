package training.advanced.java.advanced.java.annotations;

import lombok.Builder;
import lombok.Data;
import training.advanced.java.advanced.java.enums.EGender;


@Data
public class Customer {
    private String name;
    private String surname;
    long counter;
    private EGender gender = EGender.FEMALE;

    public Customer() {
    }

    @Builder(setterPrefix = "with")
    public Customer(final String nameParam,
                    final String surnameParam,
                    final long counterParam,
                    final EGender genderParam) {
        name    = nameParam;
        surname = surnameParam;
        counter = counterParam;
        gender  = genderParam;
    }

    public static void main(String[] args) {
        Customer customerLoc = new Customer();
        customerLoc.setName("osman");
        customerLoc.setSurname("yaycıoğlu");
        customerLoc.setCounter(10);
        if (args != null && args.length == 1){
            System.out.println("deneme");
        }
        customerLoc.setGender(EGender.MALE);

        Customer customerLoc2 = Customer.builder()
                                       .withNameParam("osman")
                                       .withSurnameParam("yaycıoülu")
                                       .withCounterParam(10)
                                       .withGenderParam(EGender.MALE)
                                       .build();

    }
}
