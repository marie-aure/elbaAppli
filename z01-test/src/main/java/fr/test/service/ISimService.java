package fr.test.service;

import java.util.List;

import fr.test.model.Sim;

public interface ISimService {
	
	public List<Sim> getAll();
	
	public Sim getById(int id);
	
	public Sim getByName(String prenom, String nom);
	
	public void create(Sim sim);
	
	public void update(Sim sim);
	
	public void delete(int id);	

}
