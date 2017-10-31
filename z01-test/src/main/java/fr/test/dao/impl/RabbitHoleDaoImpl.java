package fr.test.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.test.dao.IRabbitHoleDao;
import fr.test.model.RabbitHole;

@Repository
@Transactional
public class RabbitHoleDaoImpl implements IRabbitHoleDao {

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<RabbitHole> getAll() {
		Session s = sf.getCurrentSession();
		String req = "FROM RabbitHole";
		Query query = s.createQuery(req);
		List<RabbitHole> lRabbitHoles = query.list();
		return lRabbitHoles;
	}

	@Override
	public RabbitHole getById(int id) {
		Session s = sf.getCurrentSession();
		RabbitHole rabbitHole = (RabbitHole) s.get(RabbitHole.class, id);
		return rabbitHole;
	}

	@Override
	public RabbitHole getByName(String name) {
		Session s = sf.getCurrentSession();
		String req = "FROM RabbitHole WHERE libelle = ?";
		Query query = s.createQuery(req);
		query.setParameter(0, name);
		query.setMaxResults(1);
		return (RabbitHole) query.uniqueResult();
	}

	@Override
	public void create(RabbitHole rabbitHole) {
		Session s = sf.getCurrentSession();
		s.save(rabbitHole);
	}

	@Override
	public void update(RabbitHole rabbitHole) {
		Session s = sf.getCurrentSession();
		s.update(rabbitHole);
	}

	@Override
	public void delete(int id) {
		Session s = sf.getCurrentSession();
		RabbitHole rabbitHole = (RabbitHole) s.get(RabbitHole.class, id);
		s.delete(rabbitHole);
	}

}
