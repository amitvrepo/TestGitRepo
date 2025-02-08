package com.example.microservice1.controller;


import java.util.List;

import com.example.microservice1.service.MessageProducer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.example.microservice1.mapper.MedicalResearchMapperDTO;
import com.example.microservice1.model.MedicalResearchProgram;
import com.example.microservice1.model.MedicalResearchProgramDTO;
import com.example.microservice1.service.MedicalResearchProgramService;

@RestController
@RequestMapping("/api/v1")
public class MedicalResearchProgramController {
	
	private static final Logger logger = LoggerFactory.getLogger(MedicalResearchProgramController.class);
	
	private MedicalResearchProgramService medicalProgramService;
	
	 @Autowired
	 private MedicalResearchMapperDTO programMapperDTO;
	 
	 
	 @Autowired
	 private MessageProducer messageProducer; // Inject MessageProducer

   
    public MedicalResearchProgramController(MedicalResearchProgramService programService) {
        this.medicalProgramService = programService;
    }

    @GetMapping("/programs")  
    public List<MedicalResearchProgram> getAllPrograms() {
        return medicalProgramService.getAllPrograms();
    }

    @GetMapping("/programs/{id}")
    public ResponseEntity<MedicalResearchProgram> getProgramById(@PathVariable Long id) {
    	logger.info("*******getProgramById called*******");
        MedicalResearchProgram program = medicalProgramService.getProgramById(id);
        return new ResponseEntity<>(program, HttpStatus.OK);
    }


    
    @PostMapping("/programs")
    public ResponseEntity<MedicalResearchProgramDTO> createProgram(@RequestBody MedicalResearchProgram programDetails)
             {
    	logger.info("*******createProgram called*******");
    	//MedicalResearchProgram savedProgram = medicalProgramService.createProgram(file,program);
    	MedicalResearchProgram savedProgram =medicalProgramService.createProgram(programDetails);
    	MedicalResearchProgramDTO researchProgramDTO = programMapperDTO.convertToDTO(savedProgram);
        return new ResponseEntity<>(researchProgramDTO, HttpStatus.CREATED);
    }

    @PutMapping("/programs/{id}")
    public ResponseEntity<MedicalResearchProgram> updateProgram(@PathVariable Long id, @RequestBody MedicalResearchProgram programDetails) {
    	logger.info("*******updateProgram called*******");
    	
    	 MedicalResearchProgram updatedProgram = medicalProgramService.updateProgram(id, programDetails);
         return new ResponseEntity<>(updatedProgram, HttpStatus.OK);
    }

    
   
    @GetMapping("/programs/programs-with-participants")
    public List<MedicalResearchProgram> getAllProgramsWithParticipants() {
        // Fetch programs along with participants
        return medicalProgramService.getAllProgramsWithParticipants();
    }
    
    
    @DeleteMapping("/programs/{id}")
    public ResponseEntity<HttpStatus> deleteProgram(@PathVariable Long id) {
    	logger.info("*******deleteProgram called*******");
    	medicalProgramService.deleteProgram(id);
    	// Send message to ActiveMQ
    	 messageProducer.sendMessage("Program deleted with id: " + id);
    	 logger.info("****************deleted *************");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
