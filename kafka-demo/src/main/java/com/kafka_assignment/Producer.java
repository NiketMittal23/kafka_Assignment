package com.kafka_assignment;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class Producer {
    public static void main(String[] args)  {

        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "com.kafka_assignment.serializer.UserSerializer");
        input std = new input();
        std.setId(1);
        std.setName("NIket");
        std.setCourse("MCA");

        try (KafkaProducer<String, input> producer = new KafkaProducer(properties)) {
            producer.send(new ProducerRecord<String, input>("user", std));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}