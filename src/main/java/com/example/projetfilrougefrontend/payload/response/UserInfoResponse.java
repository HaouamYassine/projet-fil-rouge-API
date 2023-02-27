package com.example.projetfilrougefrontend.payload.response;

import java.util.List;

public class UserInfoResponse {
    private Long id;
    private String username;
    private String mail;
    private List<String> roles;

    public UserInfoResponse(Long id, String username, String mail, List<String> roles) {
        this.id = id;
        this.username = username;
        this.mail = mail;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }
}
