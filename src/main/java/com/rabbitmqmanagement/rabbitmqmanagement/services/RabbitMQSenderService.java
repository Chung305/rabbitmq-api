package com.rabbitmqmanagement.rabbitmqmanagement.services;

import com.rabbitmqmanagement.rabbitmqmanagement.configs.RabbitMQConnection;
import com.rabbitmqmanagement.rabbitmqmanagement.requests.BroadcastMessage;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class RabbitMQSenderService {

    private static final Logger logger = Logger.getLogger(RabbitMQSenderService.class.getName());

    private final RabbitAdmin rabbitAdmin = new RabbitAdmin(RabbitMQConnection.connectionFactory());

    public void broadcastMessage(String exchange, String routingKey, BroadcastMessage message){
        rabbitAdmin.getRabbitTemplate()
                .convertAndSend(exchange, routingKey, message);

        logger.log(Level.INFO, "Message sent: to exchange = [" + exchange + "] and routing key = [" + routingKey + "]");
    }

}
