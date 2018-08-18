package fr.elba.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.elba.dao.ICompteDao;
import fr.elba.model.Famille;
import fr.elba.model.Compte;

@Repository
@Transactional
public class CompteDaoImpl implements ICompteDao {

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<Compte> getAll() {
		Session s = sf.getCurrentSession();
		String req = "FROM Compte";
		Query query = s.createQuery(req);
		return (List<Compte>) query.list();
	}

	@Override
	public Compte getById(int id) {
		Session s = sf.getCurrentSession();
		return (Compte) s.get(Compte.class, id);
	}
	
	@Override
	public List<Compte> getByFamily(Famille famille) {
		Session s = sf.getCurrentSession();
		String req = "FROM Compte WHERE famille = ?";
		Query query = s.createQuery(req);
		query.setParameter(0, famille);
		return (List<Compte>) query.list();
	}

	@Override
	public void create(Compte compte) {
		Session s = sf.getCurrentSession();
		s.save(compte);
	}

	@Override
	public void update(Compte compte) {
		Session s = sf.getCurrentSession();
		s.update(compte);
	}

	@Override
	public void delete(int id) {
		Session s = sf.getCurrentSession();
		Compte compte = (Compte) s.get(Compte.class, id);
		s.delete(compte);
	}

}
