package com.bee.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProducerConfig {

    /**
     * Code to create kafka topic programmatically using sdk-api
     */

//    @Bean
//    public NewTopic createTopic() {
//        return new NewTopic("<TOPIC-NAME>", 3, (short) 1);
//    }
}
