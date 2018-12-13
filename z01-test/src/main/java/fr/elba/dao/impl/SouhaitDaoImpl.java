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

import fr.elba.dao.ISouhaitDao;
import fr.elba.model.Souhait;

@Repository
@Transactional
public class SouhaitDaoImpl implements ISouhaitDao {

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<Souhait> getAll() {
		Session s = sf.getCurrentSession();
		String req = "FROM Souhait";
		Query query = s.createQuery(req);
		return (List<Souhait>) query.list();
	}

	@Override
	public Souhait getById(int id) {
		Session s = sf.getCurrentSession();
		return (Souhait) s.get(Souhait.class, id);
	}
	
	@Override
	public Souhait getByName(String name) {
		Session s = sf.getCurrentSession();
		String req = "FROM Souhait WHERE libelle = :name";
		Query query = s.createQuery(req);
		query.setParameter("name", name);
		return (Souhait) query.uniqueResult();
	}

	@Override
	public void create(Souhait souhait) {
		Session s = sf.getCurrentSession();
		s.save(souhait);
	}

	@Override
	public void update(Souhait souhait) {
		Session s = sf.getCurrentSession();
		s.update(souhait);
	}

	@Override
	public void delete(int id) {
		Session s = sf.getCurrentSession();
		Souhait souhait = (Souhait) s.get(Souhait.class, id);
		s.delete(souhait);
	}

	@Override
	public Souhait getRandom(){
		Session s = sf.getCurrentSession();
		Criteria crit = s.createCriteria(Souhait.class);
		crit.setProjection(Projections.rowCount());
		int count = ((Number) crit.uniqueResult()).intValue();
		Souhait souhait = null;
		if (0 != count) {
		  int index = new Random().nextInt(count);
		  crit = s.createCriteria(Souhait.class);
		  souhait = (Souhait) crit.setFirstResult(index).setMaxResults(1).uniqueResult();
		}
		return souhait;
	}
}
