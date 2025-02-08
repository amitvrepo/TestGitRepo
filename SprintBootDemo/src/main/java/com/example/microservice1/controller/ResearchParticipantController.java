package com.example.microservice1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservice1.model.ResearchParticipant;
import com.example.microservice1.repo.ResearchParticipantRepository;

@RestController
@RequestMapping("/api/v1")
public class ResearchParticipantController {

    @Autowired
    private ResearchParticipantRepository participantRepository;

    @GetMapping("/participants")
    public List<ResearchParticipant> getAllParticipants() {
        return participantRepository.findAll();
    }

    @GetMapping("/participants/{id}")
    public ResponseEntity<ResearchParticipant> getParticipantById(@PathVariable Long id) {
        ResearchParticipant participant = participantRepository.findById(id).orElse(null);
        if (participant != null) {
            return new ResponseEntity<>(participant, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/participants")
    public ResponseEntity<ResearchParticipant> createParticipant(@RequestBody ResearchParticipant participant) {
        ResearchParticipant savedParticipant = participantRepository.save(participant);
        return new ResponseEntity<>(savedParticipant, HttpStatus.CREATED);
    }

    @PutMapping("/participants/{id}")
    public ResponseEntity<ResearchParticipant> updateParticipant(@PathVariable Long id, @RequestBody ResearchParticipant participantDetails) {
        ResearchParticipant participant = participantRepository.findById(id).orElse(null);
        if (participant != null) {
            participant.setFirstName(participantDetails.getFirstName());
            participant.setLastName(participantDetails.getLastName());
            participant.setDateOfBirth(participantDetails.getDateOfBirth());
            participant.setGender(participantDetails.getGender());
            participant.setMedicalResearchProgram(participantDetails.getMedicalResearchProgram());

            ResearchParticipant updatedParticipant = participantRepository.save(participant);
            return new ResponseEntity<>(updatedParticipant, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/participants/{id}")
    public ResponseEntity<HttpStatus> deleteParticipant(@PathVariable Long id) {
        try {
            participantRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

