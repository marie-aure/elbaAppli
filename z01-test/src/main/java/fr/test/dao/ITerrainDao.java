package fr.test.dao;

import java.util.List;

import fr.test.model.Terrain;

public interface ITerrainDao {

	public List<Terrain> getAll();
	
	public Terrain getById(int id);
	
	public void create(Terrain terrain);
	
	public void update(Terrain terrain);
	
	public void delete(int id);	
	
}
