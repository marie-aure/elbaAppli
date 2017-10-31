package fr.test.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.test.dao.ISimDao;
import fr.test.model.Sim;

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
	public Sim getByName(String prenom, String nom) {
		Session s = sf.getCurrentSession();
		String req = "FROM Sim WHERE prenom = ? nom = ?";
		Query query = s.createQuery(req);
		query.setParameter(0, prenom);
		query.setParameter(1, nom);
		query.setMaxResults(1);
		return (Sim) query.uniqueResult();
	}

	@Override
	public void create(Sim sim) {
		Session s = sf.getCurrentSession();

	}

	@Override
	public void update(Sim sim) {
		Session s = sf.getCurrentSession();

	}

	@Override
	public void delete(int id) {
		Session s = sf.getCurrentSession();

	}

}
