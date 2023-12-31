package com.kafka.messaging.utils;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {
    
    @Bean
    public NewTopic messagingtopic(){
        return TopicBuilder.name("messaging-topic")
        .partitions(2)
        .replicas(2)
        .build();
    }
}
