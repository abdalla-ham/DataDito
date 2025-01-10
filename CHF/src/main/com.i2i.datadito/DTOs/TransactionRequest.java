package com.i2i.datadito.DTOs;

public class TransactionRequest {
    private String serviceType; // "data", "sms", "voice"
    private Object transaction;

    // Getters and Setters
    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Object getTransaction() {
        return transaction;
    }

    public void setTransaction(Object transaction) {
        this.transaction = transaction;
    }
}
