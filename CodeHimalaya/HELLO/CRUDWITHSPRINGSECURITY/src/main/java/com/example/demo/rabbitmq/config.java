package com.example.demo.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;

public class config {

    public static final String QUEUE = "queue";
    public static final String EXCHANGE = "exchange";
    public static final String ROUTING_KEY = "routingKey";

    @Bean
    Queue createQueue() {

        return new Queue(QUEUE);
    }

    @Bean
    TopicExchange exchange() {

        return new TopicExchange(EXCHANGE);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {

        return BindingBuilder.bind(queue).
                to(exchange).with(ROUTING_KEY);
    }

    @Bean
    SimpleMessageListenerContainer container(
            ConnectionFactory connectionFactory) {

        SimpleMessageListenerContainer container =
                new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);

        return container;
    }
}
