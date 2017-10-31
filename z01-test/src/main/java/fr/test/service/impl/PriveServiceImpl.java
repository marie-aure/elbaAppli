package fr.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.test.dao.IPriveDao;
import fr.test.model.Prive;
import fr.test.service.IPriveService;

@Service("PriveService")
public class PriveServiceImpl implements IPriveService {

	@Autowired
	private IPriveDao prDao;
	
	
	public void setPrDao(IPriveDao prDao) {
		this.prDao = prDao;
	}

	@Override
	public List<Prive> getAll() {
		return prDao.getAll();
	}

	@Override
	public Prive getById(int id) {
		return prDao.getById(id);
	}

	@Override
	public void create(Prive prive) {
		prDao.create(prive);
	}

	@Override
	public void update(Prive prive) {
		prDao.update(prive);
	}

	@Override
	public void delete(int id) {
		prDao.delete(id);
	}

}
