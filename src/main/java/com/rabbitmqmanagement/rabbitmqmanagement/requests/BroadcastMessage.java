package com.rabbitmqmanagement.rabbitmqmanagement.requests;

import java.io.Serializable;

public class BroadcastMessage implements Serializable {

    private String title;
    private String message;

    public BroadcastMessage(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "BroadcastMessage{" +
                "title='" + title + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
