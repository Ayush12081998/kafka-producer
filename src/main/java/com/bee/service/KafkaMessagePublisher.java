package com.bee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessagePublisher {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessageToTopic(final String message) {
        this.kafkaTemplate.send("demo-topic", message)
                .whenComplete((result, ex) -> {
                    if (ex == null) {
                        System.out.println("Message sent = [" + message + "]" + "with offset = [" + result.getRecordMetadata().offset() + " ]");
                    } else {
                        System.out.println("Unable to send message = [" + message + " ]" + "due to " + ex.getMessage());
                    }
                });
    }
}
