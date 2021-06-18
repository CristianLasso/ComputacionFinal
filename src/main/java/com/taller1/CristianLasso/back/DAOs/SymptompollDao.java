package com.taller1.CristianLasso.back.DAOs;

import java.util.List;

import com.taller1.CristianLasso.back.model.Symptompoll;



public interface SymptompollDao {
	
	public Symptompoll save(Symptompoll Symptompoll);
	public Symptompoll update(Symptompoll Symptompoll);
	public void delete(Symptompoll Symptompoll);
	public List<Symptompoll> findAll();
	public Symptompoll findById(long sympollId);
}
