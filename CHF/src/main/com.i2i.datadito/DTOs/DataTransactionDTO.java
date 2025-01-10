package com.i2i.datadito.DTOs;

public class DataTransactionDTO {
    private String msisdn;
    private int location;
    private int dataUsage;
    private int ratingGroup;

    // Default constructor
    public DataTransactionDTO() {
    }

    // Parameterized constructor
    public DataTransactionDTO(String msisdn, int location, int dataUsage, int ratingGroup) {
        this.msisdn = msisdn;
        this.location = location;
        this.dataUsage = dataUsage;
        this.ratingGroup = ratingGroup;
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

    public void setLocation(int location) {
        this.location = location;
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
}
