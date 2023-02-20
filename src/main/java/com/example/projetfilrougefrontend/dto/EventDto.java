package com.example.projetfilrougefrontend.dto;

import com.example.projetfilrougefrontend.entity.Event;
import com.example.projetfilrougefrontend.entity.User;

import java.time.LocalDate;
import java.util.List;

public class EventDto {
    private Long id;
    private String title;
    private String description;
    private LocalDate date;

    private List<User> users;

    public EventDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Event toEntity() {Event event = new Event();
        event.setId(this.id);
        event.setTitle(this.title);
        event.setDescription(this.description);
        event.setUsers(this.users);


        return event;
    }
}
