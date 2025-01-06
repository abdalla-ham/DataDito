package org.datadito.tgf.Transactions.SeperateTransactions;

public class DataInnerTransaction {
    private String msisdn;
    final private int location = 90;
    private int dataUsage;
    private int ratingGroup;

    public DataInnerTransaction(String msisdn, int dataUsage, int ratingGroup) {
        this.msisdn = msisdn;
        this.dataUsage = dataUsage;
        this.ratingGroup = ratingGroup;
    }

    public DataInnerTransaction(){

    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public int getLocation() {
        return location;
    }

    public int getDataUsage() {
        return dataUsage;
    }

    public void setDataUsage(int dataUsage) {
        this.dataUsage = dataUsage;
    }

    public int getRatingGroup() {
        return ratingGroup;
    }

    public void setRatingGroup(int ratingGroup) {
        this.ratingGroup = ratingGroup;
    }

    @Override
    public String toString() {
        return "DataInnerTransaction{" +
                "msisdn='" + msisdn + '\'' +
                ", location=" + location +
                ", dataUsage=" + dataUsage +
                ", ratingGroup=" + ratingGroup +
                '}';
    }
}
