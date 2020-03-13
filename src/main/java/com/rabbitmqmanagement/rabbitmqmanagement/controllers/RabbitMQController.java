package com.rabbitmqmanagement.rabbitmqmanagement.controllers;

import com.rabbitmqmanagement.rabbitmqmanagement.requests.BindingDAO;
import com.rabbitmqmanagement.rabbitmqmanagement.requests.RabbitMQExchangeBuilder;
import com.rabbitmqmanagement.rabbitmqmanagement.requests.RabbitMQQueueBuilder;
import com.rabbitmqmanagement.rabbitmqmanagement.services.RabbitMQServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/delete_queue/queue_name={queueName}")
    public ResponseEntity<Boolean> deleteQueue(@PathVariable String queueName){
        return new ResponseEntity<>(rabbitMQServices.deleteQueue(queueName), HttpStatus.OK);
    }

    @DeleteMapping("/delete_exchange/exchange_name={exchangeName}")
    public ResponseEntity<Boolean> deleteExchange(@PathVariable String exchangeName){
        return new ResponseEntity<>(rabbitMQServices.deleteExchange(exchangeName), HttpStatus.OK);
    }
}
