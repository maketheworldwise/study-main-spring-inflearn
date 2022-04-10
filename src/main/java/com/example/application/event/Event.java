package com.example.application.event;

import javax.validation.constraints.NotEmpty;

public class Event {

    int id;

    @NotEmpty
    String title;

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
}
