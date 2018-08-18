package fr.elba.dao;

import java.util.List;

import fr.elba.model.Famille;
import fr.elba.model.Pret;

public interface IPretDao {

	public List<Pret> getAll();
	
	public Pret getById(int id);

	public List<Pret> getByFamily(Famille famille);
	
	public void create(Pret pret);
	
	public void update(Pret pret);
	
	public void delete(int id);
	
}
