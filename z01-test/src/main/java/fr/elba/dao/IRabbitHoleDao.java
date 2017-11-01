package fr.elba.dao;

import java.util.List;

import fr.elba.model.RabbitHole;

public interface IRabbitHoleDao {

	public List<RabbitHole> getAll();
	
	public RabbitHole getById(int id);
	
	public RabbitHole getByName(String name);
	
	public void create(RabbitHole rabbitHole);
	
	public void update(RabbitHole rabbitHole);
	
	public void delete(int id);
	
}
