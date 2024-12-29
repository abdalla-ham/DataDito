package com.i2i.datadito.hazelcast;

import java.util.Collection;

public class Main {
    public static void main(String[] args) {

//           --Put Operation (TGF)
         String putResult = HazelcastMWOperation.put("test17", "test17");
         System.out.println(putResult);

        //--Get Operation (COM)
         String getResult = HazelcastTGFOperation.getAllMsisdn("test17");
         System.out.println(getResult);

         String getResult1 = HazelcastTGFOperation.getAllMsisdn("1f234");
         System.out.println(getResult1);

        //--Get All Keys Operation
         Collection<Object> allKeys = HazelcastSimulatorOperation.getAllMsisdn();
         System.out.println(allKeys);
         int numberOfKeys = allKeys.size();
         System.out.println("total key: " + numberOfKeys);




    }
}