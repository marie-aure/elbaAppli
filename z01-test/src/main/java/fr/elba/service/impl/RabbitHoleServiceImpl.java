package fr.elba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.elba.dao.IRabbitHoleDao;
import fr.elba.model.RabbitHole;
import fr.elba.service.IRabbitHoleService;

@Service("RabbitHoleService")
public class RabbitHoleServiceImpl implements IRabbitHoleService {

	@Autowired
	private IRabbitHoleDao rhDao;

	public void setRhDao(IRabbitHoleDao rhDao) {
		this.rhDao = rhDao;
	}

	@Override
	public List<RabbitHole> getAll() {
		return rhDao.getAll();
	}

	@Override
	public RabbitHole getById(int id) {
		return rhDao.getById(id);
	}

	@Override
	public RabbitHole getByName(String name) {
		return rhDao.getByName(name);
	}

	@Override
	public void create(RabbitHole rabbitHole) {
		rhDao.create(rabbitHole);
	}

	@Override
	public void update(RabbitHole rabbitHole) {
		rhDao.update(rabbitHole);
	}

	@Override
	public void delete(int id) {
		rhDao.delete(id);
	}

}
