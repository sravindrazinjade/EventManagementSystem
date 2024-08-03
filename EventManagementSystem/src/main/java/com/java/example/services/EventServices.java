package com.java.example.services;

import java.util.List;
import java.util.Optional;

import com.java.example.dto.EventDTO;
import com.java.example.models.Event;
import com.java.example.models.Organizer;
import com.java.example.models.Venue;

public interface EventServices {
    Event createEvent(Event event);
    List<Event> getAllEvents();
    EventDTO getEventDTOById(Long id); // New method for getting EventDTO
    Optional<Event> updateEvent(Long id, Event eventDetails);
    void deleteEvent(Long id);
    List<Event> getEventsByVenue(Venue venue);
    List<Event> getEventsByOrganizer(Organizer organizer);
}
