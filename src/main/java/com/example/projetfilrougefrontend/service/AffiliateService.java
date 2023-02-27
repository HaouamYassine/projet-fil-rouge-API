package com.example.projetfilrougefrontend.service;


import com.example.projetfilrougefrontend.dto.AffiliateDto;
import com.example.projetfilrougefrontend.dto.EventDto;
import com.example.projetfilrougefrontend.entity.Affiliate;
import com.example.projetfilrougefrontend.entity.Event;
import com.example.projetfilrougefrontend.repository.AffiliateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AffiliateService {

    @Autowired
    AffiliateRepository affiliateRepository;

    public void save(Affiliate affiliate) {
        affiliateRepository.save(affiliate);
    }
}
