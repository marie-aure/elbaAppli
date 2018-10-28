package fr.elba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.elba.dao.ISimDao;
import fr.elba.model.Famille;
import fr.elba.model.Sim;
import fr.elba.service.ISimService;

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
	public List<Sim> getByFamille(Famille famille) {
		return siDao.getByFamille(famille);
	}

	@Override
	public List<Sim> getListEnfants(Sim sim) {
		return siDao.getListEnfants(sim);
	}
	
	@Override
	public List<Sim> getListParents(String sx){
		return siDao.getListParents(sx);
	}
	
	@Override
	public Sim getById(int id) {
		return siDao.getById(id);
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
