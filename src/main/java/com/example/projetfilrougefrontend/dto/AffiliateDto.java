package com.example.projetfilrougefrontend.dto;

import com.example.projetfilrougefrontend.entity.Affiliate;

public class AffiliateDto {

    private Long id;
    private Long idEvent;
    private Long idUser;

    public AffiliateDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Long idEvent) {
        this.idEvent = idEvent;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

//    public AffiliateDto toEntitiy() {Affiliate affilate = new Affiliate();
//        affilate.setId(this.id);
////        affilate.setUser();
////        affilate.set

//    }
}