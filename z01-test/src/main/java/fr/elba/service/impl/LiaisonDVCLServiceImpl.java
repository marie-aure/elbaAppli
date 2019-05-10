package fr.elba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.elba.dao.ILiaisonDVCLDao;
import fr.elba.model.Devoir;
import fr.elba.model.LiaisonDVCL;
import fr.elba.service.ILiaisonDVCLService;

@Service("LiaisonDVCLService")
public class LiaisonDVCLServiceImpl implements ILiaisonDVCLService {

	@Autowired
	private ILiaisonDVCLDao ldvclDao;

	public void setLdvclDao(ILiaisonDVCLDao ldvclDao) {
		this.ldvclDao = ldvclDao;
	}

	@Override
	public List<LiaisonDVCL> getAll() {
		return ldvclDao.getAll();
	}
	
	@Override
	public List<LiaisonDVCL> getByDevoir(Devoir devoir){
		return ldvclDao.getByDevoir(devoir);
	}

	@Override
	public LiaisonDVCL getById(int id) {

		return ldvclDao.getById(id);
	}

	@Override
	public void create(LiaisonDVCL liaisonDVCL) {
		ldvclDao.create(liaisonDVCL);
	}

	@Override
	public void update(LiaisonDVCL liaisonDVCL) {
		ldvclDao.update(liaisonDVCL);
	}

	@Override
	public void delete(int id) {
		ldvclDao.delete(id);
	}

}
