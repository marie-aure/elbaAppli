package fr.elba.service;

import java.util.List;

import fr.elba.model.Trait;

public interface ITraitService {

	public List<Trait> getAll();

	public Trait getById(int id);
	
	public Trait getByName(String trait);

	public Trait getRandom(String type);
	
	public Trait getRandom();
	
	public void create(Trait trait);

	public void update(Trait trait);

	public void delete(int id);

}
