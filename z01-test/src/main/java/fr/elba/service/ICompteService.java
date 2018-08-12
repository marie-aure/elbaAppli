package fr.elba.service;

import java.util.List;

import fr.elba.model.Famille;
import fr.elba.model.Compte;

public interface ICompteService {

	public List<Compte> getAll();

	public Compte getById(int id);
	
	public List<Compte> getByFamily(Famille famille);

	public void create(Compte compte);

	public void update(Compte compte);

	public void delete(int id);

}
