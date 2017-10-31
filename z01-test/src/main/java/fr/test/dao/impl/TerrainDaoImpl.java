package fr.test.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.test.dao.ITerrainDao;
import fr.test.model.Terrain;

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
		List<Terrain> lTerrains = (List<Terrain>) query.list();
		return lTerrains;
	}

	@Override
	public Terrain getById(int id) {
	Session s = sf.getCurrentSession();
		return (Terrain) s.get(Terrain.class, id);
	}

	@Override
	public void create(Terrain terrain) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Terrain terrain) {
		Session s = sf.getCurrentSession();
				s.update(terrain);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

}
