package fr.elba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.elba.dao.IPretDao;
import fr.elba.model.Famille;
import fr.elba.model.Pret;
import fr.elba.service.IPretService;

@Service("PretService")
public class PretServiceImpl implements IPretService {

	@Autowired
	private IPretDao prDao;

	public void setPrDao(IPretDao prDao) {
		this.prDao = prDao;
	}

	@Override
	public List<Pret> getAll() {
		return prDao.getAll();
	}

	@Override
	public Pret getById(int id) {
		return prDao.getById(id);
	}

	@Override
	public List<Pret> getByFamily(Famille famille) {
		return prDao.getByFamily(famille);
	}
	
	@Override
	public void create(Pret pret) {
		prDao.create(pret);
	}

	@Override
	public void update(Pret pret) {
		prDao.update(pret);
	}

	@Override
	public void delete(int id) {
		prDao.delete(id);
	}

}
