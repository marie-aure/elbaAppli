package fr.elba.service;

import java.util.List;

import fr.elba.model.Passage;

public interface IPassageService {

	public List<Passage> getAll();
	
	public List<String> getAllCategorie();
	
	public Passage getById(int id);

	public Passage getByLibelle(String libelle);
		
	public void create(Passage passage);

	public void update(Passage passage);

	public void delete(int id);

}
