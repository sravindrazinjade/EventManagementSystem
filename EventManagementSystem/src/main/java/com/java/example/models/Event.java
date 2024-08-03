package com.java.example.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String eventName;
	private LocalDate eventDate;
	private String description;

	@ManyToOne
	@JoinColumn(name = "organizer_id")
	private Organizer organizer;

	@OneToOne
	@JoinColumn(name = "venue_id")
	private Venue venue;

}