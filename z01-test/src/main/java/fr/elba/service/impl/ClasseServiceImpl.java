package fr.elba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.elba.dao.IClasseDao;
import fr.elba.model.Classe;
import fr.elba.service.IClasseService;

@Service("ClasseService")
public class ClasseServiceImpl implements IClasseService {

	@Autowired
	private IClasseDao clDao;

	public void setClDao(IClasseDao clDao) {
		this.clDao = clDao;
	}

	@Override
	public List<Classe> getAll() {
		return clDao.getAll();
	}

	@Override
	public Classe getById(int id) {
		return clDao.getById(id);
	}

	@Override
	public Classe getByName(String name) {
		return clDao.getByName(name);
	}

	@Override
	public void create(Classe classe) {
		clDao.create(classe);
	}

	@Override
	public void update(Classe classe) {
		clDao.update(classe);
	}

	@Override
	public void delete(int id) {
		clDao.delete(id);
	}

}
