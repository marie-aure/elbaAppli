package fr.elba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.elba.dao.IPassageDao;
import fr.elba.model.Passage;
import fr.elba.service.IPassageService;

@Service("PassageService")
public class PassageServiceImpl implements IPassageService {

	@Autowired
	private IPassageDao soDao;

	public void setSoDao(IPassageDao soDao) {
		this.soDao = soDao;
	}

	@Override
	public List<Passage> getAll() {
		return soDao.getAll();
	}

	@Override
	public Passage getById(int id) {
		return soDao.getById(id);
	}
	
	@Override
	public Passage getByLibelle(String libelle) {
		return soDao.getByLibelle(libelle);
	}

	@Override
	public void create(Passage passage) {
		soDao.create(passage);
	}

	@Override
	public void update(Passage passage) {
		soDao.update(passage);
	}

	@Override
	public void delete(int id) {
		soDao.delete(id);
	}

}
