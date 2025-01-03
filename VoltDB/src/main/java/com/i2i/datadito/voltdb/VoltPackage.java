package com.i2i.datadito.voltdb;

public class VoltPackage {
    private Integer packageId;
    private String packageName;
    private double price;
    private Integer amountMinutes;
    private Integer amountData;
    private Integer amountSms;
    private Integer period;

    public VoltPackage(Integer packageId, String packageName, double price, Integer amountMinutes, Integer amountData, Integer amountSms, Integer period) {
        this.packageId = packageId;
        this.packageName = packageName;
        this.price = price;
        this.amountMinutes = amountMinutes;
        this.amountData = amountData;
        this.amountSms = amountSms;
        this.period = period;
    }

    public VoltPackage() {
    }

    public Integer getPackageId() {
        return packageId;
    }

    public String getPackageName() {
        return packageName;
    }

    public double getPrice() {
        return price;
    }

    public Integer getAmountMinutes() {
        return amountMinutes;
    }

    public Integer getAmountData() {
        return amountData;
    }

    public Integer getAmountSms() {
        return amountSms;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAmountMinutes(Integer amountMinutes) {
        this.amountMinutes = amountMinutes;
    }

    public void setAmountData(Integer amountData) {
        this.amountData = amountData;
    }

    public void setAmountSms(Integer amountSms) {
        this.amountSms = amountSms;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return "Package{" +
                "packageId=" + packageId +
                ", packageName='" + packageName + '\'' +
                ", price=" + price +
                ", amountMinutes=" + amountMinutes +
                ", amountData=" + amountData +
                ", amountSms=" + amountSms +
                ", period=" + period +
                '}';
    }
}
