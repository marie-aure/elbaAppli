package fr.elba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.elba.dao.ITraitDao;
import fr.elba.model.Trait;
import fr.elba.service.ITraitService;

@Service("TraitService")
public class TraitServiceImpl implements ITraitService {

	@Autowired
	private ITraitDao trDao;

	public void setTrDao(ITraitDao trDao) {
		this.trDao = trDao;
	}

	@Override
	public List<Trait> getAll() {
		return trDao.getAll();
	}

	@Override
	public Trait getById(int id) {
		return trDao.getById(id);
	}
	
	@Override
	public Trait getByName(String trait) {
		return trDao.getByName(trait);
	}
	
	@Override
	public Trait getRandom(String type){
		return trDao.getRandom(type);
	}

	@Override
	public Trait getRandom(){
		return trDao.getRandom();
	}
	
	@Override
	public void create(Trait trait) {
		trDao.create(trait);
	}

	@Override
	public void update(Trait trait) {
		trDao.update(trait);
	}

	@Override
	public void delete(int id) {
		trDao.delete(id);
	}

}
