package fr.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.test.dao.IFamilleDao;
import fr.test.model.Famille;
import fr.test.service.IFamilleService;

@Service("FamilleService")
public class FamilleServiceImpl implements IFamilleService {

	@Autowired
	private IFamilleDao faDao;

	public void setFaDao(IFamilleDao faDao) {
		this.faDao = faDao;
	}

	@Override
	public List<Famille> getAll() {
		return faDao.getAll();
	}

	@Override
	public Famille getById(int id) {
		return faDao.getById(id);
	}

	@Override
	public Famille getByName(String name) {
		return faDao.getByName(name);
	}

	@Override
	public void create(Famille famille) {
		faDao.create(famille);
	}

	@Override
	public void update(Famille famille) {
		faDao.update(famille);
	}

	@Override
	public void delete(int id) {
		faDao.delete(id);
	}

}
