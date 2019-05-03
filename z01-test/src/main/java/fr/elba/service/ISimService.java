package fr.elba.service;

import java.util.List;
import java.util.Map;

import fr.elba.model.Famille;
import fr.elba.model.Genre;
import fr.elba.model.Sim;

public interface ISimService {

	public List<Sim> getAll();

	public List<Sim> getByFamille(Famille famille);
	
	public List<Sim> getListEnfants(Sim sim);
	
	public Map<String,Integer> getListParents(Genre genre);

	public Sim getById(int id);

	public void create(Sim sim);

	public void update(Sim sim);

	public void delete(int id);

}
