package com.datadito.kafka.deseralizer;

import com.datadito.kafka.message.NotificationMessage;

public class NotificationMessageDes extends GenericMessageDes<NotificationMessage> {

    public NotificationMessageDes() {
        super(NotificationMessage.class);
    }

}
