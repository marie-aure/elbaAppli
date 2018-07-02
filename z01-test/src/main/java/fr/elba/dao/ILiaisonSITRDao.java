package fr.elba.dao;

import java.util.List;

import fr.elba.model.LiaisonSITR;

public interface ILiaisonSITRDao {

	public List<LiaisonSITR> getAll();
	
	public LiaisonSITR getById(int id);
	
	public void create(LiaisonSITR liaisonSITR);
	
	public void update(LiaisonSITR liaisonSITR);
	
	public void delete(int id);
	
	public List<LiaisonSITR> getByGroup(int groupe);
	
}
