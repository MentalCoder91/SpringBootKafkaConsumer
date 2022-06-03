package com.techme.springmsconsumer.controller;

import com.techme.springmsconsumer.entity.User;
import com.techme.springmsconsumer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/receive-kafka/")
public class KafkaReceiveController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/hello")
    public String hello(){

        return "Hello World";
    }

    @KafkaListener(topics = "test", groupId = "group_id")
    public void listen(Map map) {
        Map<String,String> hmap = new HashMap<>(map);
        String name = hmap.get("name");
        String address = hmap.get("address");

        User user = new User(name,address);
        System.out.println("Received Messasge : " + user);
        userRepository.save(user);
    }


//
//    @GetMapping(value = "/producer")
//    public String sendMessage(@RequestBody User user)
//    {
//        kafkaProducer.send(user);
//        return "Message sent Successfully to the Kafka topic techgeeknext-topic";
//    }






}
