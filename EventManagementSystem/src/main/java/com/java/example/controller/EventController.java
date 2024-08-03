package com.java.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.example.dto.EventDTO;
import com.java.example.dto.OrganizerDTO;
import com.java.example.dto.VenueDTO;
import com.java.example.models.Event;
import com.java.example.models.Organizer;
import com.java.example.models.Venue;
import com.java.example.services.EventServices;

@RestController
@RequestMapping("/events")
public class EventController {
    @Autowired
    private EventServices eventService;

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        Event createdEvent = eventService.createEvent(event);
        return new ResponseEntity<>(createdEvent, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDTO> getEventById(@PathVariable Long id) {
        EventDTO eventDTO = eventService.getEventDTOById(id);
        return eventDTO != null ? new ResponseEntity<>(eventDTO, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event eventDetails) {
        Optional<Event> updatedEvent = eventService.updateEvent(id, eventDetails);
        if (updatedEvent.isPresent()) {
            return new ResponseEntity<>(updatedEvent.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/venue/{venueId}")
    public ResponseEntity<List<Event>> getEventsByVenue(@PathVariable Long venueId) {
        Venue venue = new Venue();
        venue.setId(venueId);
        List<Event> events = eventService.getEventsByVenue(venue);
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @GetMapping("/organizer/{organizerId}")
    public ResponseEntity<List<Event>> getEventsByOrganizer(@PathVariable Long organizerId) {
        Organizer organizer = new Organizer();
        organizer.setId(organizerId);
        List<Event> events = eventService.getEventsByOrganizer(organizer);
        return new ResponseEntity<>(events, HttpStatus.OK);
    }
    
 

}