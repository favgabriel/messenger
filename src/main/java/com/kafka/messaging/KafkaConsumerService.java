package com.kafka.messaging;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class KafkaConsumerService {
    
    @KafkaListener(topics={"messaging-topic"},groupId="group-id")
    public void consume(String dString){
        log.info(dString);
    }
}
