package com.rabbitmqmanagement.rabbitmqmanagement.requests;


public class RabbitMQExchangeBuilder {

    private String name;
    private Boolean durable;
    private Boolean autoDelete;
    private Integer exchangeType;

    public RabbitMQExchangeBuilder(String name, Boolean durable, Boolean autoDelete, Integer exchangeType) {
        this.name = name;
        this.durable = durable;
        this.autoDelete = autoDelete;
        this.exchangeType = exchangeType;
    }

    public Integer getExchangeType() {
        return exchangeType;
    }

    public void setExchangeType(Integer exchangeType) {
        this.exchangeType = exchangeType;
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

    public Boolean getAutoDelete() {
        return autoDelete;
    }

    public void setAutoDelete(Boolean autoDelete) {
        this.autoDelete = autoDelete;
    }
}
