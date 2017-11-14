package fr.elba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.elba.dao.IDevoirDao;
import fr.elba.model.Devoir;
import fr.elba.service.IDevoirService;

@Service("DevoirService")
public class DevoirServiceImpl implements IDevoirService {

	@Autowired
	private IDevoirDao deDao;

	public void setDeDao(IDevoirDao deDao) {
		this.deDao = deDao;
	}

	@Override
	public List<Devoir> getAll() {
		return deDao.getAll();
	}

	@Override
	public Devoir getById(int id) {
		return deDao.getById(id);
	}

	@Override
	public void create(Devoir devoir) {
		deDao.create(devoir);
	}

	@Override
	public void update(Devoir devoir) {
		deDao.update(devoir);
	}

	@Override
	public void delete(int id) {
		deDao.delete(id);
	}

}
