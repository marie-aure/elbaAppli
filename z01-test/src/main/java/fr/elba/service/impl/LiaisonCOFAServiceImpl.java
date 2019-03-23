package fr.elba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.elba.dao.ILiaisonCOFADao;
import fr.elba.model.LiaisonCOFA;
import fr.elba.service.ILiaisonCOFAService;

@Service("LiaisonCOFAService")
public class LiaisonCOFAServiceImpl implements ILiaisonCOFAService {

	@Autowired
	private ILiaisonCOFADao lsitrDao;

	@Override
	public List<LiaisonCOFA> getAll() {
		return lsitrDao.getAll();
	}

	@Override
	public LiaisonCOFA getById(int id) {
		return lsitrDao.getById(id);
	}

	@Override
	public void create(LiaisonCOFA liaisonCOFA) {
		lsitrDao.create(liaisonCOFA);
	}

	@Override
	public void update(LiaisonCOFA liaisonCOFA) {
		lsitrDao.update(liaisonCOFA);
	}

	@Override
	public void delete(int id) {
		lsitrDao.delete(id);
	}

}
