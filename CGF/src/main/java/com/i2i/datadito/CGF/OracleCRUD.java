package com.i2i.datadito.CGF;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.sql.DataSource;
import java.sql.*;
import com.i2i.datadito.kafka.message.UsageRecordMessage;

/**
 * Database operations class for handling usage records
 * Provides methods to insert usage data into Oracle database
 */
public class OracleCRUD {
    // Database connection pool instance
    private static final DataSource dataSource = DataSourceConfig.getDataSource();

    // Logger instance for this class
    private static final Logger logger = LogManager.getLogger(OracleCRUD.class);

    /**
     * Calls Oracle stored procedure to insert usage record into database
     *
     * @param usageRecord The usage record containing call details to be inserted
     */
    public static void callInsertProcedure(UsageRecordMessage usageRecord) {
        CallableStatement statement = null;
        try(Connection connection = dataSource.getConnection()){
            // Prepare the stored procedure call
            String procedureCall = "{call insert_personal_usage(?, ?, ?, ?, ?)}";
            statement = connection.prepareCall(procedureCall);

            // Set parameters for the stored procedure
            statement.setString(1, usageRecord.getCallerMsisdn());    // Caller's phone number
            statement.setString(2, usageRecord.getCalleeMsisdn());    // Receiver's phone number
            statement.setTimestamp(3, usageRecord.getUsageDate());
            statement.setString(4, usageRecord.getUsageType().name());
            statement.setInt(5, usageRecord.getUsageDuration());

            // Execute the stored procedure
            statement.execute();

            // Log successful insertion
            logger.info(String.format("Calling insert procedure for UsageRecord{" +
                            " callerMsisdn='%s', calleeMsisdn='%s'," +
                            " usageType=%s, usageDuration=%d, usageDate=%s }",
                    usageRecord.getCallerMsisdn(),
                    usageRecord.getCalleeMsisdn(),
                    usageRecord.getUsageType(),
                    usageRecord.getUsageDuration(),
                    usageRecord.getUsageDate()
            ));
        } catch (SQLException e){
            // Log any SQL errors during procedure execution
            logger.error("SQL Exception while calling procedure... ", e);
        }
        finally {
            // Clean up resources
            try {
                if (statement != null) statement.close();
            } catch (SQLException e) {
                logger.error("SQL Exception while closing SQL statement... ", e);
            }
        }
    }
}