package com.taller1.CristianLasso.front.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.taller1.CristianLasso.back.validation.AutotransitionValidation;

import java.util.List;

/**
 * The persistent class for the AUTOTRANSITION database table.
 * 
 */
public class Autotransition implements Serializable {
	private static final long serialVersionUID = 1L;

	private long autotranId;

	private String autotranIsactive;
	
	private String autotranLogicaloperand;

	private String autotranName;

	private long instInstId;

	
	private List<Precondition> preconditions;

	public Autotransition() {
	}

	public long getAutotranId() {
		return this.autotranId;
	}

	public void setAutotranId(long autotranId) {
		this.autotranId = autotranId;
	}

	public String getAutotranIsactive() {
		return this.autotranIsactive;
	}

	public void setAutotranIsactive(String autotranIsactive) {
		this.autotranIsactive = autotranIsactive;
	}

	public String getAutotranLogicaloperand() {
		return this.autotranLogicaloperand;
	}

	public void setAutotranLogicaloperand(String autotranLogicaloperand) {
		this.autotranLogicaloperand = autotranLogicaloperand;
	}

	public String getAutotranName() {
		return this.autotranName;
	}

	public void setAutotranName(String autotranName) {
		this.autotranName = autotranName;
	}

	public long getInstInstId() {
		return this.instInstId;
	}

	public void setInstInstId(long instInstId) {
		this.instInstId = instInstId;
	}

	public List<Precondition> getPreconditions() {
		return this.preconditions;
	}

	public void setPreconditions(List<Precondition> preconditions) {
		this.preconditions = preconditions;
	}

	public Precondition addPrecondition(Precondition precondition) {
		getPreconditions().add(precondition);
		precondition.setAutotransition(this);

		return precondition;
	}

	public Precondition removePrecondition(Precondition precondition) {
		getPreconditions().remove(precondition);
		precondition.setAutotransition(null);

		return precondition;
	}

	public Autotransition get() {
		return this;
	}

}