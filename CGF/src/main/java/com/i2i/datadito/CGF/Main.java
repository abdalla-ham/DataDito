package com.i2i.datadito.CGF;

import com.i2i.datadito.kafka.MessageConsumer;
import com.i2i.datadito.kafka.message.UsageRecordMessage;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.KafkaException;
import org.apache.kafka.common.errors.InterruptException;
import org.apache.kafka.common.errors.TimeoutException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.SQLException;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("CGF - Starting Service...");
        try {
            // Make new subscriber
            MessageConsumer<UsageRecordMessage> subscriber = new MessageConsumer<>();
            String kafkaUrl = ConfigLoader.getProperty("kafka.url");
            logger.info("CGF - Kafka URL from config: {}", kafkaUrl);
            subscriber.createUsageRecordMessageConsumer();

            logger.info("CGF - Entering main processing loop");
            // infinite loop listening to events from Kafka, writing to Oracle if found
            while (true) {
                try {
                    // check new records
                    ConsumerRecords<String, UsageRecordMessage> consumerRecords = subscriber.poll();
                    int batchSize = consumerRecords.count();

                    if (batchSize > 0) {
                        logger.debug("CGF - Received batch of {} records", batchSize);

                        for (ConsumerRecord<String, UsageRecordMessage> record : consumerRecords) {
                            try {
                                processRecord(record);
                            } catch (SQLException e) {
                                logger.error("CGF - Database error while processing record: {}, Error: {}",
                                        record.key(), e.getMessage(), e);
                            } catch (IllegalArgumentException e) {
                                logger.error("CGF - Invalid data in record: {}, Error: {}",
                                        record.key(), e.getMessage(), e);
                            } catch (NullPointerException e) {
                                logger.error("CGF - Missing required data in record: {}, Error: {}",
                                        record.key(), e.getMessage(), e);
                            } catch (RuntimeException e) {
                                logger.error("CGF - Unexpected error processing record: {}, Error: {}",
                                        record.key(), e.getMessage(), e);
                            }
                        }
                    }
                } catch (TimeoutException e) {
                    logger.warn("CGF - Kafka poll timeout, retrying...");
                    Thread.sleep(1000);
                } catch (InterruptException e) {
                    logger.error("CGF - Kafka consumer interrupted: {}", e.getMessage(), e);
                    Thread.currentThread().interrupt(); // Preserve interrupt status
                    break;
                } catch (KafkaException e) {
                    logger.error("CGF - Kafka error in main loop: {}", e.getMessage(), e);
                    Thread.sleep(1000);
                } catch (RuntimeException e) {
                    logger.error("CGF - Unexpected error in main loop: {}", e.getMessage(), e);
                    Thread.sleep(1000);
                }
            }
        } catch (SecurityException e) {
            logger.error("CGF - Security violation during startup: {}", e.getMessage(), e);
            throw new RuntimeException("CGF service failed to start due to security violation", e);
        } catch (IllegalStateException e) {
            logger.error("CGF - Invalid service state during startup: {}", e.getMessage(), e);
            throw new RuntimeException("CGF service failed to start due to invalid state", e);
        } catch (InterruptedException e) {
            logger.error("CGF - Service interrupted during startup: {}", e.getMessage(), e);
            Thread.currentThread().interrupt(); // Preserve interrupt status
            throw new RuntimeException("CGF service interrupted during startup", e);
        } catch (RuntimeException e) {
            logger.error("CGF - Unexpected error during startup: {}", e.getMessage(), e);
            throw new RuntimeException("CGF service failed to start due to unexpected error", e);
        }
    }

    private static void processRecord(ConsumerRecord<String, UsageRecordMessage> record) throws SQLException {
        if (record == null) {
            throw new IllegalArgumentException("Record cannot be null");
        }

        UsageRecordMessage usageRecord = record.value();
        if (usageRecord == null) {
            throw new IllegalArgumentException("Record value cannot be null");
        }

        logger.debug("CGF - Processing usage record - Caller: {}, Type: {}, Duration: {}",
                usageRecord.getCallerMsisdn(),
                usageRecord.getUsageType(),
                usageRecord.getUsageDuration());

        OracleCRUD.callInsertProcedure(usageRecord);
    }
}