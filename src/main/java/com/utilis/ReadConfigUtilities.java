package com.utilis;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigUtilities {
    private Properties properties;

    public void readConfig() {
        properties = new Properties();

        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\User\\git\\AdaniADC\\src\\main\\resources\\config.properties");
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
