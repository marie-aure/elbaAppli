package fr.elba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.elba.dao.ITerrainDao;
import fr.elba.model.Terrain;
import fr.elba.service.ITerrainService;

@Service("TerrainService")
public class TerrainServiceImpl implements ITerrainService {

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
		teDao.create(terrain);
	}

	@Override
	public void update(Terrain terrain) {
		teDao.update(terrain);
	}

	@Override
	public void delete(int id) {
		teDao.delete(id);
	}

}
