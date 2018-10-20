package fr.elba.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.elba.dao.IDroitDao;
import fr.elba.model.Droit;

@Repository
@Transactional
public class DroitDaoImpl implements IDroitDao {

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<Droit> getAll() {
		Session s = sf.getCurrentSession();
		String req = "FROM Droit";
		Query query = s.createQuery(req);
		return (List<Droit>) query.list();
	}

	@Override
	public Droit getById(int id) {
		Session s = sf.getCurrentSession();
		return (Droit) s.get(Droit.class, id);
	}

	@Override
	public void create(Droit droit) {
		Session s = sf.getCurrentSession();
		s.save(droit);
	}

	@Override
	public void update(Droit droit) {
		Session s = sf.getCurrentSession();
		s.update(droit);
	}

	@Override
	public void delete(int id) {
		Session s = sf.getCurrentSession();
		Droit droit = (Droit) s.get(Droit.class, id);
		s.delete(droit);
	}

}
