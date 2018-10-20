package fr.elba.service;

import java.util.List;

import fr.elba.model.Droit;

public interface IDroitService {

	public List<Droit> getAll();
	
	public Droit getById(int id);
	
	public void create(Droit droit);
	
	public void update(Droit droit);
	
	public void delete(int id);
	
}
