package com.example.microservice1.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "medical_research_program")
public class MedicalResearchProgram {
  

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "program_name")
    private String programName;

    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "number_of_participants")
    private int numberOfParticipants;
    
    // Constructors
    public MedicalResearchProgram() {
    }
    
    @OneToMany(mappedBy = "medicalResearchProgram", cascade = CascadeType.ALL)
    private List<ResearchParticipant> participants;

    public MedicalResearchProgram(String programName, Date startDate, int numberOfParticipants) {
        this.programName = programName;
        this.startDate = startDate;
        this.numberOfParticipants = numberOfParticipants;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public void setNumberOfParticipants(int numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }


	public List<ResearchParticipant> getParticipants() {
		return participants;
	}

	public void setParticipants(List<ResearchParticipant> participants) {
		this.participants = participants;
	}
  	
}
