package fr.elba.service;

import java.util.List;

import fr.elba.model.Starter;

public interface IStarterService {

	public List<Starter> getAll();
	
	public Starter getById(int id);

	public void create(Starter starter);

	public void update(Starter starter);

	public void delete(int id);
	
	public void generate(int taille);
	
	public List<Integer> getGroupes();

}
