package fr.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.test.dao.ISimDao;
import fr.test.model.Sim;
import fr.test.service.ISimService;

@Service("SimService")
public class SimServiceImpl implements ISimService {

	@Autowired
	private ISimDao siDao;

	public void setSiDao(ISimDao siDao) {
		this.siDao = siDao;
	}

	@Override
	public List<Sim> getAll() {
		return siDao.getAll();
	}

	@Override
	public Sim getById(int id) {
		return siDao.getById(id);
	}

	@Override
	public Sim getByName(String prenom, String nom) {
		return siDao.getByName(prenom, nom);
	}

	@Override
	public void create(Sim sim) {
		siDao.create(sim);
	}

	@Override
	public void update(Sim sim) {
		siDao.update(sim);
	}

	@Override
	public void delete(int id) {
		siDao.delete(id);
	}

}
