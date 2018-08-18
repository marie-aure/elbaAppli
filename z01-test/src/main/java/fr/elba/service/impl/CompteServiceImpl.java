package fr.elba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.elba.dao.ICompteDao;
import fr.elba.model.Famille;
import fr.elba.model.Compte;
import fr.elba.service.ICompteService;

@Service("CompteService")
public class CompteServiceImpl implements ICompteService {

	@Autowired
	private ICompteDao coDao;

	public void setCoDao(ICompteDao coDao) {
		this.coDao = coDao;
	}

	@Override
	public List<Compte> getAll() {
		return coDao.getAll();
	}

	@Override
	public Compte getById(int id) {
		return coDao.getById(id);
	}

	@Override
	public List<Compte> getByFamily(Famille famille) {
		return coDao.getByFamily(famille);
	}
	
	@Override
	public void create(Compte compte) {
		coDao.create(compte);
	}

	@Override
	public void update(Compte compte) {
		coDao.update(compte);
	}

	@Override
	public void delete(int id) {
		coDao.delete(id);
	}

}
