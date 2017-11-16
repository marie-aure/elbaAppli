package fr.elba.dao;

import java.util.List;

import fr.elba.model.LiaisonDVCL;

public interface ILiaisonDVCLDao {

	public List<LiaisonDVCL> getAll();
	
	public LiaisonDVCL getById(int id);
	
	public void create(LiaisonDVCL liaisonDVCL);
	
	public void update(LiaisonDVCL liaisonDVCL);
	
	public void delete(int id);
	
}
