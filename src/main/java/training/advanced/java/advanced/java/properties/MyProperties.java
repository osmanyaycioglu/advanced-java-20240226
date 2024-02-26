package training.advanced.java.advanced.java.properties;

import lombok.Data;
import training.advanced.java.advanced.java.annotations.Property;
import training.advanced.java.advanced.java.annotations.PropertyFile;

@Data
@PropertyFile(fileName = "target/classes/myprop.properties")
public class MyProperties {
    @Property("my.new.prop1")
    private String newProp;
    @Property("my.test.prop2")
    private String testProp;


}
