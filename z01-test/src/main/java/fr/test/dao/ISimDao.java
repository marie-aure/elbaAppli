package fr.test.dao;

import java.util.List;

import fr.test.model.Sim;

public interface ISimDao {

	public List<Sim> getAll();
	
	public Sim getById(int id);
	
	public Sim getByName(String prenom, String nom);
	
	public void create(Sim sim);
	
	public void update(Sim sim);
	
	public void delete(int id);	
	
}
