package training.advanced.java.advanced.java.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyRead {
    public static void main(String[] args) throws Exception {
        Properties propertiesLoc = new Properties();
        File fileLoc = new File("target/classes/myprop.properties");
        propertiesLoc.load(new FileInputStream(fileLoc));
        String propertyLoc1 = propertiesLoc.getProperty("my.new.prop1");
        String propertyLoc2 = propertiesLoc.getProperty("my.test.prop2");

        MyProperties myPropertiesLoc = new MyProperties();
        myPropertiesLoc.setNewProp(propertyLoc1);
        myPropertiesLoc.setTestProp(propertyLoc2);

        System.out.println(propertyLoc1 + " --- " + propertyLoc2);

        System.out.println(myPropertiesLoc);
    }
}
