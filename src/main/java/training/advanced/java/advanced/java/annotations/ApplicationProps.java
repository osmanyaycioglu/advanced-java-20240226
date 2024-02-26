package training.advanced.java.advanced.java.annotations;

import lombok.Data;

@Data
@PropertyFile(fileName = "prop1.properties")
public class ApplicationProps {

    private String appName;
    private int port;
    private String ip;

    public void method(){
    }

}
