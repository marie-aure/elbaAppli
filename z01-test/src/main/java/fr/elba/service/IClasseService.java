package fr.elba.service;

import java.util.List;

import fr.elba.model.Classe;

public interface IClasseService {

	public List<Classe> getAll();
	
	public Classe getById(int id);
	
	public Classe getByName(String name);
	
	public void create(Classe classe);
	
	public void update(Classe classe);
	
	public void delete(int id);
	
}
