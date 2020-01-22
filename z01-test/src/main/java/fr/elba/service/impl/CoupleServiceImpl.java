package fr.elba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.elba.dao.ILiaisonSITRDao;
import fr.elba.dao.ISimDao;
import fr.elba.model.Couple;
import fr.elba.model.LiaisonSITR;
import fr.elba.model.Sim;
import fr.elba.service.ICoupleService;
import fr.elba.service.ILiaisonSITRService;

@Service("CoupleService")
public class CoupleServiceImpl implements ICoupleService {

	@Autowired
	private ILiaisonSITRDao lSitrDao;

	@Override
	public List<Couple> getAllFiance() {
		List<LiaisonSITR> liste = lSitrDao.getAllFiance();
		return null;
	}


}
