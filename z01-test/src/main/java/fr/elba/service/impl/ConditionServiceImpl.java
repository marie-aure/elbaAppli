package fr.elba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.elba.dao.IConditionDao;
import fr.elba.model.Famille;
import fr.elba.model.Passage;
import fr.elba.model.Classe;
import fr.elba.model.Condition;
import fr.elba.service.IConditionService;

@Service("ConditionService")
public class ConditionServiceImpl implements IConditionService {

	@Autowired
	private IConditionDao coDao;

	public void setCoDao(IConditionDao coDao) {
		this.coDao = coDao;
	}

	@Override
	public List<Condition> getAll() {
		return coDao.getAll();
	}

	@Override
	public List<Condition> getByPassage(Passage passage) {
		return coDao.getByPassage(passage);
	}

	@Override
	public List<Condition> getByClasse(Classe classe) {
		return coDao.getByClasse(classe);
	}

	@Override
	public Condition getById(int id) {
		return coDao.getById(id);
	}

	@Override
	public void create(Condition condition) {
		coDao.create(condition);
	}

	@Override
	public void update(Condition condition) {
		coDao.update(condition);
	}

	@Override
	public void delete(int id) {
		coDao.delete(id);
	}

}
