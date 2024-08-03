package com.java.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.example.models.Organizer;

@Repository
public interface OrganizerRepository extends JpaRepository<Organizer, Long> {
}
