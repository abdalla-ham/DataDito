
package com.i2i.datadito.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import com.i2i.datadito.kafka.message.Message;
import com.i2i.datadito.kafka.seralizer.BalanceMessageSer;
import com.i2i.datadito.kafka.seralizer.NotificationMessageSer;

import java.util.Properties;

public class MessageProducer<T extends Message> {

    private Producer<String, T> producer;

    private Producer<String, T> createProducer(String ClassName) {
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, ConfigLoader.getProperty("kafka.url"));
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ClassName);

        return new KafkaProducer<>(properties);
    }

    public void createBalanceMessageProducer() {
        producer = createProducer(BalanceMessageSer.class.getName());
    }

    public void createUsageRecordMessageProducer() {
        producer = createProducer(UsageRecordMessageSer.class.getName());
    }

    public void createNotificationMessageProducer() {
        producer = createProducer(NotificationMessageSer.class.getName());
    }

    public void send(T message, String topicName) {
        if (producer != null) {
            producer.send(new ProducerRecord<>(topicName, "operation", message), (metadata, exception) -> {
                if (exception != null) {
                    // Log or handle the exception
                    System.err.println("Error sending message: " + exception.getMessage());
                } else {
                    // Log success metadata
                    System.out.println("Message sent successfully!");
                    System.out.println("Topic: " + metadata.topic() +
                            ", Partition: " + metadata.partition() +
                            ", Offset: " + metadata.offset());
                }
            });
        }
    }

    public void close() {
        if (producer != null) {
            producer.close();
        }
    }
}
