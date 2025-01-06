package org.datadito.tgf;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.i2i.datadito.hazelcast.HazelcastSimulatorOperation;
import jakarta.annotation.Nullable;
import org.datadito.tgf.Transactions.DataTransaction;
import org.datadito.tgf.Transactions.SeperateTransactions.DataInnerTransaction;
import org.datadito.tgf.Transactions.SeperateTransactions.SmsInnerTransaction;
import org.datadito.tgf.Transactions.SeperateTransactions.VoiceInnerTransaction;
import org.datadito.tgf.Transactions.SmsTransaction;
import org.datadito.tgf.Transactions.VoiceTransaction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomTransactionGenerator {

    private enum Types{
        SMS,
        VOICE_CALL,
        DATA_TRANSACTION
    };

    private final Random random;
    List<Object> msisdn;
    private int msisdnSize;


    public RandomTransactionGenerator(){
        // TODO: Uncomment on production
        // msisdn = new ArrayList<>(HazelcastSimulatorOperation.getAllMsisdn());
        // msisdnSize = msisdn.size();
        this.random = new Random();
    }

    @Nullable
    private String convertToJson(Object transaction){
        ObjectMapper Obj = new ObjectMapper();
        try {
            return Obj.writeValueAsString(transaction);
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /*
        TODO: Change the phone numbers with
         `msisdn.get(random.nextInt(msisdnSize)).toString()`
         on production
     */
    private Object getRandomTransaction(int randomNumber){
        if (randomNumber == Types.SMS.ordinal()){
            //return new SmsTransaction("sms", new SmsInnerTransaction(msisdn.get(random.nextInt(msisdnSize)).toString(), msisdn.get(random.nextInt(msisdnSize)).toString()));
            return new SmsTransaction("sms", new SmsInnerTransaction("90 123 456 78", "90 123 456 78"));
        }else if (randomNumber == Types.VOICE_CALL.ordinal()){
            return new VoiceTransaction("voice", new VoiceInnerTransaction("90 123 456 78", "90 123 456 78", random.nextInt(0, 100)));
        }else{
            int ratingGroup = random.nextInt(1, 25); // [1, 25) // This number means kinda website grouping which specifically gets number within this range
            return new DataTransaction("data", new DataInnerTransaction("90 123 456 78", random.nextInt(0, 355), ratingGroup));
        }
    }

    public String getRandomTGFTransaction() throws Exception{
        int randomNumber = random.nextInt(0, 3);
        return convertToJson(getRandomTransaction(randomNumber));
    }

}
