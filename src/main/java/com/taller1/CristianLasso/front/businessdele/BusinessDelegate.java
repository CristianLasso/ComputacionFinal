package com.taller1.CristianLasso.front.businessdele;

import java.util.List;

import com.taller1.CristianLasso.back.model.Autotransition;

public interface BusinessDelegate {
	
	public List<Autotransition> autotranFindAll();
	public void autotranSave(Autotransition autotran);
	public void autotranEdit(Autotransition autotran);
	public Autotransition autotranFinById(long id);
	public void autotranDelete(long id);

}
