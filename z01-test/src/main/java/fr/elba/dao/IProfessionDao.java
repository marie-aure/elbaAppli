package fr.elba.dao;

import java.util.List;

import fr.elba.model.Profession;

public interface IProfessionDao {

	public List<Profession> getAll();
	
	public Profession getById(int id);
	
	public void create(Profession profession);
	
	public void update(Profession profession);
	
	public void delete(int id);
	
}
