package com.i2i.datadito.voltdb;

import java.sql.Timestamp;

public class VoltCustomer {
    private Integer customerId;
    private String msisdn;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String TCNumber;
    private Timestamp sDate;

    // Constructor
    public VoltCustomer(int customerId, String msisdn, String name, String surname, String email, String password, String TCNumber, Timestamp sDate) {
        this.customerId = customerId;
        this.msisdn = msisdn;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.TCNumber = TCNumber;
        this.sDate = sDate;
    }
    public VoltCustomer(){

    }

    // Getters and Setters
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTCNumber() {
        return TCNumber;
    }

    public void setTCNumber(String TCNumber) {
        this.TCNumber = TCNumber;
    }

    public Timestamp getsDate() {
        return sDate;
    }

    public void setsDate(Timestamp sDate) {
        this.sDate = sDate;
    }

    // toString method
    @Override
    public String toString() {
        return "VoltCustomer{" +
                "cust_id=" + customerId +
                ", msisdn='" + msisdn + '\'' +
                ", name='" + name + '\'' +
                ", surName='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", tc_no='" + TCNumber + '\'' +
                ", sDate=" + sDate +
                '}';
    }

}