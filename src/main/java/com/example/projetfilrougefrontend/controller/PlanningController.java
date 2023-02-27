package com.example.projetfilrougefrontend.controller;

import com.example.projetfilrougefrontend.dto.EventDto;
import com.example.projetfilrougefrontend.dto.PlanningDto;
import com.example.projetfilrougefrontend.service.PlanningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/planning")
@CrossOrigin("http://localhost:4200")
public class PlanningController {

    @Autowired
    public PlanningService planningService;


    @GetMapping("/{id}")
    public ResponseEntity<PlanningDto> findById(@PathVariable("id") Long planningId) {
        PlanningDto planningDto = planningService.findbyId(planningId);
        if (planningDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(planningDto);
    }


}
