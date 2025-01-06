package org.datadito.tgf.Transactions;

import org.datadito.tgf.Transactions.SeperateTransactions.SmsInnerTransaction;

public class SmsTransaction {
    private String serviceType;
    SmsInnerTransaction transaction;

    public SmsTransaction(String serviceType, SmsInnerTransaction transaction) {
        this.serviceType = serviceType;
        this.transaction = transaction;
    }

    public SmsTransaction() {
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public SmsInnerTransaction getTransaction() {
        return transaction;
    }

    public void setTransaction(SmsInnerTransaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return "SmsTransaction{" +
                "serviceType='" + serviceType + '\'' +
                ", transaction=" + transaction +
                '}';
    }
}
