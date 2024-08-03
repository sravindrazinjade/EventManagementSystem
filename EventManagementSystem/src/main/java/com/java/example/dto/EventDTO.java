package com.java.example.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EventDTO {
	private Long id;
	private String eventName;
	private LocalDate eventDate;
	private String description;
	private OrganizerDTO organizer;
	private VenueDTO venue;
}