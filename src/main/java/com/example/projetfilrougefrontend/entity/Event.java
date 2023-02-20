package com.example.projetfilrougefrontend.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.*;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDate date;

    @ManyToMany
    @JoinTable( name = "userAffiliate",
    joinColumns = @JoinColumn(name="idUser"),
            inverseJoinColumns = @JoinColumn( name = "idEvent" ) )
    private List<User> users = new ArrayList<User>();





    public Event() {
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
}
