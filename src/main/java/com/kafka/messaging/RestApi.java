package com.kafka.messaging;

import java.util.random.RandomGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.messaging.dto.Transaction;
import com.kafka.messaging.producer.KafkaProducerService;

@RestController
public class RestApi {
    @Autowired
    KafkaProducerService producerService;

    @PostMapping("/event")
    public ResponseEntity<String> event(@RequestBody Transaction message){
        producerService.send("messaging-topic", RandomGenerator.getDefault().toString(), message);
        return ResponseEntity.ok("send");
    }
}
