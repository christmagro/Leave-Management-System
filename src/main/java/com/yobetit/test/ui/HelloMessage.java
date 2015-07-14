package com.yobetit.test.ui;

import java.io.Serializable;

public class HelloMessage implements Serializable{

    private int id;
    private String title;
    private String message;

    public HelloMessage(int id) {
        this.id = id;
    }

    public HelloMessage(int id, String title, String message) {
        this.id = id;
        this.title = title;
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloMessage{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
