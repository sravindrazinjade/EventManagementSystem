package com.java.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.example.models.Event;
import com.java.example.models.Organizer;
import com.java.example.models.Venue;

@Repository
public interface EventRepository  extends JpaRepository<Event, Long>{

	List<Event> findByVenue(Venue venue);

	List<Event> findByOrganizer(Organizer organizer);

}
