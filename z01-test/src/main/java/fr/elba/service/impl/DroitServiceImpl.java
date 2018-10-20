package fr.elba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.elba.dao.IDroitDao;
import fr.elba.model.Droit;
import fr.elba.service.IDroitService;

@Service("DroitService")
public class DroitServiceImpl implements IDroitService {

	@Autowired
	private IDroitDao deDao; 

	public void setDeDao(IDroitDao deDao) {
		this.deDao = deDao;
	}

	@Override
	public List<Droit> getAll() {
		return deDao.getAll();
	}

	@Override
	public Droit getById(int id) {
		return deDao.getById(id);
	}

	@Override
	public void create(Droit droit) {
		deDao.create(droit);
	}

	@Override
	public void update(Droit droit) {
		deDao.update(droit);
	}

	@Override
	public void delete(int id) {
		deDao.delete(id);
	}

}
