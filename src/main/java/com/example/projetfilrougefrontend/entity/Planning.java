package com.example.projetfilrougefrontend.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Planning {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "planning_id")
    Long id;


    @OneToMany(mappedBy = "planning")
    private Set<Affiliate> affiliates = new HashSet<>();


    public Planning() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Set<Affiliate> getAffiliates() {
        return affiliates;
    }

    public void setAffiliates(Set<Affiliate> affiliates) {
        this.affiliates = affiliates;
    }
}
