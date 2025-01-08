package com.i2i.datadito.DTOs;

public class SmsTransactionDTO {
    private String senderMsisdn;
    private String receiverMsisdn;
    private int location;

    // Default constructor
    public SmsTransactionDTO() {
    }

    // Parameterized constructor
    public SmsTransactionDTO(String senderMsisdn, String receiverMsisdn, int location) {
        this.senderMsisdn = senderMsisdn;
        this.receiverMsisdn = receiverMsisdn;
        this.location = location;
    }

    public String getSenderMsisdn() {
        return senderMsisdn;
    }

    public void setSenderMsisdn(String senderMsisdn) {
        this.senderMsisdn = senderMsisdn;
    }

    public String getReceiverMsisdn() {
        return receiverMsisdn;
    }

    public void setReceiverMsisdn(String receiverMsisdn) {
        this.receiverMsisdn = receiverMsisdn;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }
}

