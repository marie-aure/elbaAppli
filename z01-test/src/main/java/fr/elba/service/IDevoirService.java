package fr.elba.service;

import java.util.List;

import fr.elba.model.Devoir;

public interface IDevoirService {

	public List<Devoir> getAll();
	
	public Devoir getById(int id);
	
	public void create(Devoir devoir);
	
	public void update(Devoir devoir);
	
	public void delete(int id);
	
}
