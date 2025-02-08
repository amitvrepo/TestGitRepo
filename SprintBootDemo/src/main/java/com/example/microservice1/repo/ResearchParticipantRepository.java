package com.example.microservice1.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.microservice1.model.ResearchParticipant;

public interface ResearchParticipantRepository extends JpaRepository<ResearchParticipant, Long> {
}
