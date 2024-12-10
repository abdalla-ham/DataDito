package com.i2i.datadito.kafka.seralizer;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class GenericMessageSer<T> implements Serializer<T> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public GenericMessageSer() {
    }

    @Override
    public byte[] serialize(String topic, T data) {
        try {
            return objectMapper.writeValueAsBytes(data);
        } catch (Exception e) {
            throw new RuntimeException("Error serializing message", e);
        }
    }
}
