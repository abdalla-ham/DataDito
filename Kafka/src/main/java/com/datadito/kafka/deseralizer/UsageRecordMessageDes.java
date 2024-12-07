package com.datadito.kafka.deseralizer;

import com.datadito.kafka.message.UsageRecordMessage;

public class UsageRecordMessageDes extends GenericMessageDes<UsageRecordMessage> {

    public UsageRecordMessageDes() {
        super(UsageRecordMessage.class);
    }
}
