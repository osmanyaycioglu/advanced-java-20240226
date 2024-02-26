package training.advanced.java.advanced.java.annotations;

import java.lang.reflect.Field;

public class ReflectionPlayground {

    public static void main(String[] args) throws Exception {
        Class<ApplicationProps>           applicationPropsClassLoc1 = ApplicationProps.class;
        Class<?>                          applicationPropsClassLoc2 = Class.forName("training.advanced.java.advanced.java.annotations.ApplicationProps");
        ApplicationProps                  applicationPropsLoc       = new ApplicationProps();
        Class<? extends ApplicationProps> applicationPropsClassLoc3 = applicationPropsLoc.getClass();

        PropertyFile propertyFileLoc = applicationPropsClassLoc1.getAnnotation(PropertyFile.class);
        if (propertyFileLoc != null) {
            String fileNameLoc = propertyFileLoc.fileName();
            long   periodLoc   = propertyFileLoc.period();
            int    countLoc    = propertyFileLoc.count();
            System.out.println("Read annotation : " + fileNameLoc + " period : " + periodLoc + " count : " + countLoc);
        }

        Field[] declaredFieldsLoc = applicationPropsClassLoc1.getDeclaredFields();
        for (Field declaredFieldLoc : declaredFieldsLoc) {
            Property propertyLoc = declaredFieldLoc.getAnnotation(Property.class);
            if (propertyLoc != null) {
                System.out.println("Field : "
                                   + declaredFieldLoc.getName()
                                   + " Property value : "
                                   + propertyLoc.value()
                                   + " alternate : "
                                   + propertyLoc.alternate());
            }
        }

    }


}
