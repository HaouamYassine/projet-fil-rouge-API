package com.example.projetfilrougefrontend.service;

import com.example.projetfilrougefrontend.dto.EventDto;
import com.example.projetfilrougefrontend.dto.UserDto;
import com.example.projetfilrougefrontend.entity.Event;
import com.example.projetfilrougefrontend.entity.User;
import com.example.projetfilrougefrontend.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    public List<Event> fetchEventsById(UserDto userDto) {
        return eventRepository.findEventsByUser(userDto.toEntity());
    }

    public void save(EventDto eventDto) {
        Event event = eventDto.toEntity();
        eventRepository.save(event);
    }

    public void deleteById(Long eventId){
        eventRepository.deleteById(eventId);
    }


    public List<EventDto> fetchEvents() {
        return eventRepository.findAll()
                .stream()
                .map(event -> event.toDto())
                .collect(Collectors.toList());
    }

    public EventDto findById(Long eventId){

        Optional<Event> event = eventRepository.findById(eventId);
        return (event.get()).toDto();
    }

    public void update(EventDto eventDto, Long eventId) {
        Event event = eventDto.toEntity();
        Optional<Event> eventToUpdate = eventRepository.findById(eventId);
        if (eventToUpdate.isPresent())
        {
            event.setId(eventToUpdate.get().getId());
            eventRepository.save(event);
        }
    }
}
