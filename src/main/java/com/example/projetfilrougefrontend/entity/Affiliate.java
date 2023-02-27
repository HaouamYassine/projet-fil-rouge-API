package com.example.projetfilrougefrontend.entity;


import jakarta.persistence.*;

@Entity
public class Affiliate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "planning_id")
    private Planning planning;

    // planningRights sera propre à cette entité de type Long
    private Long planningRights;

    public Affiliate() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Planning getPlanning() {
        return planning;
    }

    public void setPlanning(Planning planning) {
        this.planning = planning;
    }



    public Long getPlanningRights() {
        return planningRights;
    }

    public void setPlanningRights(Long planningRights) {
        this.planningRights = planningRights;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
