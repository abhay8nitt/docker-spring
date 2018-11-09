package com.abhamish.service;


import org.springframework.stereotype.Service;

@Service
public class KafkaListener {

    @org.springframework.kafka.annotation.KafkaListener(topics = "sometopic", group = "group_id")
    public void consumer(String message){
        System.out.println("Received: "+ message);
    }
}
