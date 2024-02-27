package training.advanced.java.advanced.java.enums;

public enum EGender {
    MALE(1,
         "ERKEK") {
        @Override
        public String talk() {
            return "selam";
        }

    },
    FEMALE(2,
           "KADIN") {
        @Override
        public String talk() {
            return "merhaba";
        }

    };

    private final int    index;
    private final String desc;

    EGender(final int indexParam,
            final String descParam) {
        index = indexParam;
        desc  = descParam;
    }

    public int getIndex() {
        return index;
    }

    public String getDesc() {
        return desc;
    }

    public String talk() {
        return "selamlar";
    }
}
// MALE = new (MALE extends EGender)