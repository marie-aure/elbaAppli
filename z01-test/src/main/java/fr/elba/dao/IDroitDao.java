package fr.elba.dao;

import java.util.List;

import fr.elba.model.Droit;

public interface IDroitDao {

	public List<Droit> getAll();
	
	public Droit getById(int id);
	
	public void create(Droit droit);
	
	public void update(Droit droit);
	
	public void delete(int id);
	
}
