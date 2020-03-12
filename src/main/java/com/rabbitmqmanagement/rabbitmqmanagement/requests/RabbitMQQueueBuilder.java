package com.rabbitmqmanagement.rabbitmqmanagement.requests;

public class RabbitMQQueueBuilder {

    private String name;
    private Boolean durable;

    public RabbitMQQueueBuilder(String name, Boolean durable) {
        this.name = name;
        this.durable = durable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDurable() {
        return durable;
    }

    public void setDurable(Boolean durable) {
        this.durable = durable;
    }
}
