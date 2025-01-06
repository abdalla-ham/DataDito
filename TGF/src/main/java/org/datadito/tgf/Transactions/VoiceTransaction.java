package org.datadito.tgf.Transactions;

import org.datadito.tgf.Transactions.SeperateTransactions.VoiceInnerTransaction;

public class VoiceTransaction {
    private String serviceType;
    private VoiceInnerTransaction transaction;

    public VoiceTransaction(String serviceType, VoiceInnerTransaction transaction) {
        this.serviceType = serviceType;
        this.transaction = transaction;
    }

    public VoiceTransaction() {
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public VoiceInnerTransaction getTransaction() {
        return transaction;
    }

    public void setTransaction(VoiceInnerTransaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return "VoiceTransaction{" +
                "serviceType='" + serviceType + '\'' +
                ", transaction=" + transaction +
                '}';
    }
}
