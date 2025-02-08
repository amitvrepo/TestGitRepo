package com.example.microservice1.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "research_participant")
public class ResearchParticipant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String gender;

    // File attachment field can be represented as a byte array or a file path
    // For simplicity, let's use a file path

    @ManyToOne
    @JoinColumn(name = "medical_research_program_id")
    private MedicalResearchProgram medicalResearchProgram;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	public MedicalResearchProgram getMedicalResearchProgram() {
		return medicalResearchProgram;
	}

	public void setMedicalResearchProgram(MedicalResearchProgram medicalResearchProgram) {
		this.medicalResearchProgram = medicalResearchProgram;
	}

    // Constructors, getters, setters
}
