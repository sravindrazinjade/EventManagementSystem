package com.java.example.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.example.models.Organizer;
import com.java.example.repositories.OrganizerRepository;
import com.java.example.services.OrganizerService;

@Service
public class OrganizerServiceImpl implements OrganizerService {
	
	@Autowired
	
	OrganizerRepository organizerRepository;

	 @Override
	    public Organizer createOrganizer(Organizer organizer) {
	        return organizerRepository.save(organizer);
	    }

	    @Override
	    public Organizer getOrganizerById(Long id) {
	        return organizerRepository.findById(id).orElse(null);
	    }

	    @Override
	    public Organizer updateOrganizer(Long id, Organizer organizerDetails) {
	        Organizer organizer = organizerRepository.findById(id).orElse(null);
	        if (organizer != null) {
	            organizer.setName(organizerDetails.getName());
	            organizer.setContactInfo(organizerDetails.getContactInfo());
	            return organizerRepository.save(organizer);
	        }
	        return null;
	    }

	    @Override
	    public void deleteOrganizer(Long id) {
	        organizerRepository.deleteById(id);
	    }
}
