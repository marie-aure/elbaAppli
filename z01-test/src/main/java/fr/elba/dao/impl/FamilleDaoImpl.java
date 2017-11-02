package fr.elba.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.elba.dao.IFamilleDao;
import fr.elba.model.Famille;

@Repository
@Transactional
public class FamilleDaoImpl implements IFamilleDao {

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<Famille> getAll() {
		Session s = sf.getCurrentSession();
		String req = "FROM Famille";
		Query query = s.createQuery(req);
		return (List<Famille>) query.list();
	}

	@Override
	public Famille getById(int id) {
		Session s = sf.getCurrentSession();
		return (Famille) s.get(Famille.class, id);
	}

	public Famille getByName(String name) {
		Session s = sf.getCurrentSession();
		String req = "FROM Famille WHERE nom = ?";
		Query query = s.createQuery(req);
		query.setParameter(0, name);
		query.setMaxResults(1);
		return (Famille) query.uniqueResult();
	}

	@Override
	public void create(Famille famille) {
		Session s = sf.getCurrentSession();
		s.save(famille);
	}

	@Override
	public void update(Famille famille) {
		Session s = sf.getCurrentSession();
		s.update(famille);
	}

	@Override
	public void delete(int id) {
		Session s = sf.getCurrentSession();
		Famille famille = (Famille) s.get(Famille.class, id);
		s.delete(famille);
	}

}
