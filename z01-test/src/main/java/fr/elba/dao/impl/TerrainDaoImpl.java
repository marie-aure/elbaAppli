package fr.elba.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.elba.dao.ITerrainDao;
import fr.elba.model.Terrain;

@Repository
@Transactional
public class TerrainDaoImpl implements ITerrainDao {

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<Terrain> getAll() {
		Session s = sf.getCurrentSession();
		String req = "FROM Terrain";
		Query query = s.createQuery(req);
		return (List<Terrain>) query.list();
	}

	@Override
	public Terrain getById(int id) {
		Session s = sf.getCurrentSession();
		return (Terrain) s.get(Terrain.class, id);
	}

	@Override
	public void create(Terrain terrain) {
		Session s = sf.getCurrentSession();
		s.save(terrain);
	}

	@Override
	public void update(Terrain terrain) {
		Session s = sf.getCurrentSession();
		s.update(terrain);
	}

	@Override
	public void delete(int id) {
		Session s = sf.getCurrentSession();
		Terrain terrain = (Terrain) s.get(Terrain.class, id);
		s.delete(terrain);
	}

}
