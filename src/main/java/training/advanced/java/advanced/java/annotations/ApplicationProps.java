package training.advanced.java.advanced.java.annotations;

import lombok.Data;

@Data
@PropertyFile(fileName = "prop1.properties",period = 10_000,count = 10)
public class ApplicationProps {

    @Property(value = "app.name",alternate = "test")
    private String appName;
    @Property("app.port")
    private int port;
    private String ip;

    public void method(){
    }

}
