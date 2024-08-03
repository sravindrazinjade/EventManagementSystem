package com.java.example.services;

import com.java.example.models.Organizer;

public interface OrganizerService {

	void deleteOrganizer(Long id);

	Organizer updateOrganizer(Long id, Organizer organizerDetails);

	Organizer getOrganizerById(Long id);

	Organizer createOrganizer(Organizer organizer);

}
