package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigBuilder {

    private Properties prop;

    public Properties initProp() {
        prop = new Properties();
        FileInputStream ip = null;
        try {
            ip = new FileInputStream("./src/test/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
