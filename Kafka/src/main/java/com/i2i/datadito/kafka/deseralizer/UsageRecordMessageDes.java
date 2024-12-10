package com.i2i.datadito.kafka.deseralizer;

import com.i2i.datadito.kafka.message.UsageRecordMessage;

public class UsageRecordMessageDes extends GenericMessageDes<UsageRecordMessage> {

    public UsageRecordMessageDes() {
        super(UsageRecordMessage.class);
    }
}
