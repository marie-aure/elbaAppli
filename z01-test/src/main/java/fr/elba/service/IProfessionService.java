package fr.elba.service;

import java.util.List;
import java.util.Map;

import fr.elba.model.Classe;
import fr.elba.model.Profession;

public interface IProfessionService {

	public List<Profession> getAll();
	
	public Profession getById(int id);
	
	public void create(Profession profession);
	
	public void update(Profession profession);
	
	public void delete(int id);
	
	public Map<String,Integer> getListProfession(Classe classe);
	
}
