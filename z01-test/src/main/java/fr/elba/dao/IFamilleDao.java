package fr.elba.dao;

import java.util.List;

import fr.elba.model.Classe;
import fr.elba.model.Famille;

public interface IFamilleDao {

	public List<Famille> getAll();
	
	public List<Famille> getByClasse(Classe classe);
	
	public Famille getById(int id);
	
	public Famille getByName(String name);
	
	public void create(Famille famille);
	
	public void update(Famille famille);
	
	public void delete(int id);
	
	
}
