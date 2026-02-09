package com.mpro.ptax.Utils;

import java.io.InputStream;
import java.util.Properties;

public class ReadConfig {

    private static Properties prop;

    static {
        try {
            prop = new Properties();

            InputStream is = ReadConfig.class
                    .getClassLoader()
                    .getResourceAsStream("config.properties");

            if (is == null) {
                throw new RuntimeException(
                    "config.properties NOT found. Ensure it is inside src/main/resources"
                );
            }

            prop.load(is);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load config", e);
        }
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }
}
