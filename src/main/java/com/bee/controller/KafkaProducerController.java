package com.bee.controller;

import com.bee.service.KafkaMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer-app")
public class KafkaProducerController {

    @Autowired
    private KafkaMessagePublisher kafkaMessagePublisher;

    @GetMapping("/publish/{message}")
    public ResponseEntity<?> publishMessage(@PathVariable final String message) {
        for (int i = 0; i < 10000; i++) {
            this.kafkaMessagePublisher.sendMessageToTopic(message + ":" + i);
        }
        return ResponseEntity.ok("Message published successfully ....");
    }
}
