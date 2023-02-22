package com.example.projetfilrougefrontend.entity;

import com.example.projetfilrougefrontend.dto.EventDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.*;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    //  @JsonFormat(pattern = "yyyy-MM-dd")
    //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;

    @ManyToMany
    @JoinTable(name = "userAffiliate",
            joinColumns = @JoinColumn(name = "idUser"),
            inverseJoinColumns = @JoinColumn(name = "idEvent"))
    private List<User> users = new ArrayList<User>();


    public Event() {
    }

    public Event(Long id, String title, String description, LocalDate date, List<User> users) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.users = users;
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

    public EventDto toDto() {
        EventDto eventDto = new EventDto();

        eventDto.setId(this.id);
        eventDto.setDate(this.date);
        eventDto.setTitle(this.title);
        eventDto.setDescription(this.description);
        eventDto.setUsers(this.users);
        eventDto.setDate(this.date);
        return eventDto;

    }
}
