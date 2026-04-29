package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigLoader {
    private static Properties properties;

    static {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            properties = new Properties();
            properties.load(fis);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config file");
        }
    }

    public static String getBaseUrl() {
        return properties.getProperty("base.url");
    }

    public static String getUploadBaseUrl() {
        return properties.getProperty("upload_url");
    }

}