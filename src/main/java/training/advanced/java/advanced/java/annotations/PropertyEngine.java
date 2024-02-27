package training.advanced.java.advanced.java.annotations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.Properties;

public class PropertyEngine {

    public <T> T readProperties(T objectParam) throws Exception {
        Class<?>     classLoc        = objectParam.getClass();
        PropertyFile propertyFileLoc = classLoc.getAnnotation(PropertyFile.class);
        if (propertyFileLoc != null) {
            String fileNameLoc = propertyFileLoc.fileName();
            Properties propertiesLoc = new Properties();
            File       fileLoc       = new File(fileNameLoc);
            propertiesLoc.load(new FileInputStream(fileLoc));

            Field[] declaredFieldsLoc = classLoc.getDeclaredFields();
            for (Field declaredFieldLoc : declaredFieldsLoc) {
                Property propertyLoc = declaredFieldLoc.getAnnotation(Property.class);
                if (propertyLoc != null) {
                    declaredFieldLoc.setAccessible(true);
                    String propertyValueLoc = propertiesLoc.getProperty(propertyLoc.value());

                    Class<?> typeLoc = declaredFieldLoc.getType();
                    if (typeLoc == String.class) {
                        declaredFieldLoc.set(objectParam,
                                             propertyValueLoc);
                    } else if (typeLoc == Integer.class) {
                        declaredFieldLoc.set(objectParam,
                                             Integer.parseInt(propertyValueLoc));
                    } else if (typeLoc.getName()
                                      .equals("int")) {
                        declaredFieldLoc.setInt(objectParam,
                                                Integer.parseInt(propertyValueLoc));
                    }
                }
            }
        } else {
            System.out.println("Obje de gerekli anotasyon yok");
        }
        return objectParam;
    }

}
