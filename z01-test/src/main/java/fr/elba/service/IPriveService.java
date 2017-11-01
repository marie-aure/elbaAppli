package fr.elba.service;

import java.util.List;

import fr.elba.model.Prive;

public interface IPriveService {

	public List<Prive> getAll();

	public Prive getById(int id);

	public void create(Prive prive);

	public void update(Prive prive);

	public void delete(int id);

}
