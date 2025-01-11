package com.i2i.datadito.abmf;

import com.i2i.datadito.kafka.Subscriber;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import com.i2i.datadito.kafka.message.BalanceMessage;

import java.sql.SQLException;

public class ABMF {

    public static void main(String[] args) throws SQLException {

        Subscriber<BalanceMessage> subscriber = new Subscriber<BalanceMessage>();

        subscriber.createBalanceMessageConsumer();

        while (true) {
            ConsumerRecords<String, BalanceMessage> records = subscriber.poll();
            for (ConsumerRecord<String, BalanceMessage> record : records) {
                BalanceMessage message = record.value();
                OracleOperations.updateUserBalance(message);
            }
        }
    }

}