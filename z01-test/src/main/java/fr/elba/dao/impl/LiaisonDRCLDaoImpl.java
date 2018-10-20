package fr.elba.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.elba.dao.ILiaisonDRCLDao;
import fr.elba.model.Droit;
import fr.elba.model.LiaisonDRCL;

@Repository
@Transactional
public class LiaisonDRCLDaoImpl implements ILiaisonDRCLDao {

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<LiaisonDRCL> getAll() {
		Session s = sf.getCurrentSession();
		String req = "From LiaisonDRCL";
		Query query = s.createQuery(req);
		return (List<LiaisonDRCL>) query.list();
	}

	@Override
	public List<LiaisonDRCL> getByDroit(Droit droit) {
		Session s = sf.getCurrentSession();
		String req = "From LiaisonDRCL WHERE droit = :droit order by classe";
		Query query = s.createQuery(req);
		query.setParameter("droit", droit);
		return (List<LiaisonDRCL>) query.list();
	}

	@Override
	public LiaisonDRCL getById(int id) {
		Session s = sf.getCurrentSession();
		return (LiaisonDRCL) s.get(LiaisonDRCL.class, id);
	}

	@Override
	public void create(LiaisonDRCL liaisonDRCL) {
		Session s = sf.getCurrentSession();
		s.save(liaisonDRCL);
	}

	@Override
	public void update(LiaisonDRCL liaisonDRCL) {
		Session s = sf.getCurrentSession();
		s.update(liaisonDRCL);
	}

	@Override
	public void delete(int id) {
		Session s = sf.getCurrentSession();
		LiaisonDRCL liaisonDRCL = (LiaisonDRCL) s.get(LiaisonDRCL.class, id);
		s.delete(liaisonDRCL);
	}

}
