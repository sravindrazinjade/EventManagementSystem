package com.java.example.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.example.models.Venue;
import com.java.example.repositories.VenueRepository;
import com.java.example.services.VenueService;

@Service
public class VenueServiceImpl implements VenueService{
	
	@Autowired 
	VenueRepository venueRepository;

	 @Override
	    public Venue createVenue(Venue venue) {
	        return venueRepository.save(venue);
	    }

	    @Override
	    public Venue getVenueById(Long id) {
	        return venueRepository.findById(id).orElse(null);
	    }

	    @Override
	    public Venue updateVenue(Long id, Venue venueDetails) {
	        Venue venue = venueRepository.findById(id).orElse(null);
	        if (venue != null) {
	            venue.setName(venueDetails.getName());
	            venue.setLocation(venueDetails.getLocation());
	            venue.setCapacity(venueDetails.getCapacity());
	            return venueRepository.save(venue);
	        }
	        return null;
	    }

	    @Override
	    public void deleteVenue(Long id) {
	        venueRepository.deleteById(id);
	    }

}
