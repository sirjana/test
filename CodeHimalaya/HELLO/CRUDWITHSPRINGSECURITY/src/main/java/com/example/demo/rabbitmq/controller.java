package com.example.demo.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @Autowired
    private Producer producer;

    @PostMapping("/postMessage")
    public String publishMessage(
            @RequestParam("message") String message) {

        producer.sendMessage(message);
        return "Message was sent successfully";
    }
}
