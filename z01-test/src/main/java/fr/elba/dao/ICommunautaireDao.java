package fr.elba.dao;

import java.util.List;

import fr.elba.model.Communautaire;
import fr.elba.model.Famille;

public interface ICommunautaireDao {

	public List<Communautaire> getAll();

	public Communautaire getById(int id);

	public List<Communautaire> getByOwner(Famille famille);

	public List<Communautaire> getAVendre();

	public void create(Communautaire communautaire);

	public void update(Communautaire communautaire);

	public void delete(int id);

}
