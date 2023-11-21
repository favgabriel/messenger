package com.kafka.messaging.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kafka.messaging.dto.Transaction;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KafkaProducerService {
    
    @Autowired
    KafkaTemplate<String,Transaction> kafkaTemplate;

    public void send(String topic, String key, Transaction message){
        var future = kafkaTemplate.send(topic,key, message);
        future.whenComplete((sendResult,exception)->{
            if (exception != null) {
                log.error(exception.getMessage());
                future.completeExceptionally(exception);
            }else{
                future.complete(sendResult);
            }
            log.info("sent");
        });
    }
}
