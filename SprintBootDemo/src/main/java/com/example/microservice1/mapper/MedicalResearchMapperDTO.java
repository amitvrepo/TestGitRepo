package com.example.microservice1.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.microservice1.model.MedicalResearchProgram;
import com.example.microservice1.model.MedicalResearchProgramDTO;
import com.example.microservice1.model.ResearchParticipant;
import com.example.microservice1.model.ResearchParticipantDTO;

@Component
public class MedicalResearchMapperDTO {

	
	public MedicalResearchProgramDTO convertToDTO(MedicalResearchProgram program) {
        MedicalResearchProgramDTO dto = new MedicalResearchProgramDTO();
        dto.setId(program.getId());
        dto.setProgramName(program.getProgramName());
        dto.setStartDate(program.getStartDate());
        dto.setNumberOfParticipants(program.getNumberOfParticipants());

        // Populate participants information
        List<ResearchParticipantDTO> participantDTOs = new ArrayList<>();
        for (ResearchParticipant participant : program.getParticipants()) {
            participantDTOs.add(convertParticipantToDTO(participant));
        }
        dto.setParticipants(participantDTOs);

        return dto;
    }

    private ResearchParticipantDTO convertParticipantToDTO(ResearchParticipant participant) {
        ResearchParticipantDTO participantDTO = new ResearchParticipantDTO();
        participantDTO.setId(participant.getId());
        participantDTO.setFirstName(participant.getFirstName());
        participantDTO.setLastName(participant.getLastName());
        participantDTO.setDateOfBirth(participant.getDateOfBirth());
        participantDTO.setGender(participant.getGender());
        return participantDTO;
    }
}
