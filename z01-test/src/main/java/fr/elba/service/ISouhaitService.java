package fr.elba.service;

import java.util.List;

import fr.elba.model.Souhait;

public interface ISouhaitService {

	public List<Souhait> getAll();

	public Souhait getById(int id);

	public Souhait getByName(String name);
	
	public Souhait getRandom();
	
	public void create(Souhait souhait);

	public void update(Souhait souhait);

	public void delete(int id);

}
