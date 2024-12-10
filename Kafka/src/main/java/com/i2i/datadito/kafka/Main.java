package com.i2i.datadito.kafka;

import com.i2i.datadito.kafka.message.BalanceMessage;
import com.i2i.datadito.kafka.message.BalanceType;
import com.i2i.datadito.kafka.message.NotificationMessage;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import java.sql.Timestamp;

public class Main {
        public static void main(String[] args) {

            //test for Publisher and Subscriber

            MessageProducer<NotificationMessage> publisher = new MessageProducer<>();
            publisher.createNotificationMessageProducer();
            NotificationMessage notificationMessage = new NotificationMessage("test", "test","5530344666","mustafyasinemir@gmail.com", BalanceType.SMS, 80, "20",new Timestamp(System.currentTimeMillis()));
            publisher.send(notificationMessage, KafkaTopicConstants.NOTIFICATION_TOPIC);
            publisher.close();



            MessageConsumer<BalanceMessage> subscriber = new MessageConsumer<>();
            subscriber.createBalanceMessageConsumer();
            while(true){
                ConsumerRecords<String, BalanceMessage> records = subscriber.poll();
                for(ConsumerRecord<String, BalanceMessage> record : records){
                    System.out.println(record.value().toString());
                }
            }

        }
}
