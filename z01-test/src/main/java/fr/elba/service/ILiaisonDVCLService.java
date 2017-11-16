package fr.elba.service;

import java.util.List;

import fr.elba.model.LiaisonDVCL;

public interface ILiaisonDVCLService {

	public List<LiaisonDVCL> getAll();
	
	public LiaisonDVCL getById(int id);
		
	public void create(LiaisonDVCL liaisonDVCL);
	
	public void update(LiaisonDVCL liaisonDVCL);
	
	public void delete(int id);
	
}
