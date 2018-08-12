package fr.elba.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.elba.dao.IPretDao;
import fr.elba.model.Famille;
import fr.elba.model.Pret;

@Repository
@Transactional
public class PretDaoImpl implements IPretDao {

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<Pret> getAll() {
		Session s = sf.getCurrentSession();
		String req = "FROM Pret";
		Query query = s.createQuery(req);
		return (List<Pret>) query.list();
	}

	@Override
	public Pret getById(int id) {
		Session s = sf.getCurrentSession();
		return (Pret) s.get(Pret.class, id);
	}
	
	@Override
	public List<Pret> getByFamily(Famille famille) {
		Session s = sf.getCurrentSession();
		String req = "FROM Pret WHERE famille = ?";
		Query query = s.createQuery(req);
		query.setParameter(0, famille);
		return (List<Pret>) query.list();
	}

	@Override
	public void create(Pret pret) {
		Session s = sf.getCurrentSession();
		s.save(pret);
	}

	@Override
	public void update(Pret pret) {
		Session s = sf.getCurrentSession();
		s.update(pret);
	}

	@Override
	public void delete(int id) {
		Session s = sf.getCurrentSession();
		Pret pret = (Pret) s.get(Pret.class, id);
		s.delete(pret);
	}

}
