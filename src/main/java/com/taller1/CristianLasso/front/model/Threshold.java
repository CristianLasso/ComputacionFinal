package com.taller1.CristianLasso.front.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.taller1.CristianLasso.back.validation.ThresholdValidation;

import java.util.List;


/**
 * The persistent class for the THRESHOLD database table.
 * 
 */
public class Threshold implements Serializable {
	private static final long serialVersionUID = 1L;

	private long thresId;

	private long instInstId;

	private String thresName;

	private String thresValue;

	private String thresValuetype;

	@JsonIgnore
	private List<Localcondition> localconditions;

	public Threshold() {
	}

	public long getThresId() {
		return this.thresId;
	}

	public void setThresId(long thresId) {
		this.thresId = thresId;
	}

	public long getInstInstId() {
		return this.instInstId;
	}

	public void setInstInstId(long instInstId) {
		this.instInstId = instInstId;
	}

	public String getThresName() {
		return this.thresName;
	}

	public void setThresName(String thresName) {
		this.thresName = thresName;
	}

	public String getThresValue() {
		return this.thresValue;
	}

	public void setThresValue(String thresValue) {
		this.thresValue = thresValue;
	}

	public String getThresValuetype() {
		return this.thresValuetype;
	}

	public void setThresValuetype(String thresValuetype) {
		this.thresValuetype = thresValuetype;
	}

	public List<Localcondition> getLocalconditions() {
		return this.localconditions;
	}

	public void setLocalconditions(List<Localcondition> localconditions) {
		this.localconditions = localconditions;
	}

	public Localcondition addLocalcondition(Localcondition localcondition) {
		getLocalconditions().add(localcondition);
		localcondition.setThreshold(this);

		return localcondition;
	}

	public Localcondition removeLocalcondition(Localcondition localcondition) {
		getLocalconditions().remove(localcondition);
		localcondition.setThreshold(null);

		return localcondition;
	}

	public Threshold get() {
		return this;
	}

}