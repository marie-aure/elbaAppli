package fr.elba.dao;

import java.util.List;

import fr.elba.model.Quartier;

public interface IQuartierDao {

	public List<Quartier> getAll();
	
	public Quartier getById(int id);
	
	public Quartier getByName(String name);
	
	public void create(Quartier quartier);
	
	public void update(Quartier quartier);
	
	public void delete(int id);
	
	
}
