package com.i2i.datadito.Controller;

import com.i2i.datadito.DTOs.DataTransactionDTO;
import com.i2i.datadito.DTOs.SmsTransactionDTO;
import com.i2i.datadito.DTOs.TransactionRequest;
import com.i2i.datadito.DTOs.VoiceTransactionDTO;
import com.i2i.datadito.Kafka.KafkaOperations;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.i2i.datadito.kafka.message.BalanceType;
import com.i2i.datadito.voltdb.VoltDbOperators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final VoltDbOperators voltDbOperators;
    private final ObjectMapper objectMapper;

    @Autowired
    public TransactionController(VoltDbOperators voltDbOperators, ObjectMapper objectMapper) {
        this.voltDbOperators = voltDbOperators;
        this.objectMapper = objectMapper;
    }

    @PostMapping
    public ResponseEntity<String> handleTransaction(@RequestBody TransactionRequest transactionRequest) {
        try {
            switch (transactionRequest.getServiceType()) {
                case "data":
                    DataTransactionDTO dataTransactionDTO = objectMapper.convertValue(transactionRequest.getTransaction(), DataTransactionDTO.class);
                    return handleDataTransaction(dataTransactionDTO);
                case "sms":
                    SmsTransactionDTO smsTransactionDTO = objectMapper.convertValue(transactionRequest.getTransaction(), SmsTransactionDTO.class);
                    return handleSmsTransaction(smsTransactionDTO);
                case "voice":
                    VoiceTransactionDTO voiceTransactionDTO = objectMapper.convertValue(transactionRequest.getTransaction(), VoiceTransactionDTO.class);
                    return handleVoiceTransaction(voiceTransactionDTO);
                default:
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unsupported transaction type.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid transaction payload: " + e.getMessage());
        }
    }

    private ResponseEntity<String> handleDataTransaction(DataTransactionDTO dataTransactionDTO) {
        int currentBalance = voltDbOperators.getDataBalance(dataTransactionDTO.getMsisdn());
        if (currentBalance >= dataTransactionDTO.getDataUsage()) {
            int updatedBalance = currentBalance - dataTransactionDTO.getDataUsage();
            voltDbOperators.updateDataBalance(updatedBalance, dataTransactionDTO.getMsisdn());
            KafkaOperations.sendUsageRecordMessage(BalanceType.DATA, dataTransactionDTO.getMsisdn(), null, updatedBalance, new Timestamp(System.currentTimeMillis()));

            if (updatedBalance == 0) {
                sendDataNotification(dataTransactionDTO.getMsisdn(), updatedBalance);
            }

            KafkaOperations.sendUpdatedBalanceMessage(BalanceType.DATA, dataTransactionDTO.getMsisdn(), updatedBalance);
            return ResponseEntity.ok("Data transaction executed successfully. Remaining balance: " + updatedBalance);
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Insufficient data balance.");
        }
    }

    private ResponseEntity<String> handleSmsTransaction(SmsTransactionDTO smsTransactionDTO) {
        int currentBalance = voltDbOperators.getSmsBalance(smsTransactionDTO.getSenderMsisdn());
        if (currentBalance > 0) {
            int updatedBalance = currentBalance - 1;
            voltDbOperators.updateSmsBalance(updatedBalance, smsTransactionDTO.getSenderMsisdn());
            KafkaOperations.sendUsageRecordMessage(BalanceType.SMS, smsTransactionDTO.getSenderMsisdn(), smsTransactionDTO.getReceiverMsisdn(), updatedBalance, new Timestamp(System.currentTimeMillis()));

            if (updatedBalance == 0) {
                sendSmsNotification(smsTransactionDTO.getSenderMsisdn(), updatedBalance);
            }

            KafkaOperations.sendUpdatedBalanceMessage(BalanceType.SMS, smsTransactionDTO.getSenderMsisdn(), updatedBalance);
            return ResponseEntity.ok("SMS transaction executed successfully. Remaining balance: " + updatedBalance);
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Insufficient SMS balance.");
        }
    }

    private ResponseEntity<String> handleVoiceTransaction(VoiceTransactionDTO voiceTransactionDTO) {
        int currentBalance = voltDbOperators.getVoiceBalance(voiceTransactionDTO.getCallerMsisdn());
        if (currentBalance >= voiceTransactionDTO.getDuration()) {
            int updatedBalance = currentBalance - voiceTransactionDTO.getDuration();
           voltDbOperators.updateVoiceBalance(updatedBalance, voiceTransactionDTO.getCallerMsisdn());
            KafkaOperations.sendUsageRecordMessage(BalanceType.VOICE, voiceTransactionDTO.getCallerMsisdn(), voiceTransactionDTO.getCalleeMsisdn(), updatedBalance, new Timestamp(System.currentTimeMillis()));

            if (updatedBalance == 0) {
                sendVoiceNotification(voiceTransactionDTO.getCallerMsisdn(), updatedBalance);
            }

            KafkaOperations.sendUpdatedBalanceMessage(BalanceType.VOICE, voiceTransactionDTO.getCallerMsisdn(), updatedBalance);
            return ResponseEntity.ok("Voice transaction executed successfully. Remaining balance: " + updatedBalance);
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Insufficient voice balance.");
        }
    }

    private void sendDataNotification(String msisdn, int updatedBalance) {
        KafkaOperations.sendNotificationMessage("User", "Data", msisdn, null, BalanceType.DATA, 0, "0", new Timestamp(System.currentTimeMillis()));
    }

    private void sendSmsNotification(String msisdn, int updatedBalance) {
        KafkaOperations.sendNotificationMessage("User", "SMS", msisdn, null, BalanceType.SMS, 0, "0", new Timestamp(System.currentTimeMillis()));
    }

    private void sendVoiceNotification(String msisdn, int updatedBalance) {
        KafkaOperations.sendNotificationMessage("User", "Voice", msisdn, null, BalanceType.VOICE, 0, "0", new Timestamp(System.currentTimeMillis()));
    }
}