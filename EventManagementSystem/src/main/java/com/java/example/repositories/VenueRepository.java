package com.java.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.example.models.Venue;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Long> {

}
