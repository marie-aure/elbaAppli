package fr.elba.service;

import java.util.List;

import fr.elba.model.Passage;
import fr.elba.model.Classe;
import fr.elba.model.Condition;

public interface IConditionService {

	public List<Condition> getAll();
	
	public List<Condition> getByPassage(Passage passage);
	
	public List<Condition> getByClasse(Classe classe);
	
	public Condition getById(int id);

	public void create(Condition condition);

	public void update(Condition condition);

	public void delete(int id);

}
