package com.i2i.datadito.voltdb;

import java.sql.Timestamp;

public class InsertingTest {
    public static void main(String[] args) {
        VoltDbOperators operators = new VoltDbOperators();
        String msisdn = "1234567890";
        String email = "test@example.com";
        String tcNo = "12345678901";
        int customerId = 1;
        int packageId = 101;
        int balanceId = 201;
        int usage = 50;
        Timestamp now = new Timestamp(System.currentTimeMillis());
        operators.insertCustomer(customerId, msisdn,"John", "Doe", email, "password123", now, tcNo);
        operators.insertBalance(balanceId, customerId, packageId, 444, 43, 223, now, now);
         operators.insertPackage("INSERT_PACKAGE", packageId, "Test Package", 9.99, 500, 1024, 1000, 30);
    }
}
