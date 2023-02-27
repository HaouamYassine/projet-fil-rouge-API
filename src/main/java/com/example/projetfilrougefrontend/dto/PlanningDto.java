package com.example.projetfilrougefrontend.dto;

import com.example.projetfilrougefrontend.entity.Affiliate;
import com.example.projetfilrougefrontend.entity.Planning;

import java.util.HashSet;
import java.util.Set;

public class PlanningDto {

    Long id;
    private Set<Affiliate> affiliates = new HashSet<>();



    public PlanningDto() {
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

    public Planning toEntity() {
        Planning planning = new Planning();

        planning.setId(this.id);
        planning.setAffiliates(this.affiliates);

        return planning;
    }

}
