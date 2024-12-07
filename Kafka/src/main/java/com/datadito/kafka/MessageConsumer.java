package com.datadito.kafka;

import com.datadito.kafka.deseralizer.BalanceMessageDes;
import com.datadito.kafka.deseralizer.NotificationMessageDes;
import com.datadito.kafka.deseralizer.UsageRecordMessageDes;
import com.datadito.kafka.message.BalanceMessage;
import com.datadito.kafka.message.Message;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class MessageConsumer<T extends Message> {

    KafkaConsumer<String, T> consumer;

    private KafkaConsumer<String, T> createConsumer(String deserializerClassName, String topicName, String groupId) {
        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, ConfigLoader.getProperty("kafka.url"));
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, deserializerClassName);
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        properties.put("auto.offset.reset", "earliest");

        KafkaConsumer<String, T> consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Collections.singletonList(topicName));

        return consumer;
    }

    public void createBalanceMessageConsumer() {
        consumer = createConsumer(BalanceMessageDes.class.getName(), KafkaTopicConstants.BALANCE_TOPIC,
                "BalanceConsumerGroup");
    }

    public void createUsageRecordMessageConsumer() {
        consumer = createConsumer(UsageRecordMessageDes.class.getName(), KafkaTopicConstants.USAGE_RECORD_TOPIC,
                "UsageRecordConsumerGroup");
    }

    public void createNotificationMessageConsumer() {
        consumer = createConsumer(NotificationMessageDes.class.getName(), KafkaTopicConstants.NOTIFICATION_TOPIC,
                "NotificationConsumerGroup");
    }

    public ConsumerRecords<String, T> poll() {
        if (consumer != null) {
            System.out.println("Subscribed topics: " + consumer.subscription());
            ConsumerRecords<String, T> records = consumer.poll(Duration.ofMillis(1000));
            System.out.println("Polled record count: " + records.count());
            return records;
        } else {
            return null;
        }
    }

    public ConsumerRecords<String, BalanceMessage> poll(Duration ofSeconds) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'poll'");
    }

}
