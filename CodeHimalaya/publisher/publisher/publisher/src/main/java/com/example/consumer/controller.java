package com.example.consumer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/messages")
@Slf4j
@AllArgsConstructor
public class controller {
    public static final String ROUTING_KEY = "queue";

    private final RabbitTemplate rabbitTemplate;

    @PostMapping
    public void sendMessage(@RequestBody model user) {
        rabbitTemplate.convertAndSend(ROUTING_KEY, user);
        log.info("Message sent to RabbitMQ: {}", user);
    }

}
