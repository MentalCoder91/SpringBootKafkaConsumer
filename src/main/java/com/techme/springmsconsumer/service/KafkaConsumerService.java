package com.techme.springmsconsumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    String kafkaTopic = "test";



//    public void send(User user) {
//
//        kafkaTemplate.send(kafkaTopic, user);
//    }
}
