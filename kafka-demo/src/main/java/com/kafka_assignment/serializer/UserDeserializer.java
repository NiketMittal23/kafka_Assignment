package com.kafka_assignment.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka_assignment.input;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class UserDeserializer implements Deserializer<input> {
    @Override public void close() {
    }
    @Override public void configure(Map<String, ?> arg0, boolean arg1) {
    }
    @Override
    public input deserialize(String arg0, byte[] arg1) {
        ObjectMapper mapper = new ObjectMapper();
        input user = null;
        try {
            user = mapper.readValue(arg1, input.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}