package com.i2i.datadito.kafka;

import com.i2i.datadito.kafka.message.BalanceMessage;
import com.i2i.datadito.kafka.message.BalanceType;
import com.i2i.datadito.kafka.message.NotificationMessage;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import java.sql.Timestamp;

public class Main {
        public static void main(String[] args) {


            MessageProducer<NotificationMessage> producer = new MessageProducer<>();
            producer.createNotificationMessageProducer();
            NotificationMessage notificationMessage = new NotificationMessage("imadeddine", "belkat","624605972800724","imadbelkat@gmail.com", BalanceType.SMS, 80, "20",new Timestamp(System.currentTimeMillis()));
            producer.send(notificationMessage, KafkaTopicConstants.NOTIFICATION_TOPIC);
            producer.close();



            MessageConsumer<BalanceMessage> consumer = new MessageConsumer<>();
            consumer.createBalanceMessageConsumer();
            while(true){
                ConsumerRecords<String, BalanceMessage> records = consumer.poll();
                for(ConsumerRecord<String, BalanceMessage> record : records){
                    System.out.println(record.value().toString());
                }
            }

        }
}
