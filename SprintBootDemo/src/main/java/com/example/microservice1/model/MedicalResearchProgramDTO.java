package com.example.microservice1.model;

import java.util.Date;
import java.util.List;

public class MedicalResearchProgramDTO {
	
	
	private Long id;
    private String programName;
    private Date startDate;
    private int numberOfParticipants;
    private List<ResearchParticipantDTO> participants;


    public Long getId() {
		return id;
	}
	public String getProgramName() {
		return programName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public int getNumberOfParticipants() {
		return numberOfParticipants;
	}
	public List<ResearchParticipantDTO> getParticipants() {
		return participants;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public void setNumberOfParticipants(int numberOfParticipants) {
		this.numberOfParticipants = numberOfParticipants;
	}
	public void setParticipants(List<ResearchParticipantDTO> participants) {
		this.participants = participants;
	}
	
    // Getters and setters...
}
