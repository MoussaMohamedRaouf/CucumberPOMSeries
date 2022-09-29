package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties prop;

    /**
     * This method is used to load the properties from config.properties file
     * @return properties object prop
     */
    public Properties initProp(){
        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
