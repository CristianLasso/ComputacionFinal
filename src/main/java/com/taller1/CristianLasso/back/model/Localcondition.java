package com.taller1.CristianLasso.back.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.taller1.CristianLasso.back.validation.LocalconditionValidation;


/**
 * The persistent class for the LOCALCONDITION database table.
 * 
 */
@Entity
@NamedQuery(name="Localcondition.findAll", query="SELECT l FROM Localcondition l")
public class Localcondition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="LOCALCONDITION_LOCONID_GENERATOR", sequenceName="LOCALCONDITION_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LOCALCONDITION_LOCONID_GENERATOR")
	@Column(name="LOCON_ID")
	private long loconId;

	@Column(name="LOCON_COLUMNNAME")
	private String loconColumnname;

	@Column(name="LOCON_KEYCOLUMN")
	private String loconKeycolumn;

	@Column(name="LOCON_OPERATOR")
	@NotNull(groups = {LocalconditionValidation.class})
	@Size(min = 2, max = 3, groups = {LocalconditionValidation.class})
	private String loconOperator;

	@Column(name="LOCON_QUERYSTRING")
	private String loconQuerystring;

	@Column(name="LOCON_TABLENAME")
	@NotNull(groups = {LocalconditionValidation.class})
	@Size(min = 4, max = 30, groups = { LocalconditionValidation.class})
	private String loconTablename;

	@Column(name="LOCON_VALUETYPE")
	private String loconValuetype;

	//bi-directional many-to-one association to Precondition
	@ManyToOne
	@JoinColumn(name="PRECON_PRECON_ID")
	private Precondition precondition;

	//bi-directional many-to-one association to Threshold
	@ManyToOne
	@JoinColumn(name="THRES_THRES_ID")
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