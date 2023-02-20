package com.example.projetfilrougefrontend.service;

import com.example.projetfilrougefrontend.dto.EventDto;
import com.example.projetfilrougefrontend.dto.UserDto;
import com.example.projetfilrougefrontend.entity.Event;
import com.example.projetfilrougefrontend.entity.User;
import com.example.projetfilrougefrontend.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    public void save(EventDto eventDto) {
        Event event = eventDto.toEntity();
        eventRepository.save(event);
    }



}
