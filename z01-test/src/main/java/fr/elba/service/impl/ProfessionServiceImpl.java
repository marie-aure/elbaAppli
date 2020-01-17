package fr.elba.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.elba.dao.IProfessionDao;
import fr.elba.model.Profession;
import fr.elba.service.IProfessionService;

@Service("ProfessionService")
public class ProfessionServiceImpl implements IProfessionService {

	@Autowired
	private IProfessionDao prDao;

	public void setPrDao(IProfessionDao prDao) {
		this.prDao = prDao;
	}

	@Override
	public List<Profession> getAll() {
		return prDao.getAll();
	}

	@Override
	public Profession getById(int id) {
		return prDao.getById(id);
	}

	@Override
	public void create(Profession profession) {
		prDao.create(profession);
	}

	@Override
	public void update(Profession profession) {
		prDao.update(profession);
	}

	@Override
	public void delete(int id) {
		prDao.delete(id);
	}

	@Override
	public Map<String, Integer> getListProfession() {
		List<Profession> liste = prDao.getAll();
		Map<String, Integer> map = new HashMap();
		if (liste.size() > 0) {
			for (Profession profession : liste) {
				map.put(profession.getLibelle(), profession.getId());
			}
		}
		return map;
	}

}
