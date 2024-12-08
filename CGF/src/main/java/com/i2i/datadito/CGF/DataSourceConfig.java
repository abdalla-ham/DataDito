package com.i2i.datadito.CGF;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
public class DataSourceConfig {
    private static final HikariDataSource dataSource;
    static {
        // Single datasource instance shared across the application
        HikariConfig config = new HikariConfig();

        // Set database connection properties from config file
        config.setJdbcUrl(ConfigLoader.getProperty("oracle.url"));
        config.setUsername(ConfigLoader.getProperty("oracle.username"));
        config.setPassword(ConfigLoader.getProperty("oracle.password"));

        // Initialize the connection pool with configuration
        dataSource = new HikariDataSource(config);
    }

    /**
     * Returns the singleton datasource instance
     * @return DataSource interface to the connection pool
     */
    public static DataSource getDataSource() {
        return dataSource;
    }
}