package com.java.example.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.example.dto.EventDTO;
import com.java.example.dto.OrganizerDTO;
import com.java.example.dto.VenueDTO;
import com.java.example.models.Event;
import com.java.example.models.Organizer;
import com.java.example.models.Venue;
import com.java.example.repositories.EventRepository;
import com.java.example.repositories.OrganizerRepository;
import com.java.example.repositories.VenueRepository;
import com.java.example.services.EventServices;

@Service
public class EventServicesImpl implements EventServices {

	 @Autowired
	    private EventRepository eventRepository;

	    @Autowired
	    private OrganizerRepository organizerRepository;

	    @Autowired
	    private VenueRepository venueRepository;

	    @Override
	    public Event createEvent(Event event) {
	        Organizer organizer = organizerRepository.findById(event.getOrganizer().getId()).orElse(null);
	        Venue venue = venueRepository.findById(event.getVenue().getId()).orElse(null);
	        
	        event.setOrganizer(organizer);
	        event.setVenue(venue);
	        
	        return eventRepository.save(event);
	    }

	    @Override
	    public List<Event> getAllEvents() {
	        return eventRepository.findAll();
	    }

	    @Override
	    public EventDTO getEventDTOById(Long id) {
	        return eventRepository.findById(id).map(this::convertToDTO).orElse(null);
	    }

	    @Override
	    public Optional<Event> updateEvent(Long id, Event eventDetails) {
	        return eventRepository.findById(id).map(event -> {
	            event.setEventName(eventDetails.getEventName());
	            event.setEventDate(eventDetails.getEventDate());
	            event.setDescription(eventDetails.getDescription());

	            // Fetch the full Organizer and Venue objects
	            Organizer organizer = organizerRepository.findById(eventDetails.getOrganizer().getId()).orElse(null);
	            Venue venue = venueRepository.findById(eventDetails.getVenue().getId()).orElse(null);

	            event.setOrganizer(organizer);
	            event.setVenue(venue);

	            return eventRepository.save(event);
	        });
	    }

	    @Override
	    public void deleteEvent(Long id) {
	        eventRepository.deleteById(id);
	    }

	    @Override
	    public List<Event> getEventsByVenue(Venue venue) {
	        return eventRepository.findByVenue(venue);
	    }

	    @Override
	    public List<Event> getEventsByOrganizer(Organizer organizer) {
	        return eventRepository.findByOrganizer(organizer);
	    }

	    // Convert Event to EventDTO
	    private EventDTO convertToDTO(Event event) {
	        EventDTO dto = new EventDTO();
	        dto.setId(event.getId());
	        dto.setEventName(event.getEventName());
	        dto.setEventDate(event.getEventDate());
	        dto.setDescription(event.getDescription());

	        if (event.getOrganizer() != null) {
	            OrganizerDTO organizerDTO = new OrganizerDTO();
	            organizerDTO.setId(event.getOrganizer().getId());
	            organizerDTO.setName(event.getOrganizer().getName());
	            organizerDTO.setContactInfo(event.getOrganizer().getContactInfo());
	            dto.setOrganizer(organizerDTO);
	        }

	        if (event.getVenue() != null) {
	            VenueDTO venueDTO = new VenueDTO();
	            venueDTO.setId(event.getVenue().getId());
	            venueDTO.setName(event.getVenue().getName());
	            venueDTO.setLocation(event.getVenue().getLocation());
	            venueDTO.setCapacity(event.getVenue().getCapacity());
	            dto.setVenue(venueDTO);
	        }

	        return dto;
	    }
	}