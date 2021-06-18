package com.taller1.CristianLasso.front.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the SYMPTOM database table.
 * 
 */
public class Symptom implements Serializable {
	private static final long serialVersionUID = 1L;

	private long sympId;

	private String sympIsactive;

	private String sympName;

	@JsonIgnore
	private List<Symptomquestion> symptomquestions;

	public Symptom(){
		
	}

	public long getSympId() {
		return this.sympId;
	}

	public void setSympId(long sympId) {
		this.sympId = sympId;
	}

	public String getSympIsactive() {
		return this.sympIsactive;
	}

	public void setSympIsactive(String sympIsactive) {
		this.sympIsactive = sympIsactive;
	}

	public String getSympName() {
		return this.sympName;
	}

	public void setSympName(String sympName) {
		this.sympName = sympName;
	}

	public List<Symptomquestion> getSymptomquestions() {
		return this.symptomquestions;
	}

	public void setSymptomquestions(List<Symptomquestion> symptomquestions) {
		this.symptomquestions = symptomquestions;
	}

	public Symptomquestion addSymptomquestion(Symptomquestion symptomquestion) {
		getSymptomquestions().add(symptomquestion);
		symptomquestion.setSymptom(this);

		return symptomquestion;
	}

	public Symptomquestion removeSymptomquestion(Symptomquestion symptomquestion) {
		getSymptomquestions().remove(symptomquestion);
		symptomquestion.setSymptom(null);

		return symptomquestion;
	}

}