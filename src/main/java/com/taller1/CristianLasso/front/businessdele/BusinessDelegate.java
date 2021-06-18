package com.taller1.CristianLasso.front.businessdele;

import java.util.List;

import com.taller1.CristianLasso.front.model.Autotransition;
import com.taller1.CristianLasso.front.model.FevInstitution;
import com.taller1.CristianLasso.front.model.Localcondition;
import com.taller1.CristianLasso.front.model.Precondition;
import com.taller1.CristianLasso.front.model.Symptom;
import com.taller1.CristianLasso.front.model.Symptompoll;
import com.taller1.CristianLasso.front.model.Symptomquestion;
import com.taller1.CristianLasso.front.model.Threshold;

public interface BusinessDelegate {
	
	public List<Autotransition> autotranFindAll();
	public void autotranSave(Autotransition autotran);
	public void autotranEdit(Autotransition autotran);
	public Autotransition autotranFinById(long id);
	public void autotranDelete(long id);
	
	public List<FevInstitution> instiFindAll();
	public void instiSave(FevInstitution autotran);
	public void instiEdit(FevInstitution autotran);
	public FevInstitution instiFinById(long id);
	public void instiDelete(long id);
	
	public List<Localcondition> localFindAll();
	public void localSave(Localcondition autotran);
	public void localEdit(Localcondition autotran);
	public Localcondition localFinById(long id);
	public void localDelete(long id);
	
	public List<Precondition> preconFindAll();
	public void preconSave(Precondition autotran);
	public void preconEdit(Precondition autotran);
	public Precondition preconFinById(long id);
	public void preconDelete(long id);
	
	public List<Threshold> thresFindAll();
	public void thresSave(Threshold autotran);
	public void thresEdit(Threshold autotran);
	public Threshold thresFinById(long id);
	public void thresDelete(long id);
	
	public List<Symptom> symptomFindAll();
	public void symptomSave(Symptom autotran);
	public void symptomEdit(Symptom autotran);
	public Symptom symptomFinById(long id);
	public void symptomDelete(long id);
	
	public List<Symptompoll> symptompollFindAll();
	public void symptompollSave(Symptompoll autotran);
	public void symptompollEdit(Symptompoll autotran);
	public Symptompoll symptompollFinById(long id);
	public void symptompollDelete(long id);
	
	public List<Symptomquestion> symptomquestionFindAll();
	public void symptomquestionSave(Symptomquestion autotran);
	public void symptomquestionEdit(Symptomquestion autotran);
	public Symptomquestion symptomquestionFinById(long id);
	public void symptomquestionDelete(long id);

}
