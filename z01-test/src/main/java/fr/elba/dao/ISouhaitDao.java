package fr.elba.dao;

import java.util.List;

import fr.elba.model.Souhait;

public interface ISouhaitDao {

	public List<Souhait> getAll();
	
	public Souhait getById(int id);
	
	public Souhait getRandom();
	
	public void create(Souhait souhait);
	
	public void update(Souhait souhait);
	
	public void delete(int id);
	
}
