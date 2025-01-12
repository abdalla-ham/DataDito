package com.i2i.datadito.kafka.message;

public class BalanceMessage implements Message {
    private String msisdn;
    private Integer amount;
    private BalanceType type;

    public BalanceMessage(String msisdn, BalanceType type, Integer amount) {
        this.msisdn = msisdn;
        this.amount = amount;
        this.type = type;
    }

    public BalanceMessage() {
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BalanceType getType() {
        return type;
    }

    public void setType(BalanceType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "BalanceMessage{" +
                "msisdn='" + msisdn + '\'' +
                ", type=" + type +
                ", amount=" + amount +
                '}';
    }

}
