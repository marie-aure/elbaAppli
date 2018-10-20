package fr.elba.dao;

import java.util.List;

import fr.elba.model.Droit;
import fr.elba.model.LiaisonDRCL;

public interface ILiaisonDRCLDao {

	public List<LiaisonDRCL> getAll();
	
	public List<LiaisonDRCL> getByDroit(Droit droit);
	
	public LiaisonDRCL getById(int id);
	
	public void create(LiaisonDRCL liaisonDRCL);
	
	public void update(LiaisonDRCL liaisonDRCL);
	
	public void delete(int id);
	
}
