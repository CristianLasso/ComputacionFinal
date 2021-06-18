package com.taller1.CristianLasso.front.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.taller1.CristianLasso.back.validation.PreconditionValidation;

import java.util.List;


/**
 * The persistent class for the PRECONDITION database table.
 * 
 */
public class Precondition implements Serializable {
	private static final long serialVersionUID = 1L;

	private long preconId;

	private String preconLogicaloperand;

	@JsonIgnore
	private List<Localcondition> localconditions;

	private Autotransition autotransition;
	
	private long autotranId;

	public long getAutotranId() {
		return autotranId;
	}

	public void setAutotranId(long autotranId) {
		this.autotranId = autotranId;
	}

	public Precondition() {
	}

	public long getPreconId() {
		return this.preconId;
	}

	public void setPreconId(long preconId) {
		this.preconId = preconId;
	}

	public String getPreconLogicaloperand() {
		return this.preconLogicaloperand;
	}

	public void setPreconLogicaloperand(String preconLogicaloperand) {
		this.preconLogicaloperand = preconLogicaloperand;
	}

	public List<Localcondition> getLocalconditions() {
		return this.localconditions;
	}

	public void setLocalconditions(List<Localcondition> localconditions) {
		this.localconditions = localconditions;
	}

	public Localcondition addLocalcondition(Localcondition localcondition) {
		getLocalconditions().add(localcondition);
		localcondition.setPrecondition(this);

		return localcondition;
	}

	public Localcondition removeLocalcondition(Localcondition localcondition) {
		getLocalconditions().remove(localcondition);
		localcondition.setPrecondition(null);

		return localcondition;
	}

	public Autotransition getAutotransition() {
		return this.autotransition;
	}

	public void setAutotransition(Autotransition autotransition) {
		this.autotransition = autotransition;
	}

	public Precondition get() {
		return this;
	}

}