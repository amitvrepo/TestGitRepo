package com.example.microservice1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.microservice1.exceptions.ResourceNotFoundException;
import com.example.microservice1.model.MedicalResearchProgram;
import com.example.microservice1.model.ResearchParticipant;
import com.example.microservice1.repo.MedicalResearchProgramRepository;
import com.example.microservice1.repo.ResearchParticipantRepository;

@Service
@Transactional
public class MedicalResearchProgramService {

    
    private final MedicalResearchProgramRepository programRepository;
    private final ResearchParticipantRepository participantRepository;
    
    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    public MedicalResearchProgramService(MedicalResearchProgramRepository programRepository, ResearchParticipantRepository participantRepository) {
        this.programRepository = programRepository;
        this.participantRepository = participantRepository;
    }

    public List<MedicalResearchProgram> getAllPrograms() {
        return programRepository.findAll();
    }

    public MedicalResearchProgram getProgramById(Long id) {
        MedicalResearchProgram program = programRepository.findById(id).orElse(null);;
        if (program == null) {
            throw new ResourceNotFoundException("MedicalResearchProgram", "id", id);
        }
        return program;
    }
    @Transactional
    public MedicalResearchProgram createProgram(MedicalResearchProgram programDetails) {
    	 // Save the program
        MedicalResearchProgram savedProgram = programRepository.save(programDetails);

        // Save associated participants
     // Save associated participants
        List<ResearchParticipant> participants = programDetails.getParticipants();
        if (participants != null && !participants.isEmpty()) {
            for (ResearchParticipant participant : participants) {
                participant.setMedicalResearchProgram(savedProgram);
                participantRepository.save(participant);
            }
        }

        return savedProgram;
    }
    @Transactional
    public MedicalResearchProgram updateProgram(Long id, MedicalResearchProgram programDetails) {
    	
        MedicalResearchProgram program = programRepository.findById(id).orElse(null);
        
        if (program == null) {
            throw new ResourceNotFoundException("MedicalResearchProgram", "id", id);
        }

        program.setProgramName(programDetails.getProgramName());
        program.setStartDate(programDetails.getStartDate());
        program.setNumberOfParticipants(programDetails.getNumberOfParticipants());
        //program.setFileName(programDetails.getFileName());
       // program.setFileContentType(programDetails.getFileContentType());
      //  program.setFileData(programDetails.getFileData());
     // Update the participants list
        List<ResearchParticipant> participants = programDetails.getParticipants();
        if (participants != null && !participants.isEmpty()) {
            for (ResearchParticipant participant : participants) {
                participant.setMedicalResearchProgram(program);
               
            }
            // Save all participants (existing ones will be updated, new ones will be added)
            participantRepository.saveAll(participants);
        }

        // Save the updated program
        return programRepository.save(program);

    }
    
    @Transactional
    public void deleteProgram(Long id) {
    	 MedicalResearchProgram program = programRepository.findById(id).orElse(null);
        if (program == null) {
            throw new ResourceNotFoundException("MedicalResearchProgram", "id", id);
        }
     
        programRepository.delete(program);
     
    }
    public List<MedicalResearchProgram> getAllProgramsWithParticipants() {
        // Fetch all programs along with their participants
        return programRepository.findAllWithParticipants();
    }
}

