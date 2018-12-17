package fr.elba.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.elba.dao.IConditionDao;
import fr.elba.model.Famille;
import fr.elba.model.Passage;
import fr.elba.model.Condition;

@Repository
@Transactional
public class ConditionDaoImpl implements IConditionDao {

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<Condition> getAll() {
		Session s = sf.getCurrentSession();
		String req = "FROM Condition";
		Query query = s.createQuery(req);
		return (List<Condition>) query.list();
	}
	
	@Override
	public List<Condition> getByPassage(Passage passage) {
		Session s = sf.getCurrentSession();
		String req = "FROM Condition WHERE passage = :passage";
		Query query = s.createQuery(req);
		query.setParameter("passage",passage);
		return (List<Condition>) query.list();
	}

	@Override
	public Condition getById(int id) {
		Session s = sf.getCurrentSession();
		return (Condition) s.get(Condition.class, id);
	}
	

	@Override
	public void create(Condition condition) {
		Session s = sf.getCurrentSession();
		s.save(condition);
	}

	@Override
	public void update(Condition condition) {
		Session s = sf.getCurrentSession();
		s.update(condition);
	}

	@Override
	public void delete(int id) {
		Session s = sf.getCurrentSession();
		Condition condition = (Condition) s.get(Condition.class, id);
		s.delete(condition);
	}

}
