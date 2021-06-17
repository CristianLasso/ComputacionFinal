package com.taller1.CristianLasso.front.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.taller1.CristianLasso.back.validation.LocalconditionValidation;


/**
 * The persistent class for the LOCALCONDITION database table.
 * 
 */
public class Localcondition implements Serializable {
	private static final long serialVersionUID = 1L;

	private long loconId;

	private String loconColumnname;

	private String loconKeycolumn;

	private String loconOperator;

	private String loconQuerystring;

	private String loconTablename;

	private String loconValuetype;

	private Precondition precondition;

	private Threshold threshold;

	public Localcondition() {
	}

	public long getLoconId() {
		return this.loconId;
	}

	public void setLoconId(long loconId) {
		this.loconId = loconId;
	}

	public String getLoconColumnname() {
		return this.loconColumnname;
	}

	public void setLoconColumnname(String loconColumnname) {
		this.loconColumnname = loconColumnname;
	}

	public String getLoconKeycolumn() {
		return this.loconKeycolumn;
	}

	public void setLoconKeycolumn(String loconKeycolumn) {
		this.loconKeycolumn = loconKeycolumn;
	}

	public String getLoconOperator() {
		return this.loconOperator;
	}

	public void setLoconOperator(String loconOperator) {
		this.loconOperator = loconOperator;
	}

	public String getLoconQuerystring() {
		return this.loconQuerystring;
	}

	public void setLoconQuerystring(String loconQuerystring) {
		this.loconQuerystring = loconQuerystring;
	}

	public String getLoconTablename() {
		return this.loconTablename;
	}

	public void setLoconTablename(String loconTablename) {
		this.loconTablename = loconTablename;
	}

	public String getLoconValuetype() {
		return this.loconValuetype;
	}

	public void setLoconValuetype(String loconValuetype) {
		this.loconValuetype = loconValuetype;
	}

	public Precondition getPrecondition() {
		return this.precondition;
	}

	public void setPrecondition(Precondition precondition) {
		this.precondition = precondition;
	}

	public Threshold getThreshold() {
		return this.threshold;
	}

	public void setThreshold(Threshold threshold) {
		this.threshold = threshold;
	}

	public Localcondition get() {
		return this;
	}

}