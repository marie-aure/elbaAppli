package fr.elba.dao;

import java.util.List;

import fr.elba.model.Tour;

public interface ITourDao {

	public List<Tour> getAll();
	
	public Tour getById(int id);
	
	public Tour getEnCours();
	
	public void create(Tour tour);
	
	public void update(Tour tour);
	
	public void delete(int id);
	
}