package fr.elba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.elba.dao.ILiaisonDRCLDao;
import fr.elba.model.Droit;
import fr.elba.model.LiaisonDRCL;
import fr.elba.service.ILiaisonDRCLService;

@Service("LiaisonDRCLService")
public class LiaisonDRCLServiceImpl implements ILiaisonDRCLService {

	@Autowired
	private ILiaisonDRCLDao ldrclDao;

	public void setLdrclDao(ILiaisonDRCLDao ldrclDao) {
		this.ldrclDao = ldrclDao;
	}

	@Override
	public List<LiaisonDRCL> getAll() {
		return ldrclDao.getAll();
	}

	@Override
	public List<LiaisonDRCL> getByDroit(Droit droit){
		return ldrclDao.getByDroit(droit);
	}
	
	@Override
	public LiaisonDRCL getById(int id) {

		return ldrclDao.getById(id);
	}

	@Override
	public void create(LiaisonDRCL liaisonDRCL) {
		ldrclDao.create(liaisonDRCL);
	}

	@Override
	public void update(LiaisonDRCL liaisonDRCL) {
		ldrclDao.update(liaisonDRCL);
	}

	@Override
	public void delete(int id) {
		ldrclDao.delete(id);
	}

}
