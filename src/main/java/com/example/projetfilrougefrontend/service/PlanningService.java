package com.example.projetfilrougefrontend.service;

import com.example.projetfilrougefrontend.dto.PlanningDto;
import com.example.projetfilrougefrontend.entity.Event;
import com.example.projetfilrougefrontend.entity.Planning;
import com.example.projetfilrougefrontend.repository.PlanningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlanningService {

    @Autowired
    PlanningRepository planningRepository;



    public PlanningDto findbyId(Long planningId){
        Optional<Planning> planning = planningRepository.findById(planningId);
        return (planning.get()).toDto();
    }
}
