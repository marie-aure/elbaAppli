package fr.elba.dao.impl;

import java.util.List;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.elba.dao.IPassageDao;
import fr.elba.model.Passage;

@Repository
@Transactional
public class PassageDaoImpl implements IPassageDao {

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<Passage> getAll() {
		Session s = sf.getCurrentSession();
		String req = "FROM Passage";
		Query query = s.createQuery(req);
		return (List<Passage>) query.list();
	}

	@Override
	public Passage getById(int id) {
		Session s = sf.getCurrentSession();
		return (Passage) s.get(Passage.class, id);
	}
	
	@Override
	public Passage getByLibelle(String libelle) {
		Session s = sf.getCurrentSession();
		String req = "FROM Passage WHERE libelle = :libelle";
		Query query = s.createQuery(req);
		query.setParameter("libelle", libelle);
		return (Passage) query.uniqueResult();
	}

	@Override
	public void create(Passage passage) {
		Session s = sf.getCurrentSession();
		s.save(passage);
	}

	@Override
	public void update(Passage passage) {
		Session s = sf.getCurrentSession();
		s.update(passage);
	}

	@Override
	public void delete(int id) {
		Session s = sf.getCurrentSession();
		Passage passage = (Passage) s.get(Passage.class, id);
		s.delete(passage);
	}

}
