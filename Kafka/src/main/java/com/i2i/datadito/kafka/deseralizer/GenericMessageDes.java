package com.i2i.datadito.kafka.deseralizer;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class GenericMessageDes<T> implements Deserializer<T> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    private Class<T> tragetClass;

    public GenericMessageDes(Class<T> targetClass) {
        if (targetClass == null) {
            throw new IllegalArgumentException("Target class must not be null");
        }
        this.tragetClass = targetClass;
    }

    @Override
    public T deserialize(String topic, byte[] data) {
        try {
            return objectMapper.readValue(data, tragetClass);
        } catch (Exception e) {
            throw new RuntimeException("Error deserializing message", e);
        }
    }

    @Override
    public void close() {
        // Cleanup resources if needed
    }
}
