package com.rabbitmqmanagement.rabbitmqmanagement.services;

import com.rabbitmqmanagement.rabbitmqmanagement.configs.RabbitMQConnection;
import com.rabbitmqmanagement.rabbitmqmanagement.requests.BindingDAO;
import com.rabbitmqmanagement.rabbitmqmanagement.requests.RabbitMQExchangeBuilder;
import com.rabbitmqmanagement.rabbitmqmanagement.requests.RabbitMQQueueBuilder;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class RabbitMQServices {

    private static final Logger logger = Logger.getLogger(RabbitMQServices.class.getName());

    private final RabbitAdmin rabbitAdmin = new RabbitAdmin(RabbitMQConnection.connectionFactory());


    public void declareBinding(BindingDAO binder){
        rabbitAdmin.declareBinding(
                new Binding(binder.getQueueName(),
                        Binding.DestinationType.QUEUE,
                        binder.getExchangeName(),
                        binder.getRoutingKey(),
                        null));

        logger.log(Level.INFO, "created Bind: queue = [" + binder.getQueueName() + "] to exchange = [" + binder.getExchangeName() + "] with routing key = [" + binder.getRoutingKey() + "]");
    }

    public void declareQueue(RabbitMQQueueBuilder queueBuilder){
        Queue queue = new Queue(queueBuilder.getName(), queueBuilder.getDurable());
        rabbitAdmin.declareQueue(queue);

        logger.log(Level.INFO, "created Queue: " + queue.getName() + " " + queue.isDurable());
    }

    public Boolean deleteQueue(String name){
        return rabbitAdmin.deleteQueue(name);
    }



    /////////////////////////////////////--------------------//////////////////////////
    public void declareExchange(RabbitMQExchangeBuilder exchangeBuilder){
        rabbitAdmin.declareExchange(
                exchangeCreator(
                        exchangeBuilder.getExchangeType(),
                        exchangeBuilder.getName(),
                        exchangeBuilder.getDurable(),
                        exchangeBuilder.getAutoDelete()));

        logger.log(Level.INFO, "created Exchange: " + rabbitAdmin.toString());

    }

    public Boolean deleteExchange(String name){
        return rabbitAdmin.deleteExchange(name);
    }

    ///
    /// EXCHANGE SELECTOR/CREATOR
    private Exchange exchangeCreator(Integer exchange, String exchangeName, Boolean durable, Boolean autoDelete){
        switch (exchange){
            case 1 :
                 return new DirectExchange(exchangeName, durable, autoDelete);
            case 2 :
                return new TopicExchange(exchangeName, durable, autoDelete);
            case 3 :
                return new FanoutExchange(exchangeName, durable, autoDelete);
            case 4 :
                return new HeadersExchange(exchangeName, durable, autoDelete);
            default:
                return null;

        }
    }
}
