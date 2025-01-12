package com.i2i.datadito.kafka;

import com.i2i.datadito.kafka.message.*;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import java.sql.Timestamp;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // Create and send random NotificationMessage
        try (MessageProducer<NotificationMessage> notificationProducer = new MessageProducer<>()) {
            notificationProducer.createNotificationMessageProducer();
            for (int i = 0; i < 40; i++) {
                NotificationMessage notificationMessage = generateRandomNotificationMessage();
                notificationProducer.send(notificationMessage, KafkaTopicConstants.NOTIFICATION_TOPIC);
            }
        }

        // Create and send random UsageRecordMessage
        try (MessageProducer<UsageRecordMessage> usageRecordProducer = new MessageProducer<>()) {
            usageRecordProducer.createUsageRecordMessageProducer();
            for (int i = 0; i < 40; i++) {
                UsageRecordMessage usageRecordMessage = generateRandomUsageRecordMessage();
                usageRecordProducer.send(usageRecordMessage, KafkaTopicConstants.USAGE_RECORD_TOPIC);
            }
        }

        // Create and send random BalanceMessage
        try (MessageProducer<BalanceMessage> balanceProducer = new MessageProducer<>()) {
            balanceProducer.createUsageRecordMessageProducer();
            for (int i = 0; i < 40; i++) {
                BalanceMessage balanceMessage = generateRandomBalanceMessage();
                balanceProducer.send(balanceMessage, KafkaTopicConstants.BALANCE_TOPIC);
            }
        }

        // Initialize consumers
        MessageConsumer<BalanceMessage> balanceConsumer = new MessageConsumer<>();
        balanceConsumer.createBalanceMessageConsumer();

        MessageConsumer<UsageRecordMessage> usageRecordConsumer = new MessageConsumer<>();
        usageRecordConsumer.createUsageRecordMessageConsumer();

        MessageConsumer<NotificationMessage> notificationConsumer = new MessageConsumer<>();
        notificationConsumer.createNotificationMessageConsumer();

        // Add shutdown hook to close consumers
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            balanceConsumer.consumer.close();
            usageRecordConsumer.consumer.close();
            notificationConsumer.consumer.close();
            System.out.println("Consumers closed.");
        }));

        // Poll messages in an infinite loop
        while (true) {
            pollAndPrint(balanceConsumer);
            pollAndPrint(usageRecordConsumer);
            pollAndPrint(notificationConsumer);

            try {
                Thread.sleep(1000); // Adjust polling interval as needed
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    private static <T extends Message> void pollAndPrint(MessageConsumer<T> consumer) {
        ConsumerRecords<String, T> records = consumer.poll();
        for (ConsumerRecord<String, T> record : records) {
            System.out.printf("Topic: %s | Key: %s | Value: %s%n",
                    record.topic(), record.key(), record.value().toString());
        }
    }

    // Helper methods to generate random messages

    private static NotificationMessage generateRandomNotificationMessage() {
        Random random = new Random();
        String callerMsisdn = "imad" + (100000 + random.nextInt(900000));
        String calleeMsisdn = "imad" + (100000 + random.nextInt(900000));
        String email = "user" + random.nextInt(1000) + "@gmail.com";
        String balance = String.valueOf(random.nextInt(100));
        String messageCount = String.valueOf(random.nextInt(50));
        BalanceType usageType = BalanceType.values()[random.nextInt(BalanceType.values().length)];
        return new NotificationMessage(callerMsisdn, calleeMsisdn, callerMsisdn, email, usageType, 80, messageCount, new Timestamp(System.currentTimeMillis()));
    }

    private static UsageRecordMessage generateRandomUsageRecordMessage() {
        Random random = new Random();
        String callerMsisdn = "62460597" + (1000000 + random.nextInt(9000000));
        String calleeMsisdn = "62468488" + (1000000 + random.nextInt(9000000));
        BalanceType usageType = BalanceType.values()[random.nextInt(BalanceType.values().length)];
        int usageDuration = random.nextInt(100);
        return new UsageRecordMessage(callerMsisdn, calleeMsisdn, usageType, usageDuration, new Timestamp(System.currentTimeMillis()));
    }

    private static BalanceMessage generateRandomBalanceMessage() {
        Random random = new Random();
        String msisdn = "62460597" + (1000000 + random.nextInt(9000000));
        BalanceType usageType = BalanceType.values()[random.nextInt(BalanceType.values().length)];
        int balance = random.nextInt(100);
        return new BalanceMessage(msisdn, usageType, balance);
    }
}
