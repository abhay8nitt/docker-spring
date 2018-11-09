package com.abhamish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/kafka/")
public class ApacheKafkaWebController {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @RequestMapping(method = RequestMethod.GET, value = "/producer/{message}")
    public String producer(@PathVariable("message") String message) {
        kafkaTemplate.send("sometopic", message);
        return "Message sent to the Kafka Topic java_in_use_topic Successfully";
    }

}