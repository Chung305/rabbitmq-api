package com.rabbitmqmanagement.rabbitmqmanagement.controllers;

import com.rabbitmqmanagement.rabbitmqmanagement.requests.BroadcastMessage;
import com.rabbitmqmanagement.rabbitmqmanagement.services.RabbitMQSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/send")
public class RabbitMQSenderController {

    @Autowired
    private RabbitMQSenderService senderService;

    @PostMapping("/exchange={exchange}/routing_key={routingKey}")
    public ResponseEntity<?> broadcastMessage (@PathVariable String exchange, @PathVariable String routingKey, @RequestBody BroadcastMessage message){
        senderService.broadcastMessage(exchange, routingKey, message);
        return ResponseEntity.ok().build();
    }
}
