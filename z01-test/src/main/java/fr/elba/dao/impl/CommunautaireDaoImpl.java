package fr.elba.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.elba.dao.ICommunautaireDao;
import fr.elba.model.Communautaire;

@Repository
@Transactional
public class CommunautaireDaoImpl implements ICommunautaireDao {

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<Communautaire> getAll() {
		Session s = sf.getCurrentSession();
		String req = "FROM Communautaire";
		Query query = s.createQuery(req);
		return (List<Communautaire>) query.list();
	}

	@Override
	public Communautaire getById(int id) {
		Session s = sf.getCurrentSession();
		return (Communautaire) s.get(Communautaire.class, id);
	}

	@Override
	public void create(Communautaire communautaire) {
		Session s = sf.getCurrentSession();
		s.clear();
		s.save(communautaire);
	}

	@Override
	public void update(Communautaire communautaire) {
		Session s = sf.getCurrentSession();
		s.clear();
		s.update(communautaire);
	}

	@Override
	public void delete(int id) {
		Session s = sf.getCurrentSession();
		Communautaire communautaire = (Communautaire) s.get(Communautaire.class, id);
		s.delete(communautaire);
	}

}
