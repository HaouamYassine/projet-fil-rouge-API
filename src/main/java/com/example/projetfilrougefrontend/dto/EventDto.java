package com.example.projetfilrougefrontend.dto;

import com.example.projetfilrougefrontend.entity.Event;
import com.example.projetfilrougefrontend.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class EventDto {
    private Long id;
    private String title;
    private String description;
    //TODO: mettre strartime et endtime en format LocalDateTime
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate date;
    @JsonIgnore
    private User user;

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

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event toEntity() {Event event = new Event();
        //TODO: mettre strartime et endtime en format LocalDateTime
        event.setId(this.id);
        event.setTitle(this.title);
        event.setDate(this.date);
        event.setStartTime(this.startTime);
        event.setEndTime(this.endTime);
        event.setDescription(this.description);


        return event;
    }
}
