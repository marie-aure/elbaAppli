package fr.elba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.elba.dao.ISouhaitDao;
import fr.elba.model.Souhait;
import fr.elba.service.ISouhaitService;

@Service("SouhaitService")
public class SouhaitServiceImpl implements ISouhaitService {

	@Autowired
	private ISouhaitDao soDao;

	public void setSoDao(ISouhaitDao soDao) {
		this.soDao = soDao;
	}

	@Override
	public List<Souhait> getAll() {
		return soDao.getAll();
	}

	@Override
	public Souhait getById(int id) {
		return soDao.getById(id);
	}

	@Override
	public Souhait getRandom(){
		return soDao.getRandom();
	}
	
	@Override
	public void create(Souhait souhait) {
		soDao.create(souhait);
	}

	@Override
	public void update(Souhait souhait) {
		soDao.update(souhait);
	}

	@Override
	public void delete(int id) {
		soDao.delete(id);
	}

}
