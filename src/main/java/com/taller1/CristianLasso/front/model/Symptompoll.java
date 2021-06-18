package com.taller1.CristianLasso.front.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the SYMPTOMPOLL database table.
 * 
 */
public class Symptompoll implements Serializable {
	private static final long serialVersionUID = 1L;

	private long sympollId;

	private BigDecimal instInstId;

	private Date sympollEnddate;

	private String sympollName;

	private Date sympollStartdate;

	@JsonIgnore
	private List<Symptomquestion> symptomquestions;

	public Symptompoll() {
	}

	public long getSympollId() {
		return this.sympollId;
	}

	public void setSympollId(long sympollId) {
		this.sympollId = sympollId;
	}

	public BigDecimal getInstInstId() {
		return this.instInstId;
	}

	public void setInstInstId(BigDecimal instInstId) {
		this.instInstId = instInstId;
	}

	public Date getSympollEnddate() {
		return this.sympollEnddate;
	}

	public void setSympollEnddate(Date sympollEnddate) {
		this.sympollEnddate = sympollEnddate;
	}

	public String getSympollName() {
		return this.sympollName;
	}

	public void setSympollName(String sympollName) {
		this.sympollName = sympollName;
	}

	public Date getSympollStartdate() {
		return this.sympollStartdate;
	}

	public void setSympollStartdate(Date sympollStartdate) {
		this.sympollStartdate = sympollStartdate;
	}

	public List<Symptomquestion> getSymptomquestions() {
		return this.symptomquestions;
	}

	public void setSymptomquestions(List<Symptomquestion> symptomquestions) {
		this.symptomquestions = symptomquestions;
	}

	public Symptomquestion addSymptomquestion(Symptomquestion symptomquestion) {
		getSymptomquestions().add(symptomquestion);
		symptomquestion.setSymptompoll(this);

		return symptomquestion;
	}

	public Symptomquestion removeSymptomquestion(Symptomquestion symptomquestion) {
		getSymptomquestions().remove(symptomquestion);
		symptomquestion.setSymptompoll(null);

		return symptomquestion;
	}

}