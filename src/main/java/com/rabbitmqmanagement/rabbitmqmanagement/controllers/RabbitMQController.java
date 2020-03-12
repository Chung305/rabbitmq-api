package com.rabbitmqmanagement.rabbitmqmanagement.controllers;

import com.rabbitmqmanagement.rabbitmqmanagement.requests.BindingDAO;
import com.rabbitmqmanagement.rabbitmqmanagement.requests.RabbitMQExchangeBuilder;
import com.rabbitmqmanagement.rabbitmqmanagement.requests.RabbitMQQueueBuilder;
import com.rabbitmqmanagement.rabbitmqmanagement.services.RabbitMQServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rabbitmq")
public class RabbitMQController {

    @Autowired
    public RabbitMQServices rabbitMQServices;

    @PostMapping("/create-exchange")
    public ResponseEntity<?> createExchange(@RequestBody RabbitMQExchangeBuilder exchangeBuilder){
        rabbitMQServices.declareExchange(exchangeBuilder);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/create-queue")
    public ResponseEntity<?> createQueue(@RequestBody RabbitMQQueueBuilder queueBuilder){
        rabbitMQServices.declareQueue(queueBuilder);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/binding")
    public ResponseEntity<?> createBind(@RequestBody BindingDAO bindingDAO){
        rabbitMQServices.declareBinding(bindingDAO);
        return ResponseEntity.ok().build();
    }
}
