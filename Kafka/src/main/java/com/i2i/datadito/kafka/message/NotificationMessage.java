package com.i2i.datadito.kafka.message;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

public class NotificationMessage implements Message {

    private final String name;
    private final String lastname;
    private final String msisdn;
    private final String email;
    private final BalanceType type;
    private final Integer amount;
    private final String threshold;
    private final Timestamp timestamp;

    public NotificationMessage(@JsonProperty("name") String name,
                               @JsonProperty("lastname") String lastname,
                               @JsonProperty("msisdn") String msisdn,
                               @JsonProperty("email") String email,
                               @JsonProperty("type") BalanceType type,
                               @JsonProperty("amount") int amount,
                               @JsonProperty("threshold") String threshold,
                               @JsonProperty("timestamp") Timestamp timestamp) {
        this.name = name;
        this.lastname = lastname;
        this.msisdn = msisdn;
        this.email = email;
        this.type = type;
        this.amount = amount;
        this.threshold = threshold;
        this.timestamp = timestamp;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public String getEmail() {
        return email;
    }

    public BalanceType getType() {
        return type;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getThreshold() {
        return threshold;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "NotificationMessage{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", msisdn='" + msisdn + '\'' +
                ", email='" + email + '\'' +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", threshold='" + threshold + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

}