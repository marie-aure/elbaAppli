package fr.elba.dao;

import java.util.List;

import fr.elba.model.Famille;
import fr.elba.model.Genre;
import fr.elba.model.Sim;

public interface ISimDao {

	public List<Sim> getAll();
	
	public List<Sim> getByFamille(Famille famille);
	
	public List<Sim> getHeritierPossibleByFamille(Famille famille);
	
	public List<Sim> getHeritierByFamille(Famille famille);
	
	public List<Sim> getListEnfants(Sim sim);
	
	public List<Sim> getListParents(Genre genre);
	
	public Sim getById(int id);
	
	public void create(Sim sim);
	
	public void update(Sim sim);
	
	public void delete(int id);
	
}
