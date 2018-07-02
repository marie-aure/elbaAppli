package fr.elba.dao;

import java.util.List;

import fr.elba.model.Sim;

public interface ISimDao {

	public List<Sim> getAll();
	
	public Sim getById(int id);
	
	public void create(Sim sim);
	
	public void update(Sim sim);
	
	public void delete(int id);
	
}
