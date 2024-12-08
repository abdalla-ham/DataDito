package com.i2i.datadito.voltdb;

import java.sql.Timestamp;

public class VoltCustomer {
    private int cust_id;
    private String msisdn;
    private String name;
    private String surName;
    private String email;
    private String password;
    private String tc_no;
    private Timestamp sDate;

    // Constructor
    public VoltCustomer(int cust_id, String msisdn, String name, String surName, String email, String password, String tc_no, Timestamp sDate) {
        this.cust_id = cust_id;
        this.msisdn = msisdn;
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.password = password;
        this.tc_no = tc_no;
        this.sDate = sDate;
    }

    // Getters and Setters
    public int getCust_id() {
        return cust_id;
    }

    public void setCust_id(int cust_id) {
        this.cust_id = cust_id;
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

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
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

    public String getTc_no() {
        return tc_no;
    }

    public void setTc_no(String tc_no) {
        this.tc_no = tc_no;
    }

    public Timestamp getSDate() {
        return sDate;
    }

    public void setSDate(Timestamp sDate) {
        this.sDate = sDate;
    }

    // toString method
    @Override
    public String toString() {
        return "VoltCustomer{" +
                "cust_id=" + cust_id +
                ", msisdn='" + msisdn + '\'' +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", tc_no='" + tc_no + '\'' +
                ", sDate=" + sDate +
                '}';
    }

}