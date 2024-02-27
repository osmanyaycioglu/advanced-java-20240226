package training.advanced.java.advanced.java.enums;

import training.advanced.java.advanced.java.annotations.Customer;

public class GenderMain {

    public static final int GENDER_MALE = 1;
    public static final int GENDER_FEMALE = 1;

    public static void main(String[] args) {
        Customer customerLoc = new Customer();
        System.out.println(customerLoc.getGender().getDesc());
        System.out.println(customerLoc.getGender().talk());
//        if (customerLoc.getGender() == EGender.MALE) {
//            System.out.println("erkek");
//        } else {
//            System.out.println("kadın");
//        }
    }
}
