package fr.elba.dao;

import java.util.List;

import fr.elba.model.Condition;
import fr.elba.model.Passage;

public interface IConditionDao {

	public List<Condition> getAll();
	
	public List<Condition> getByPassage(Passage passage);
	
	public Condition getById(int id);
	
	public void create(Condition condition);
	
	public void update(Condition condition);
	
	public void delete(int id);
	
}
