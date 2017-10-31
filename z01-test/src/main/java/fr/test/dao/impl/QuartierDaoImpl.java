package fr.test.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.test.dao.IQuartierDao;
import fr.test.model.Quartier;

@Repository
@Transactional
public class QuartierDaoImpl implements IQuartierDao {

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<Quartier> getAll() {
		Session s = sf.getCurrentSession();
		String req = "FROM Quartier";
		Query query = s.createQuery(req);
		List<Quartier> lQuartiers = query.list();
		return lQuartiers;
	}

	@Override
	public Quartier getById(int id) {
		Session s = sf.getCurrentSession();
		Quartier quartier = (Quartier) s.get(Quartier.class, id);
		return quartier;
	}

	@Override
	public Quartier getByName(String name) {
		Session s = sf.getCurrentSession();
		String req = "FROM Quartier WHERE libelle = ?";
		Query query = s.createQuery(req);
		query.setParameter(0, name);
		query.setMaxResults(1);
		Quartier quartier = (Quartier) query.uniqueResult();
		return quartier;
	}

	@Override
	public void create(Quartier quartier) {
		Session s = sf.getCurrentSession();
		s.save(quartier);
	}

	@Override
	public void update(Quartier quartier) {
		Session s = sf.getCurrentSession();
		s.update(quartier);
	}

	@Override
	public void delete(int id) {
		Session s = sf.getCurrentSession();
		Quartier quartier = (Quartier) s.get(Quartier.class, id);
		s.delete(quartier);
	}

}
