package fr.elba.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.elba.dao.ISimDao;
import fr.elba.model.Sim;
import fr.elba.model.Sim;

@Repository
@Transactional
public class SimDaoImpl implements ISimDao {

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<Sim> getAll() {
		Session s = sf.getCurrentSession();
		String req = "FROM Sim";
		Query query = s.createQuery(req);
		return (List<Sim>) query.list();
	}

	@Override
	public Sim getById(int id) {
		Session s = sf.getCurrentSession();
		return (Sim) s.get(Sim.class, id);
	}

	@Override
	public void create(Sim sim) {
		Session s = sf.getCurrentSession();
		s.save(sim);
	}

	@Override
	public void update(Sim sim) {
		Session s = sf.getCurrentSession();
		s.update(sim);
	}

	@Override
	public void delete(int id) {
		Session s = sf.getCurrentSession();
		Sim sim = (Sim) s.get(Sim.class, id);
		s.delete(sim);
	}

}
