package com.kafka_assignment.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka_assignment.input;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class UserSerializer implements Serializer<input> {

    public void configure(Map<String, ?> map, boolean b) {
    }


    public byte[] serialize(String s, input o) {
        byte[] retVal = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            retVal = objectMapper.writeValueAsString(o).getBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retVal;
    }


    public void close() {
    }
}