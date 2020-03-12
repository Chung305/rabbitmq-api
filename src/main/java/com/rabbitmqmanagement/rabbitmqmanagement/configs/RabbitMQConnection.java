package com.rabbitmqmanagement.rabbitmqmanagement.configs;

import com.rabbitmqmanagement.rabbitmqmanagement.services.RabbitMQServices;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Level;
import java.util.logging.Logger;

@Configuration
public class RabbitMQConnection {

    private static final Logger logger = Logger.getLogger(RabbitMQConnection.class.getName());


    public static ConnectionFactory connectionFactory(){
            CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("localhost");
            cachingConnectionFactory.setUsername("guest");
            cachingConnectionFactory.setPassword("guest");
            return cachingConnectionFactory;

    }


}
