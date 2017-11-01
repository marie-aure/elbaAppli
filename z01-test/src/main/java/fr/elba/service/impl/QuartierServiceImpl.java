package fr.elba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.elba.dao.IQuartierDao;
import fr.elba.model.Quartier;
import fr.elba.service.IQuartierService;

@Service("QuartierService")
public class QuartierServiceImpl implements IQuartierService {

	@Autowired
	private IQuartierDao quDao;

	public void setQuDao(IQuartierDao quDao) {
		this.quDao = quDao;
	}

	@Override
	public List<Quartier> getAll() {
		return quDao.getAll();
	}

	@Override
	public Quartier getById(int id) {
		return quDao.getById(id);
	}

	@Override
	public Quartier getByName(String name) {
		return quDao.getByName(name);
	}

	@Override
	public void create(Quartier quartier) {
		quDao.create(quartier);
	}

	@Override
	public void update(Quartier quartier) {
		quDao.update(quartier);
	}

	@Override
	public void delete(int id) {
		quDao.delete(id);
	}

}
