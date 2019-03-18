package fr.elba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.elba.dao.ILiaisonCOFADao;
import fr.elba.model.Famille;
import fr.elba.model.LiaisonCOFA;
import fr.elba.service.ILiaisonCOFAService;

@Service("LiaisonCOFAService")
public class LiaisonCOFAServiceImpl implements ILiaisonCOFAService {

	@Autowired
	private ILiaisonCOFADao lcofaDao;

	public void setLdrclDao(ILiaisonCOFADao lcofaDao) {
		this.lcofaDao = lcofaDao;
	}

	@Override
	public List<LiaisonCOFA> getAll() {
		return lcofaDao.getAll();
	}

	@Override
	public List<LiaisonCOFA> getByFamille(Famille famille){
		return lcofaDao.getByFamille(famille);
	}
	
	@Override
	public LiaisonCOFA getById(int id) {

		return lcofaDao.getById(id);
	}

	@Override
	public void create(LiaisonCOFA liaisonCOFA) {
		lcofaDao.create(liaisonCOFA);
	}

	@Override
	public void update(LiaisonCOFA liaisonCOFA) {
		lcofaDao.update(liaisonCOFA);
	}

	@Override
	public void delete(int id) {
		lcofaDao.delete(id);
	}

}
