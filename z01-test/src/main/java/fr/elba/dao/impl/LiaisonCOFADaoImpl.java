package fr.elba.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.elba.dao.ILiaisonCOFADao;
import fr.elba.model.Droit;
import fr.elba.model.Famille;
import fr.elba.model.LiaisonCOFA;

@Repository
@Transactional
public class LiaisonCOFADaoImpl implements ILiaisonCOFADao {

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<LiaisonCOFA> getAll() {
		Session s = sf.getCurrentSession();
		String req = "From LiaisonCOFA";
		Query query = s.createQuery(req);
		return (List<LiaisonCOFA>) query.list();
	}

	@Override
	public List<LiaisonCOFA> getByFamille(Famille famille) {
		Session s = sf.getCurrentSession();
		String req = "From LiaisonCOFA WHERE famille = :famille";
		Query query = s.createQuery(req);
		query.setParameter("famille", famille);
		return (List<LiaisonCOFA>) query.list();
	}

	@Override
	public LiaisonCOFA getById(int id) {
		Session s = sf.getCurrentSession();
		return (LiaisonCOFA) s.get(LiaisonCOFA.class, id);
	}

	@Override
	public void create(LiaisonCOFA liaisonCOFA) {
		Session s = sf.getCurrentSession();
		s.save(liaisonCOFA);
	}

	@Override
	public void update(LiaisonCOFA liaisonCOFA) {
		Session s = sf.getCurrentSession();
		s.update(liaisonCOFA);
	}

	@Override
	public void delete(int id) {
		Session s = sf.getCurrentSession();
		LiaisonCOFA liaisonCOFA = (LiaisonCOFA) s.get(LiaisonCOFA.class, id);
		s.delete(liaisonCOFA);
	}

}
