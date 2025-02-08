package com.example.microservice1.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.microservice1.model.MedicalResearchProgram;

@Repository
public interface MedicalResearchProgramRepository extends JpaRepository<MedicalResearchProgram, Long> {
	@Query("SELECT DISTINCT p FROM MedicalResearchProgram p LEFT JOIN FETCH p.participants")
    List<MedicalResearchProgram> findAllWithParticipants();
}