package fr.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.test.dao.ITerrainDao;
import fr.test.model.Terrain;
import fr.test.service.ITerrainService;

@Service("TerrainService")
public class TerrainDaoImpl implements ITerrainService {

	@Autowired
	private ITerrainDao teDao;

	public void setTeDao(ITerrainDao teDao) {
		this.teDao = teDao;
	}

	@Override
	public List<Terrain> getAll() {
		return teDao.getAll();
	}

	@Override
	public Terrain getById(int id) {
		return teDao.getById(id);
	}

	@Override
	public void create(Terrain terrain) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Terrain terrain) {
	teDao.update(terrain);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

}
