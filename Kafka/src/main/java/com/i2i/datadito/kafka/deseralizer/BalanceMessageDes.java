package com.i2i.datadito.kafka.deseralizer;

import com.i2i.datadito.kafka.message.BalanceMessage;

public class BalanceMessageDes extends GenericMessageDes<BalanceMessage> {

    public BalanceMessageDes() {
        super(BalanceMessage.class);
    }

}
