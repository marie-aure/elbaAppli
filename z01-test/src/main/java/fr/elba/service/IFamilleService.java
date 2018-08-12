package fr.elba.service;

import java.util.List;

import fr.elba.model.Famille;
import fr.elba.model.LiaisonSITR;

public interface IFamilleService {

	public List<Famille> getAll();

	public Famille getById(int id);

	public Famille getByName(String name);

	public void create(Famille famille);

	public void update(Famille famille);

	public void delete(int id);
	
	public void validerGroupe(List<LiaisonSITR> lStarters);

}
