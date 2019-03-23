package fr.elba.dao;

import java.util.List;

import fr.elba.model.Famille;
import fr.elba.model.LiaisonCOFA;

public interface ILiaisonCOFADao {

	public List<LiaisonCOFA> getAll();
	
	public List<LiaisonCOFA> getByFamille(Famille famille);
	
	public LiaisonCOFA getById(int id);
	
	public void create(LiaisonCOFA liaisonCOFA);
	
	public void update(LiaisonCOFA liaisonCOFA);
	
	public void delete(int id);
	
}
