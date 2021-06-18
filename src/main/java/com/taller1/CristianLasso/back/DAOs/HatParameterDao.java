package com.taller1.CristianLasso.back.DAOs;

import java.util.List;

import com.taller1.CristianLasso.back.model.HatParameter;

public interface HatParameterDao {

	public HatParameter save(HatParameter HatParameter);
	public HatParameter update(HatParameter HatParameter);
	public void delete(HatParameter HatParameter);
	public List<HatParameter> findAll();
	public HatParameter findById(HatParameter id);
}