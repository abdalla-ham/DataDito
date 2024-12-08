package com.i2i.datadito.voltdb;

import java.sql.Timestamp;

public class VoltCustomerBalance {
    private String msisdn;
    private int balanceData;
    private int balanceSms;
    private int balanceMinutes;
    private Timestamp sdate;
    private Timestamp edate;

    // Constructor
    public VoltCustomerBalance(String msisdn, int balanceData, int balanceSms, int balanceMinutes, Timestamp sdate, Timestamp edate) {
        this.msisdn = msisdn;
        this.balanceData = balanceData;
        this.balanceSms = balanceSms;
        this.balanceMinutes = balanceMinutes;
        this.sdate = sdate;
        this.edate = edate;
    }

    // Getters
    public String getMsisdn() {
        return msisdn;
    }

    public int getBalanceData() {
        return balanceData;
    }

    public int getBalanceSms() {
        return balanceSms;
    }

    public int getBalanceMinutes() {
        return balanceMinutes;
    }

    public Timestamp getSdate() {
        return sdate;
    }

    public Timestamp getEdate() {
        return edate;
    }

    // Setters
    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public void setBalanceData(int balanceData) {
        this.balanceData = balanceData;
    }

    public void setBalanceSms(int balanceSms) {
        this.balanceSms = balanceSms;
    }

    public void setBalanceMinutes(int balanceMinutes) {
        this.balanceMinutes = balanceMinutes;
    }

    public void setSdate(Timestamp sdate) {
        this.sdate = sdate;
    }

    public void setEdate(Timestamp edate) {
        this.edate = edate;
    }

    // toString method
    @Override
    public String toString() {
        return "VoltCustomerBalance{" +
                "msisdn='" + msisdn + '\'' +
                ", balanceData=" + balanceData +
                ", balanceSms=" + balanceSms +
                ", balanceMinutes=" + balanceMinutes +
                ", sdate=" + sdate +
                ", edate=" + edate +
                '}';
    }

}