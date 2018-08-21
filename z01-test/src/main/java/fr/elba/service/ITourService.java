package fr.elba.service;

import java.util.List;

import fr.elba.model.Tour;

public interface ITourService {

	public List<Tour> getAll();
	
	public Tour getById(int id);
	
	public Tour getEnCours();
	
	public void create(Tour tour);
	
	public void update(Tour tour);
	
	public void delete(int id);
	
<<<<<<< HEAD
=======
	public void selectionSuivant(Tour tour);
	
>>>>>>> branch 'master' of https://github.com/marie-aure/elbaAppli.git
}
