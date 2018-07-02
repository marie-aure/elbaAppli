package fr.elba.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.elba.dao.ILiaisonSITRDao;
import fr.elba.model.LiaisonSITR;

@Repository
@Transactional
public class LiaisonSITRDaoImpl implements ILiaisonSITRDao {

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<LiaisonSITR> getAll() {
		Session s = sf.getCurrentSession();
		String req = "From LiaisonSITR";
		Query query = s.createQuery(req);
		return (List<LiaisonSITR>) query.list();
	}

	@Override
	public LiaisonSITR getById(int id) {
		Session s = sf.getCurrentSession();
		return (LiaisonSITR) s.get(LiaisonSITR.class, id);
	}

	@Override
	public void create(LiaisonSITR liaisonSITR) {
		Session s = sf.getCurrentSession();
		s.save(liaisonSITR);
	}

	@Override
	public void update(LiaisonSITR liaisonSITR) {
		Session s = sf.getCurrentSession();
		s.update(liaisonSITR);
	}

	@Override
	public void delete(int id) {
		Session s = sf.getCurrentSession();
		LiaisonSITR liaisonSITR = (LiaisonSITR) s.get(LiaisonSITR.class, id);
		s.delete(liaisonSITR);
	}
	
	
	
	
	
	@Override
	public List<LiaisonSITR> getByGroup(int groupe){		
	 Session s = sf.getCurrentSession();
		String req = "call get_groupe(:groupe)";
		Query query = s.createSQLQuery(req);
		query.setParameter("groupe", groupe);
		return (List<LiaisonSITR>) query.list();
	
	}

}
