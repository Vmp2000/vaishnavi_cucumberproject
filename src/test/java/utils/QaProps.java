package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class QaProps {
    private static Properties properties;

    private QaProps() {
    }

    public static void init() {
        if (properties == null) {
            properties = new Properties();

            try {
                properties.load(new FileInputStream("src/test/resources/env.properties"));
            } catch (IOException var1) {
                throw new RuntimeException(var1);
            }
        }

    }

    public static String getValue(String key) {
        init();
        return properties.getProperty(key);
    }
}
