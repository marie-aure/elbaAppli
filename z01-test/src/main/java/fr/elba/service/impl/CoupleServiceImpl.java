package fr.elba.service.impl;

import java.util.ArrayList;
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
	private ISimDao siDao;

	@Override
	public List<List<Sim>> getAllFiance() {
		List<List<Sim>> lCouples = new ArrayList<List<Sim>>();
		List<Sim> liste = siDao.getAllFiance();
		if (liste.size() > 0) {
			for (Sim sim : liste) {
				if (sim.getCouple() != null) {
					List<Sim> couple = new ArrayList<Sim>();
					couple.add(sim);
					couple.add(sim.getCouple());
//					liste.remove(sim.getCouple());
					lCouples.add(couple);
				}
			}
			return lCouples;
		} else {
			return null;
		}

	}
}
