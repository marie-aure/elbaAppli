package fr.elba.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.elba.dao.IDevoirDao;
import fr.elba.model.Devoir;

@Repository
@Transactional
public class DevoirDaoImpl implements IDevoirDao {

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<Devoir> getAll() {
		Session s = sf.getCurrentSession();
		String req = "FROM Devoir";
		Query query = s.createQuery(req);
		return (List<Devoir>) query.list();
	}

	@Override
	public Devoir getById(int id) {
		Session s = sf.getCurrentSession();
		return (Devoir) s.get(Devoir.class, id);
	}

	@Override
	public void create(Devoir devoir) {
		Session s = sf.getCurrentSession();
		s.save(devoir);
	}

	@Override
	public void update(Devoir devoir) {
		Session s = sf.getCurrentSession();
		s.update(devoir);
	}

	@Override
	public void delete(int id) {
		Session s = sf.getCurrentSession();
		Devoir devoir = (Devoir) s.get(Devoir.class, id);
		s.delete(devoir);
	}

}
