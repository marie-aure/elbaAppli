package fr.elba.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.elba.dao.IPriveDao;
import fr.elba.model.Famille;
import fr.elba.model.Prive;

@Repository
@Transactional
public class PriveDaoImpl implements IPriveDao {

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<Prive> getAll() {
		Session s = sf.getCurrentSession();
		String req = "FROM Prive";
		Query query = s.createQuery(req);
		return (List<Prive>) query.list();
	}

	@Override
	public Prive getById(int id) {
		Session s = sf.getCurrentSession();
		return (Prive) s.get(Prive.class, id);
	}
	@Override
	public List<Prive> getByOwner(Famille famille) {
		Session s = sf.getCurrentSession();
		String req = "FROM Prive WHERE proprietaire = :famille";
		Query query = s.createQuery(req);
		query.setParameter("famille", famille);
		return (List<Prive>) query.list();
	}

	
	@Override
	public List<Prive> getAVendre() {
		Session s = sf.getCurrentSession();
		String req = "FROM Prive WHERE proprietaire IS NULL";
		Query query = s.createQuery(req);
		return (List<Prive>) query.list();
	}

	@Override
	public void create(Prive prive) {
		Session s = sf.getCurrentSession();
		s.clear();
		s.save(prive);
	}

	@Override
	public void update(Prive prive) {
		Session s = sf.getCurrentSession();
		s.clear();
		s.update(prive);
	}

	@Override
	public void delete(int id) {
		Session s = sf.getCurrentSession();
		Prive prive = (Prive) s.get(Prive.class, id);
		s.delete(prive);
	}

}
