package com.example.projetfilrougefrontend.entity;

import com.example.projetfilrougefrontend.dto.UserDto;
import jakarta.persistence.*;

import java.time.LocalDate;
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
    private String ville;
    private String firstname;
    private String lastname;
    private LocalDate birthdate;
    private String gender;
    private String phone;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable( name = "userAffiliate",
            joinColumns = @JoinColumn(name="idEvent"),
            inverseJoinColumns = @JoinColumn( name = "idUser" ) )
    private List<Event> eventList;


    public User() {
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

    public User(String mail, String password, String ville, String firstname, String lastname, LocalDate birthdate, String gender, String phone) {
        this.mail = mail;
        this.password = password;
        this.ville = ville;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.gender = gender;
        this.phone = phone;
    }

    public User(Long id, Boolean admin,
                String username,
                String mail,
                String password,
                Boolean activate,
                String ville,
                String firstname,
                String lastname,
                LocalDate birthdate,
                String gender,
                String phone,

                List<Event> eventList) {
        this.id = id;
        this.admin = admin;
        this.username = username;
        this.mail = mail;
        this.password = password;
        this.activate = activate;
        this.ville=ville;
        this.firstname=firstname;
        this.lastname=lastname;
        this.birthdate=birthdate;
        this.gender=gender;
        this.phone=phone;

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
        userDto.setVille(this.ville);
        userDto.setBirthdate(this.birthdate);
        userDto.setGender(this.gender);
        userDto.setPhone(this.phone);
        userDto.setFirstname(this.firstname);
        userDto.setLastname(this.lastname);
        return userDto;
    }
}
