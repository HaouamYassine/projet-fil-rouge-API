package com.example.projetfilrougefrontend.dto;


import com.example.projetfilrougefrontend.entity.Event;
import com.example.projetfilrougefrontend.entity.User;

import java.time.LocalDate;
import java.util.List;

public class UserDto {
    private Long id;
    private Boolean admin;
    private String username;
    private String mail;
    private String password;
    private Boolean activate;
    private String ville;
    private String firstname;
    private String lastname;
    private LocalDate birthdate;
    private String gender;
    private String phone;




    public UserDto() {
    }






    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
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

    public User toEntity() {
        User user = new User();

        user.setId(this.id);
        user.setAdmin(this.admin);
        user.setUsername(this.username);
        user.setPassword(this.password);
        user.setMail(this.mail);
        user.setActivate(this.activate);
        user.setVille(this.ville);
        user.setBirthdate(this.birthdate);
        user.setPhone(this.phone);
        user.setFirstname(this.firstname);
        user.setLastname(this.lastname);
        user.setGender(this.gender);



        return user;
    }
}
