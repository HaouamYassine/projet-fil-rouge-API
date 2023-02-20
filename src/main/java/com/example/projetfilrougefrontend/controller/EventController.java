package com.example.projetfilrougefrontend.controller;

import com.example.projetfilrougefrontend.dto.EventDto;
import com.example.projetfilrougefrontend.dto.UserDto;
import com.example.projetfilrougefrontend.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/events")
public class EventController {


    @Autowired
    public EventService eventService;
    //gestion de planning
    ///rechercher par utilisateur


    //CREATE
    @PostMapping("/add")
    ResponseEntity<EventDto> newEvent(@RequestBody EventDto newEvent) {

        eventService.save(newEvent);

        return ResponseEntity //
                .ok()
                .body(newEvent);
    }
}
