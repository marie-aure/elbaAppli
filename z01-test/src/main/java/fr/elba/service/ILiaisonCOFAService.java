package fr.elba.service;

import java.util.List;

import fr.elba.model.Famille;
import fr.elba.model.LiaisonCOFA;

public interface ILiaisonCOFAService {

	public List<LiaisonCOFA> getAll();
	
	public LiaisonCOFA getById(int id);
	
	public List<LiaisonCOFA> getByFamille(Famille famille);
		
	public void create(LiaisonCOFA liaisonCOFA);
	
	public void update(LiaisonCOFA liaisonCOFA);
	
	public void delete(int id);
	
}
