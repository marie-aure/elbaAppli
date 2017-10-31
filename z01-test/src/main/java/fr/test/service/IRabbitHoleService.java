package fr.test.service;

import java.util.List;

import fr.test.model.RabbitHole;

public interface IRabbitHoleService {

	public List<RabbitHole> getAll();
	
	public RabbitHole getById(int id);
	
	public RabbitHole getByName(String name);
	
	public void create(RabbitHole rabbitHole);
	
	public void update(RabbitHole rabbitHole);
	
	public void delete(int id);

	
}
