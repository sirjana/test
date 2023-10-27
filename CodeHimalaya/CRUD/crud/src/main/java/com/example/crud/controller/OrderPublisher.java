package com.example.crud.controller;

import com.example.crud.config.RabbitMQConfig;
import com.example.crud.dto.Order;
import com.example.crud.dto.OrderStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class OrderPublisher {

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/order")
    public String bookOrder(@RequestBody Order order) {
        order.setOrderId(UUID.randomUUID().toString());
        OrderStatus orderStatus = new OrderStatus(order, "PROCESS", "order placed succesfully");
        template.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, orderStatus);
        return "Success !!";
}
}