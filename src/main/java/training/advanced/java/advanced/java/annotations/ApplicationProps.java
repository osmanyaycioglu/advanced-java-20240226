package training.advanced.java.advanced.java.annotations;

import lombok.Data;
import training.advanced.java.advanced.java.properties.MyProperties;

@Data
@PropertyFile(fileName = "target/classes/prop1.properties",period = 10_000,count = 10)
public class ApplicationProps {

    @Property(value = "app.name",alternate = "test")
    private String appName;
    @Property("app.port")
    private int port;
    private String ip;


    public static void main(String[] args) {
        PropertyEngine propertyEngineLoc = new PropertyEngine();
        try {
            ApplicationProps applicationPropsLoc = (ApplicationProps) propertyEngineLoc.readProperties(new ApplicationProps());
            MyProperties myPropertiesLoc = (MyProperties) propertyEngineLoc.readProperties(new MyProperties());
            System.out.println(applicationPropsLoc);
            System.out.println(myPropertiesLoc);
        } catch (Exception eParam) {
            eParam.printStackTrace();
        }
    }
}
