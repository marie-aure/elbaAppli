package fr.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.test.dao.ICommunautaireDao;
import fr.test.model.Communautaire;
import fr.test.service.ICommunautaireService;

@Service("CommunautaireService")
public class CommunautaireServiceImpl implements ICommunautaireService {

	@Autowired
	private ICommunautaireDao coDao;

	public void setCoDao(ICommunautaireDao coDao) {
		this.coDao = coDao;
	}

	@Override
	public List<Communautaire> getAll() {
		return coDao.getAll();
	}

	@Override
	public Communautaire getById(int id) {
		return coDao.getById(id);
	}

	@Override
	public void create(Communautaire communautaire) {
		coDao.create(communautaire);
	}

	@Override
	public void update(Communautaire communautaire) {
		coDao.update(communautaire);
	}

	@Override
	public void delete(int id) {
		coDao.delete(id);
	}

}
