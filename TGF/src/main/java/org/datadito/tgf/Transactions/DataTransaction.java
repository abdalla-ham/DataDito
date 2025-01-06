package org.datadito.tgf.Transactions;

import org.datadito.tgf.Transactions.SeperateTransactions.DataInnerTransaction;

public class DataTransaction {
    private String serviceType;
    DataInnerTransaction transaction;

    public DataTransaction(String serviceType, DataInnerTransaction transaction) {
        this.serviceType = serviceType;
        this.transaction = transaction;
    }

    public DataTransaction() {
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public DataInnerTransaction getTransaction() {
        return transaction;
    }

    public void setTransaction(DataInnerTransaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return "DataTransaction{" +
                "serviceType='" + serviceType + '\'' +
                ", transaction=" + transaction +
                '}';
    }
}
