package com.i2i.datadito.voltdb;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Optional;
import org.voltdb.client.ProcCallException;

public class VoltDbOperatorsTest {

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

        // Invoking methods
        try {
          System.out.println("Package Name: " + operators.getPackageName(msisdn));
            System.out.println("Customer Password: " + operators.getCustomerPassword(msisdn));
           System.out.println("SMS Balance: " + operators.getSmsBalance(msisdn));
            System.out.println("Data Balance: " + operators.getDataBalance(msisdn));
            System.out.println("Voice Balance: " + operators.getVoiceBalance(msisdn));
           System.out.println("Customer ID: " + operators.getCustomerIdByEmailAndTC(email, tcNo));
            System.out.println("Max Customer ID: " + operators.getMaxCustomerId());
            System.out.println("Max Balance ID: " + operators.getMaxBalanceId());
            System.out.println("Package SMS Balance: " + operators.getPackageSmsBalance(msisdn));
           System.out.println("Package Data Balance: " + operators.getPackageDataBalance(msisdn));
            System.out.println("Package Voice Balance: " + operators.getPackageVoiceBalance(msisdn));

            operators.updateSmsBalance(usage, msisdn);
            operators.updateDataBalance(usage, msisdn);
            operators.updateVoiceBalance(usage, msisdn);

           // operators.insertCustomer(customerId, "John", "Doe", msisdn, email, "password123", now, tcNo);
            //operators.insertBalance(balanceId, packageId, customerId, 444, 44, 43, 223, now, now , 333, 33);
          // operators.insertPackage("INSERT_PACKAGE", packageId, "Test Package", 9.99, 500, 1024, 1000, 30);


            Optional<VoltCustomer> customer = operators.getCustomerByMsisdn(msisdn);
            customer.ifPresent(System.out::println);

            System.out.println("User Name: " + operators.getName(msisdn));
            System.out.println("User Last Name: " + operators.getLastName(msisdn));
            System.out.println("User Email: " + operators.getUserEmail(msisdn));
            System.out.println("Package ID: " + operators.getPackageId(msisdn));

            System.out.println("Customer Balance: " + operators.getRemainingCustomerBalanceByMsisdn(msisdn));

           VoltPackage packageInfo = operators.getPackageByMsisdn(msisdn);
           System.out.println("Package Info: " + packageInfo);

            VoltPackageDetails packageDetails = operators.getPackageInfoByPackageId(packageId);
            System.out.println("Package Details: " + packageDetails);

            System.out.println("Customer Exists: " + operators.checkCustomerExists(email, tcNo));

            msisdn = "1234567890";
             email = "test@example.com";
             tcNo = "12345678901";
            operators.updatePassword(email, tcNo, "MHJALHAJ239");
            System.out.println("Customer Password: " + operators.getCustomerPassword(msisdn));
            System.out.println("email:"+ email+"\n tc:"+tcNo+"\n msisdn:"+msisdn);

        } catch (IOException | ProcCallException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            operators.close();
        }
    }
}
