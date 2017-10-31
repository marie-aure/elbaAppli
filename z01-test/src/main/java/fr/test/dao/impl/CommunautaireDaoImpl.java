package fr.test.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.test.dao.ICommunautaireDao;
import fr.test.model.Communautaire;
import fr.test.model.Terrain;

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
		List<Communautaire> lCommunautaires = query.list();
		return lCommunautaires;
	}

	@Override
	public Communautaire getById(int id) {
		Session s = sf.getCurrentSession();
		return (Communautaire) s.get(Communautaire.class, id);
	}

	@Override
	public void create(Communautaire communautaire) {
		Session s = sf.getCurrentSession();
		s.save(communautaire);
	}

	@Override
	public void update(Communautaire communautaire) {
		Session s = sf.getCurrentSession();
		s.update(communautaire);
	}

	@Override
	public void delete(int id) {
		Session s = sf.getCurrentSession();
		Communautaire communautaire = (Communautaire) s.get(Communautaire.class, id);
		s.delete(communautaire);
	}

}
