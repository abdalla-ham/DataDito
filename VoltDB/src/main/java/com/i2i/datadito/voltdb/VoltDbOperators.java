package com.i2i.datadito.voltdb;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.voltdb.client.*;
import org.voltdb.VoltTable;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Optional;


public class VoltDbOperators {
    private final String ip;
    private final int port;
    private Client client;
  private static final Logger logger = LogManager.getLogger(VoltDbOperators.class);

    public VoltDbOperators() {
        //this.ip = "34.42.35.90";
      //  this.ip = "34.154.174.193";   //italy
       // this.ip = "localhost";
        this.ip = "4.178.178.188";
        this.port = 21212;
        initializeClient();

    }

    private void initializeClient() {
        try {
            this.client = getClient();
        } catch (IOException e) {
            logger.error("Error while creating VoltDB client", e);
            throw new RuntimeException("Error while creating VoltDB client", e);
        }
    }

    public Client getClient() throws IOException {
        ClientConfig clientConfig = new ClientConfig();
        Client client = ClientFactory.createClient(clientConfig);

        try {
            client.createConnection(ip + ":" + port);
        } catch (IOException e) {
            logger.error("Error while creating connection to VoltDB server", e);
            throw new IOException("Error while creating connection to VoltDB server", e);
        }
        return client;
    }
    public String getPackageName(String msisdn){
        return handleProcedureAsString("GET_PACKAGE_NAME_BY_MSISDN",msisdn);
    }
    public String getCustomerPassword(String msisdn){
       return handleProcedureAsString("GET_CUSTOMER_PASSWORD_BY_MSISDN",msisdn);
    }
    public int getSmsBalance(String msisdn){
        return handleProcedureAsInt("GET_CUSTOMER_REMAINING_SMS_BY_MSISDN", msisdn);
    }
    public int getDataBalance(String msisdn){
        return handleProcedureAsInt("GET_CUSTOMER_REMAINING_DATA_BY_MSISDN", msisdn);
    }
    public int getVoiceBalance(String msisdn){
        return handleProcedureAsInt("GET_CUSTOMER_REMAINING_MINUTES_BY_MSISDN", msisdn);
    }
    public int getCustomerIdByEmailAndTC(String email, String tc_no){
        return handleProcedureGetId("GET_CUSTOMER_ID_BY_EMAIL_AND_TCNO", email, tc_no);  // create the method pls
    }
    public int getMaxCustomerId(){
        return handleProcedureAsInt("GET_MAX_CUSTOMER_ID");
    }
    public int getMaxBalanceId(){
        return handleProcedureAsInt("GET_MAX_BALANCE_ID");
    }
    public int getPackageSmsBalance(String msisdn){
        return handleProcedureAsInt("GET_PACKAGE_SMS_BALANCE_BY_MSISDN",msisdn);
    }
    public int getPackageDataBalance(String msisdn){
        return handleProcedureAsInt("GET_PACKAGE_DATA_BALANCE_BY_MSISDN",msisdn);
    }
    public int getPackageVoiceBalance(String msisdn){
        return handleProcedureAsInt("GET_PACKAGE_MINUTES_BALANCE_BY_MSISDN",msisdn);
    }
    public void updateSmsBalance(int smsUsage, String msisdn){
        handleProcedure("UPDATE_CUSTOMER_SMS_BALANCE_BY_MSISDN", smsUsage, msisdn);
    }
    public void updateDataBalance(int dataUsage, String msisdn){
        handleProcedure("UPDATE_CUSTOMER_DATA_BALANCE_BY_MSISDN", dataUsage, msisdn);
    }
    public void updateVoiceBalance(int voiceUsage, String msisdn){
        handleProcedure("UPDATE_CUSTOMER_MINUTES_BALANCE_BY_MSISDN", voiceUsage, msisdn);
    }
    public void insertCustomer(int cust_id, String name, String surname, String msisdn, String email, String password, Timestamp sdate, String tc_no) {
        handleProcedureInsertCustomer( "INSERT_NEW_CUSTOMER", cust_id, name, surname, msisdn, email, password, sdate, tc_no);
    }
    public void insertBalance(int balance_id, int package_id, int cust_id, int partition_id, int bal_lvl_minutes, int bal_lvl_sms, int bal_lvl_data, Timestamp sdate, Timestamp edate, int price, int bal_lvl_money) {
        handleProcedureInsertBalance("INSERT_BALANCE_TO_CUSTOMER", balance_id, package_id, cust_id, partition_id, bal_lvl_minutes, bal_lvl_sms, bal_lvl_data, sdate, edate, price , bal_lvl_money);
    }
    public void insertPackage(String procedureName,int package_id, String package_name , double price, int amount_minutes, int amount_data, int amount_sms, int period) {
        handleProcedureInsertPackage("INSERT_PACKAGE", package_id, package_name, price, amount_minutes, amount_data, amount_sms, period);
    }
    public int checkCustomerExists(String email, String tc_no){
        return handleProcedureCheck("CHECK_CUSTOMER_EXISTS_BY_EMAIL_AND_TCNO", email, tc_no);
    }
    private int handleProcedureAsInt(String procedureName){
        try {
            ClientResponse response = client.callProcedure(procedureName);
            VoltTable resultTable = response.getResults()[0];
            if (resultTable.advanceRow()) {
                return (int) resultTable.getLong(0);
            } else {
                throw new RuntimeException("No data returned from this procedure:" + procedureName);
            }
        }
         catch (IOException | ProcCallException e) {
             logger.error("Error while calling procedure: " + procedureName, e);
             throw new RuntimeException("Error while calling procedure: " + procedureName, e);
         }
    }
    private int handleProcedureAsInt(String procedureName, String msisdn){
        try {
            ClientResponse response = client.callProcedure(procedureName, msisdn);
            VoltTable resultTable = response.getResults()[0];
            if (resultTable.advanceRow()) {
                return (int) resultTable.getLong(0);
            } else {
                throw new RuntimeException("No data returned from this procedure: "+ procedureName);
            }
        }
        catch (IOException | ProcCallException e) {
            logger.error("Error while calling procedure: " + procedureName, e);
            throw new RuntimeException("Error while calling procedure: " + procedureName, e);
        }
    }
    private int handleProcedureGetId(String procedureName, String email, String tc_no){
        try {
            ClientResponse response = client.callProcedure(procedureName, email, tc_no);
            VoltTable resultTable = response.getResults()[0];
            if (resultTable.advanceRow()) {
                return (int) resultTable.getLong(0);
            } else {
                throw new RuntimeException("No data returned from this procedure: "+ procedureName);
            }
        }
        catch (IOException | ProcCallException e) {
            logger.error("Error while calling procedure: " + procedureName, e);
            throw new RuntimeException("Error while calling procedure: " + procedureName, e);
        }
    }
    private String handleProcedureAsString(String procedureName, String msisdn){
        try {
            ClientResponse response = client.callProcedure(procedureName, msisdn);
            VoltTable resultTable = response.getResults()[0];
            if (resultTable.advanceRow()) {
                return resultTable.getString(0);
            } else {
                throw new RuntimeException("No data returned from procedure: "+ procedureName);
            }
        }
        catch (IOException | ProcCallException e) {
            logger.error("Error while calling procedure: " + procedureName, e);
            throw new RuntimeException("Error while calling procedure: " + procedureName, e);
        }
    }
    private void handleProcedure(String procedureName, int usage, String msisdn){
        try {
            ClientResponse response = client.callProcedure(procedureName, usage, msisdn);
            if (response.getStatus() != ClientResponse.SUCCESS){
                throw new RuntimeException("Procedure call failed: " + response.getStatusString());
            }
        } catch ( ProcCallException | IOException e){
            logger.error("Error while calling procedure: " + procedureName, e);
            throw new RuntimeException("Error while calling procedure: " + procedureName, e);
        }
    }
    public void updatePassword(String email, String tcNumber, String msisdn, String encryptedPassword) {
        try {
            Client client1 = getClient();
            ClientResponse response = client1.callProcedure("UPDATE_PASSWORD", encryptedPassword, email, msisdn, tcNumber);
            if (response.getStatus() != ClientResponse.SUCCESS) {
                throw new RuntimeException("Procedure call failed: " + response.getStatusString());
            }
            client1.close();
        } catch (ProcCallException | IOException e) {
            logger.error("Error while updating password for email: " + email, e);
            throw new RuntimeException("Error while updating password for email: " + email, e);
        } catch (InterruptedException e) {
            logger.error("Update password operation was interrupted for email: " + email, e);
            throw new RuntimeException("Update password operation was interrupted for email: " + email, e);
        }
    }
    public UserDetails getUserDetails(String msisdn) {
        try {
            ClientResponse response = client.callProcedure("GET_CUSTOMER_INFO_PACKAGE_BY_MSISDN", msisdn);
            VoltTable resultTable = response.getResults()[0];
            if (resultTable.advanceRow()) {
                return new UserDetails(
                        resultTable.getString("NAME"),
                        resultTable.getString("SURNAME"),
                        resultTable.getString("EMAIL"),
                        (int) resultTable.getLong("PACKAGE_ID")
                );
            } else {
                throw new RuntimeException("No data returned from procedure");
            }
        } catch (IOException | ProcCallException e) {
            logger.error("Error while calling procedure: GET_CUSTOMER_INFO_PACKAGE_BY_MSISDN", e);
            throw new RuntimeException("Error while calling procedure: GET_CUSTOMER_INFO_PACKAGE_BY_MSISDN", e);
        }
    }
    public String getName(String msisdn) {
        return getUserDetails(msisdn).getName();
    }
    public String getLastName(String msisdn) {
        return getUserDetails(msisdn).getLastName();
    }
    public String getUserEmail(String msisdn) {
        return getUserDetails(msisdn).getEmail();
    }
    public int getPackageId(String msisdn) {
        return getUserDetails(msisdn).getPackageId();
    }
    private void handleProcedureInsertCustomer(String procedureName,int cust_id, String name, String surname, String msisdn, String email, String password, Timestamp sdate, String tc_no){
        try {
            ClientResponse response = client.callProcedure(procedureName, cust_id, msisdn, name , surname, email, password, sdate, tc_no);
            if (response.getStatus() != ClientResponse.SUCCESS){
                throw new RuntimeException("Procedure call failed: " + response.getStatusString());
            }
        } catch (IOException | ProcCallException e) {
            logger.error("Error while calling procedure: " + procedureName, e);
            throw new RuntimeException("Error while calling procedure: " + procedureName, e);
        }
    }
    private void handleProcedureInsertBalance(String procedureName, int balance_id, int package_id, int cust_id, int partition_id, int bal_lvl_minutes, int bal_lvl_sms, int bal_lvl_data, Timestamp sdate, Timestamp edate, int price, int bal_lvl_money){
        try {
            ClientResponse response = client.callProcedure(procedureName,balance_id, package_id, cust_id, partition_id, bal_lvl_minutes, bal_lvl_sms, bal_lvl_data, sdate, edate, price , bal_lvl_money);
            if (response.getStatus() != ClientResponse.SUCCESS){
                throw new RuntimeException("Procedure call failed: " + response.getStatusString());
            }
        } catch (IOException | ProcCallException e) {
            logger.error("Error while calling procedure: " + procedureName, e);
            throw new RuntimeException("Error while calling procedure: " + procedureName, e);
        }
    }
    private void handleProcedureInsertPackage(String procedureName,int package_id, String package_name , double price, int amount_minutes, int amount_data, int amount_sms, int period){
        try {
            ClientResponse response = client.callProcedure(procedureName , package_id, package_name, price, amount_minutes, amount_data, amount_sms, period);
            if (response.getStatus() != ClientResponse.SUCCESS){
                throw new RuntimeException("Procedure call failed: " + response.getStatusString());
            }
        } catch (IOException | ProcCallException e) {
            logger.error("Error while calling procedure: " + procedureName, e);
            throw new RuntimeException("Error while calling procedure: " + procedureName, e);
        }
    }
    private int handleProcedureCheck(String procedureName, String email, String tc_no){
        try {
            ClientResponse response = client.callProcedure(procedureName, email, tc_no);
            VoltTable resultTable = response.getResults()[0];
            if (resultTable.advanceRow()) {
                return (int) resultTable.getLong(0); // Cast long to int
            } else {
                throw new RuntimeException("No data returned from procedure");
            }
        } catch (IOException | ProcCallException e) {
            logger.error("Error while calling procedure: " + procedureName, e);
            throw new RuntimeException("Error while calling procedure: " + procedureName, e);
        }
    }
   public VoltPackage getPackageByMsisdn(String msisdn) {
        try {
            Client client1 = getClient();
            ClientResponse response = client1.callProcedure("GET_PACKAGE_INFO_BY_MSISDN", msisdn);
            VoltTable responseTable = response.getResults()[0];
            if (responseTable.advanceRow()) {
                return new VoltPackage(
                        (int) responseTable.getLong("PACKAGE_ID"),
                        responseTable.getString("PACKAGE_NAME"),
                        responseTable.getDouble("PRICE"),
                        (int) responseTable.getLong("AMOUNT_MINUTES"),
                        (int) responseTable.getLong("AMOUNT_DATA"),
                        (int) responseTable.getLong("AMOUNT_SMS"),
                        (int) responseTable.getLong("PERIOD")
                );
            } else {
                throw new RuntimeException("Error while getting package by Msisdn");
            }
        }catch (IOException | ProcCallException e) {
            logger.error("Error while calling procedure: GET_PACKAGE_INFO_BY_MSISDN", e);
            throw new RuntimeException("Error while calling procedure: GET_PACKAGE_INFO_BY_MSISDN", e);
        }
    }
    public Optional<VoltCustomer> getCustomerInfoByMsisdn(String msisdn) throws IOException, ProcCallException, InterruptedException {
        Client client1 = getClient();
        ClientResponse response = client1.callProcedure("GET_CUSTOMER_INFO_BY_MSISDN", msisdn);

        if (response.getStatus() == ClientResponse.SUCCESS) {
            VoltTable resultTable = response.getResults()[0];
            if (resultTable.advanceRow()) {
                Integer customerId = (int) resultTable.getLong("CUST_ID");
                String name = resultTable.getString("NAME");
                String surname = resultTable.getString("SURNAME");
                String email = resultTable.getString("EMAIL");
                Timestamp sdate = resultTable.getTimestampAsSqlTimestamp("SDATE");
                String tcNo = resultTable.getString("TC_NO");

                VoltCustomer customer = new VoltCustomer(
                        customerId,
                        msisdn,
                        name,
                        surname,
                        email,
                        null, // Assuming password is not retrieved here, set it to null
                        tcNo,
                        sdate
                );

                client1.close(); // closes the client connection to VoltDB
                return Optional.of(customer);
            }
        }
        client1.close();
        logger.error("Customer not found with this MSISDN: " + msisdn);
        throw new RuntimeException("Customer not found with this MSISDN: " + msisdn);
    }
    public VoltCustomerBalance getRemainingCustomerBalanceByMsisdn(String msisdn) throws IOException, ProcCallException, InterruptedException {
        Client client1 = getClient();
        ClientResponse response = client1.callProcedure("GET_REMAINING_CUSTOMER_BALANCE_BY_MSISDN", msisdn);

        if (response.getStatus() == ClientResponse.SUCCESS) {
            VoltTable resultTable = response.getResults()[0];
            if (resultTable.advanceRow()) {
                String msisdnResult = resultTable.getString("MSISDN");
                int balanceData = (int) resultTable.getLong("BAL_LVL_DATA");
                int balanceSms = (int) resultTable.getLong("BAL_LVL_SMS");
                int balanceMinutes = (int) resultTable.getLong("BAL_LVL_MINUTES");
                Timestamp sdate = resultTable.getTimestampAsSqlTimestamp("SDATE");
                Timestamp edate = resultTable.getTimestampAsSqlTimestamp("EDATE");

                VoltCustomerBalance balanceResponse = new VoltCustomerBalance(
                        msisdnResult,
                        balanceData,
                        balanceSms,
                        balanceMinutes,
                        sdate,
                        edate
                );
                client1.close();
                return balanceResponse;
            }
        }
        client1.close(); // closes the client connection to VoltDB
        logger.error("Customer balance not found for msisdn: " + msisdn);
        throw new RuntimeException("Customer balance not found for msisdn: " + msisdn);
    }
    public VoltPackageDetails getPackageInfoByPackageId(int packageId) throws IOException, ProcCallException, InterruptedException {
        Client client1 = getClient();
        ClientResponse response = client.callProcedure("GET_PACKAGE_INFO_BY_PACKAGE_ID", packageId);
        if (response.getStatus() == ClientResponse.SUCCESS) {
            VoltTable resultTable = response.getResults()[0];
            if (resultTable.advanceRow()) {
                int period = (int) resultTable.getLong("PERIOD");
                int amountMinutes = (int) resultTable.getLong("AMOUNT_MINUTES");
                int amountSms = (int) resultTable.getLong("AMOUNT_SMS");
                int amountData = (int) resultTable.getLong("AMOUNT_DATA");
                return new VoltPackageDetails(period, amountMinutes, amountSms, amountData);
            }
        }
        client1.close(); //directly closes the client connection to VoltDB
        logger.error("Package not found with ID:", packageId);
        throw new RuntimeException("Package not found with ID: " + packageId);
    }
    // is for safely closing a VoltDB client connection
    public void close() {
        if (client != null) {
            try {
                client.close();
            } catch (InterruptedException e) {
                logger.error("Error while closing VoltDB client", e);
                Thread.currentThread().interrupt();
            }
        }
    }
}