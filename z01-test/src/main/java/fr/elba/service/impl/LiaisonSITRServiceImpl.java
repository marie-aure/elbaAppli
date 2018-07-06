package fr.elba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.elba.dao.ILiaisonSITRDao;
import fr.elba.model.LiaisonSITR;
import fr.elba.service.ILiaisonSITRService;

@Service("LiaisonSITRService")
public class LiaisonSITRServiceImpl implements ILiaisonSITRService {

	@Autowired
	private ILiaisonSITRDao lsitrDao;

	public void setLsitrDao(ILiaisonSITRDao lsitrDao) {
		this.lsitrDao = lsitrDao;
	}

	@Override
	public List<LiaisonSITR> getAll() {
		return lsitrDao.getAll();
	}

	@Override
	public LiaisonSITR getById(int id) {

		return lsitrDao.getById(id);
	}

	@Override
	public void create(LiaisonSITR liaisonSITR) {
		lsitrDao.create(liaisonSITR);
	}

	@Override
	public void update(LiaisonSITR liaisonSITR) {
		lsitrDao.update(liaisonSITR);
	}

	@Override
	public void delete(int id) {
		lsitrDao.delete(id);
	}
	
	@Override
	public List<LiaisonSITR> chargerGroupe(int groupe){
		return lsitrDao.getByGroup(groupe);
	}

}
