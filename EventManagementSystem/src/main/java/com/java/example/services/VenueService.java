package com.java.example.services;

import com.java.example.models.Venue;

public interface VenueService {

	Venue getVenueById(Long id);

	Venue updateVenue(Long id, Venue venueDetails);

	void deleteVenue(Long id);

	Venue createVenue(Venue venue);

}
