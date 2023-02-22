package com.example.projetfilrougefrontend.controller;

import com.example.projetfilrougefrontend.dto.EventDto;
import com.example.projetfilrougefrontend.dto.UserDto;
import com.example.projetfilrougefrontend.entity.Event;
import com.example.projetfilrougefrontend.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/events")
@CrossOrigin("http://localhost:4200")
public class EventController {


    @Autowired
    public EventService eventService;
    //gestion de planning
    ///rechercher par utilisateur


    //CREATE
    @PostMapping("/add")
    ResponseEntity<EventDto> newEvent(@RequestBody EventDto newEvent) {

        try {
            eventService.save(newEvent);
        } catch (Exception e)
        { e.getMessage();

        }

        return ResponseEntity
                .ok()
                .body(newEvent);
    }

    // GET = READ
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EventDto> displayAllEvents() {
        List<EventDto> eventDtoList = eventService.fetchEvents();
        return eventDtoList;
    }

    //READ - GET EVENT BY ID
    @GetMapping("/{id}")
    public ResponseEntity<EventDto> findById(@PathVariable("id") Long eventId) {
        EventDto eventDto = eventService.findById(eventId);
        if (eventDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(eventDto);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<EventDto> update(@PathVariable("id") Long eventId, @RequestBody EventDto eventDto) {
        eventService.update(eventDto, eventId);
        return ResponseEntity.ok(eventDto);
    }

    //DEL = DELETE
    @DeleteMapping("{id}")
    public void DeleteById(@PathVariable("id") Long eventId) {
        eventService.deleteById(eventId);
    }

}
