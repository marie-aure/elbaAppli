package fr.elba.dao;

import java.util.List;

import fr.elba.model.Famille;
import fr.elba.model.Terrain;

public interface ITerrainDao {

	public List<Terrain> getAll();
	
	public Terrain getById(int id);
	
	public List<Terrain> getByOwner(Famille famille);
	
	public void create(Terrain terrain);
	
	public void update(Terrain terrain);
	
	public void delete(int id);
	
}
