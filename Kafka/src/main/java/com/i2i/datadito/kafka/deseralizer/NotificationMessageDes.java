package com.i2i.datadito.kafka.deseralizer;

import com.i2i.datadito.kafka.message.NotificationMessage;

public class NotificationMessageDes extends GenericMessageDes<NotificationMessage> {

    public NotificationMessageDes() {
        super(NotificationMessage.class);
    }

}
