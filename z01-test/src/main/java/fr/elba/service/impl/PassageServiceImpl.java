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
	private IPassageDao paDao;

	public void setPaDao(IPassageDao paDao) {
		this.paDao = paDao;
	}

	@Override
	public List<Passage> getAll() {
		return paDao.getAll();
	}
	
	@Override
	public List<String> getAllCategorie(){
		return paDao.getAllCategorie();
	}

	@Override
	public Passage getById(int id) {
		return paDao.getById(id);
	}
	
	@Override
	public Passage getByLibelle(String libelle) {
		return paDao.getByLibelle(libelle);
	}

	@Override
	public void create(Passage passage) {
		paDao.create(passage);
	}

	@Override
	public void update(Passage passage) {
		paDao.update(passage);
	}

	@Override
	public void delete(int id) {
		paDao.delete(id);
	}

}
