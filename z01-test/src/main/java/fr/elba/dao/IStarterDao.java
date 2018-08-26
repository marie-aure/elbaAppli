package fr.elba.dao;

import java.util.List;

import fr.elba.model.Starter;

public interface IStarterDao {

	public List<Starter> getAll();
		
	public Starter getById(int id);
	
	public void create(Starter starter);
	
	public void update(Starter starter);
	
	public void delete(int id);
	
	public List<Integer> getDistinctGroups();

	public List<Integer> getDernierGroupe();
	
}
