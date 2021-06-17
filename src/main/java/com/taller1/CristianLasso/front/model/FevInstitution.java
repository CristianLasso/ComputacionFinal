package com.taller1.CristianLasso.front.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the FEV_INSTITUTION database table.
 * 
 */
public class FevInstitution implements Serializable {
	private static final long serialVersionUID = 1L;

	private long instId;

	private String instAcademicserverurl;

	private String instAcadextradataurl;

	private String instAcadloginpassword;

	private String instAcadloginurl;

	private String instAcadloginusername;

	private String instAcadpersoninfodocurl;

	private String instAcadpersoninfoidurl;

	private String instAcadphysicalspacesurl;

	private String instAcadprogrammedcoursesurl;

	private String instLdapbasedn;

	private String instLdappassword;

	private String instLdapurl;

	private String instLdapusername;

	private String instLdapusersearchbase;

	private String instLdapusersearchfilter;

	private String instName;

	public FevInstitution() {
	}

	public long getInstId() {
		return this.instId;
	}

	public void setInstId(long instId) {
		this.instId = instId;
	}

	public String getInstAcademicserverurl() {
		return this.instAcademicserverurl;
	}

	public void setInstAcademicserverurl(String instAcademicserverurl) {
		this.instAcademicserverurl = instAcademicserverurl;
	}

	public String getInstAcadextradataurl() {
		return this.instAcadextradataurl;
	}

	public void setInstAcadextradataurl(String instAcadextradataurl) {
		this.instAcadextradataurl = instAcadextradataurl;
	}

	public String getInstAcadloginpassword() {
		return this.instAcadloginpassword;
	}

	public void setInstAcadloginpassword(String instAcadloginpassword) {
		this.instAcadloginpassword = instAcadloginpassword;
	}

	public String getInstAcadloginurl() {
		return this.instAcadloginurl;
	}

	public void setInstAcadloginurl(String instAcadloginurl) {
		this.instAcadloginurl = instAcadloginurl;
	}

	public String getInstAcadloginusername() {
		return this.instAcadloginusername;
	}

	public void setInstAcadloginusername(String instAcadloginusername) {
		this.instAcadloginusername = instAcadloginusername;
	}

	public String getInstAcadpersoninfodocurl() {
		return this.instAcadpersoninfodocurl;
	}

	public void setInstAcadpersoninfodocurl(String instAcadpersoninfodocurl) {
		this.instAcadpersoninfodocurl = instAcadpersoninfodocurl;
	}

	public String getInstAcadpersoninfoidurl() {
		return this.instAcadpersoninfoidurl;
	}

	public void setInstAcadpersoninfoidurl(String instAcadpersoninfoidurl) {
		this.instAcadpersoninfoidurl = instAcadpersoninfoidurl;
	}

	public String getInstAcadphysicalspacesurl() {
		return this.instAcadphysicalspacesurl;
	}

	public void setInstAcadphysicalspacesurl(String instAcadphysicalspacesurl) {
		this.instAcadphysicalspacesurl = instAcadphysicalspacesurl;
	}

	public String getInstAcadprogrammedcoursesurl() {
		return this.instAcadprogrammedcoursesurl;
	}

	public void setInstAcadprogrammedcoursesurl(String instAcadprogrammedcoursesurl) {
		this.instAcadprogrammedcoursesurl = instAcadprogrammedcoursesurl;
	}

	public String getInstLdapbasedn() {
		return this.instLdapbasedn;
	}

	public void setInstLdapbasedn(String instLdapbasedn) {
		this.instLdapbasedn = instLdapbasedn;
	}

	public String getInstLdappassword() {
		return this.instLdappassword;
	}

	public void setInstLdappassword(String instLdappassword) {
		this.instLdappassword = instLdappassword;
	}

	public String getInstLdapurl() {
		return this.instLdapurl;
	}

	public void setInstLdapurl(String instLdapurl) {
		this.instLdapurl = instLdapurl;
	}

	public String getInstLdapusername() {
		return this.instLdapusername;
	}

	public void setInstLdapusername(String instLdapusername) {
		this.instLdapusername = instLdapusername;
	}

	public String getInstLdapusersearchbase() {
		return this.instLdapusersearchbase;
	}

	public void setInstLdapusersearchbase(String instLdapusersearchbase) {
		this.instLdapusersearchbase = instLdapusersearchbase;
	}

	public String getInstLdapusersearchfilter() {
		return this.instLdapusersearchfilter;
	}

	public void setInstLdapusersearchfilter(String instLdapusersearchfilter) {
		this.instLdapusersearchfilter = instLdapusersearchfilter;
	}

	public String getInstName() {
		return this.instName;
	}

	public void setInstName(String instName) {
		this.instName = instName;
	}

}