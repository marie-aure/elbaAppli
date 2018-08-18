package fr.elba.service;

import java.util.List;

import fr.elba.model.LiaisonSITR;

public interface ILiaisonSITRService {

	public List<LiaisonSITR> getAll();
	
	public LiaisonSITR getById(int id);
		
	public void create(LiaisonSITR liaisonSITR);
	
	public void update(LiaisonSITR liaisonSITR);
	
	public void delete(int id);
	
	public List<LiaisonSITR> chargerGroupe(int groupe);
	
}