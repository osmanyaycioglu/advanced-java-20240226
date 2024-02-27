package training.advanced.java.advanced.java.enums;

public class TimeConvertMain {
    public static void main(String[] args) {
        System.out.println("sonuç 1 : " + ETimeConvert.DAY.convertToMilis(2));

        System.out.println("sonuç 2 : " + ETimeConvert.SECOND.convertToUnit(4329874,
                                                                          ETimeConvert.HOUR));

    }
}
