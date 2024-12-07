package com.datadito.kafka.deseralizer;

import com.datadito.kafka.message.BalanceMessage;

public class BalanceMessageDes extends GenericMessageDes<BalanceMessage> {

    public BalanceMessageDes() {
        super(BalanceMessage.class);
    }

}
