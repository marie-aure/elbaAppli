package fr.elba.service;

import java.util.List;

import fr.elba.model.Communautaire;

public interface ICommunautaireService {

	public List<Communautaire> getAll();

	public Communautaire getById(int id);

	public void create(Communautaire communautaire);

	public void update(Communautaire communautaire);

	public void delete(int id);

}
