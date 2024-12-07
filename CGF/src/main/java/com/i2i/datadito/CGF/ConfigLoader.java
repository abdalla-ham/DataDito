package com.i2i.datadito.CGF;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    // Static Properties object to store configurations loaded from file
    private static final Properties properties = new Properties();

    public ConfigLoader() {
    }

    /**
     * Gets a configuration value by key, using environment variables if provided
     * otherwise, falling back to properties file
     *
     * @param key The configuration key to look up
     * @return The configuration value if found, null otherwise
     */
    public static String getProperty(String key) {
        // Convert property key format to env variable (e.g. database.url -> DATABASE_URL)
        String envKey = key.toUpperCase().replace('.', '_');
        // Use env variables if provided
        String envValue = System.getenv(envKey);
        if (envValue != null) {
            return envValue;
        }
        // Fallback to properties file if env variables not found
        return properties.getProperty(key);
    }

    /**
     * Static initialization block that loads the application.properties file
     * Executes when the class is first loaded
     */
    static {
        try {
            // Load application.properties from classpath
            InputStream input = com.i2i.datadito.CGF.ConfigLoader.class.getClassLoader().getResourceAsStream("application.properties");
            try {
                // Throw exception if properties file not found
                if (input == null) {
                    throw new RuntimeException("Sorry, unable to find application.properties");
                }
                // Load properties from file
                properties.load(input);
            } catch (Throwable loadException) {
                // Ensure input stream is closed on error
                if (input != null) {
                    try {
                        input.close();
                    } catch (Throwable closeException) {
                        loadException.addSuppressed(closeException);
                    }
                }
                throw loadException;
            }
            // Close input stream after successful load
            if (input != null) {
                input.close();
            }
        } catch (IOException ioException) {
            // Wrap IO exceptions in RuntimeException
            IOException ex = ioException;
            throw new RuntimeException("Error loading properties file", ex);
        }
    }
}