package fr.elba.dao.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.elba.dao.IStarterDao;
import fr.elba.model.Starter;

@Repository
@Transactional
public class StarterDaoImpl implements IStarterDao {

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<Starter> getAll() {
		Session s = sf.getCurrentSession();
		String req = "FROM Starter";
		Query query = s.createQuery(req);
		return (List<Starter>) query.list();
	}

	@Override
	public List<Starter> getByGroup(int groupe) {
		Session s = sf.getCurrentSession();
		String req = "FROM Starter where groupe = :groupe";
		Query query = s.createQuery(req);
		query.setParameter("groupe", groupe);
		return (List<Starter>) query.list();
	}
	
	@Override
	public Starter getById(int id) {
		Session s = sf.getCurrentSession();
		return (Starter) s.get(Starter.class, id);
	}

	@Override
	public void create(Starter starter) {
		Session s = sf.getCurrentSession();
		s.clear();
		s.save(starter);
	}

	@Override
	public void update(Starter starter) {
		Session s = sf.getCurrentSession();
		s.clear();
		s.update(starter);
	}

	@Override
	public void delete(int id) {
		Session s = sf.getCurrentSession();
		Starter starter = (Starter) s.get(Starter.class, id);
		s.delete(starter);
	}
	
	@Override
	public List<Integer> getDistinctGroups(){
		Session s = sf.getCurrentSession();
		String req = "Select Distinct groupe FROM Starter";
		Query query = s.createQuery(req);
		List<Integer> liste = (List<Integer>) query.list();
		Collections.sort(liste);
		return liste;
	}

}
