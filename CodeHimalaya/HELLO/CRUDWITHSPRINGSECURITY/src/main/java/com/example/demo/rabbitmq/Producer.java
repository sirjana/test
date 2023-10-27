package com.example.demo.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    public static final String EXCHANGE = "exchange";
    public static final String ROUTING_KEY = "routingKey";

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void sendMessage(String message){

        rabbitTemplate.convertAndSend(
                EXCHANGE, ROUTING_KEY, message);
    }
}
