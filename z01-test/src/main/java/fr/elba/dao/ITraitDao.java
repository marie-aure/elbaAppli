package fr.elba.dao;

import java.util.List;

import fr.elba.model.Trait;

public interface ITraitDao {

	public List<Trait> getAll();
	
	public Trait getById(int id);
	
	public Trait getRandom(String type);
	
	public Trait getRandom();
	
	public void create(Trait trait);
	
	public void update(Trait trait);
	
	public void delete(int id);
	
}
