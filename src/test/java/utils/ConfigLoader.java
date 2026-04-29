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
            throw new RuntimeException("Failed to load config file", e);
        }
    }

    public static String getBaseUrl() {
        return properties.getProperty("base.url");
    }

    public static String getUploadBaseUrl() {
        return properties.getProperty("upload.base.url");
    }

    public static String getUploadPath() {
        return properties.getProperty("upload.path");
    }

    public static String getFilePath() {
        return properties.getProperty("file.path");
    }
}