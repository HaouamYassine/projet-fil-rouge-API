package com.example.projetfilrougefrontend.entity;

import com.example.projetfilrougefrontend.dto.UserDto;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean admin;
    @Column(unique = true)
    private String username;
    private String mail;
    private String password;
    private Boolean activate;

    @ManyToMany
    @JoinTable( name = "userAffiliate",
            joinColumns = @JoinColumn(name="idEvent"),
            inverseJoinColumns = @JoinColumn( name = "idUser" ) )
    private List<Event> eventList;


    public User() {
    }

    public User(Long id, Boolean admin, String username, String mail, String password, Boolean activate, List<Event> eventList) {
        this.id = id;
        this.admin = admin;
        this.username = username;
        this.mail = mail;
        this.password = password;
        this.activate = activate;
        this.eventList = eventList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActivate() {
        return activate;
    }

    public void setActivate(Boolean activate) {
        this.activate = activate;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    public UserDto toDto() {
        UserDto userDto = new UserDto();

        userDto.setId(this.id);
        userDto.setAdmin(this.admin);
        userDto.setUsername(this.username);
        userDto.setPassword(this.password);
        userDto.setMail(this.mail);
        userDto.setActivate(this.activate);
        return userDto;
    }
}
