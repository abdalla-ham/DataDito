package com.i2i.datadito.CGF;

import com.i2i.datadito.kafka.MessageConsumer;
import com.i2i.datadito.kafka.message.UsageRecordMessage;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

public class Main {
    public static void main( String[] args ) {
        // Make new subscriber
        MessageConsumer<UsageRecordMessage> subscriber = new MessageConsumer<>();
        System.out.println("CGF - Kafka URL from config: " + ConfigLoader.getProperty("kafka.url"));
        subscriber.createUsageRecordMessageConsumer();

        // infinite loop listening to events from Kafka, writing to Oracle if found
        while (true){
            // check new records
            ConsumerRecords<String, UsageRecordMessage> consumerRecords = subscriber.poll();
            for(ConsumerRecord<String, UsageRecordMessage> record: consumerRecords){
                // get record value
                UsageRecordMessage usageRecord = record.value();
                // send to Oracle
                OracleCRUD.callInsertProcedure(usageRecord);
            }
        }
    }
}