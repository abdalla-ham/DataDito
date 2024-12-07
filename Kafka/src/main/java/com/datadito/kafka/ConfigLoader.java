package com.datadito.kafka;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private static final String CONFIG_FILE = "/kafka-config.properties"; // Place this file in src/main/resources
    private static final Properties properties = new Properties();

    static {
        try (InputStream inputStream = ConfigLoader.class.getResourceAsStream(CONFIG_FILE)) {
            if (inputStream == null) {
                throw new IOException("Configuration file not found: " + CONFIG_FILE);
            }
            properties.load(inputStream);
        } catch (IOException e) {
            System.err.println("Failed to load configuration file: " + CONFIG_FILE);
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        // First, check if the value exists as an environment variable
        String value = System.getenv(key);
        if (value != null) {
            return value;
        }
        // Otherwise, load from the properties file
        return properties.getProperty(key);
    }
}