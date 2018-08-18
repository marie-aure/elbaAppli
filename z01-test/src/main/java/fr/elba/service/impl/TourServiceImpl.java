package fr.elba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.elba.dao.ITourDao;
import fr.elba.model.Tour;
import fr.elba.service.ITourService;

@Service("TourService")
public class TourServiceImpl implements ITourService {

	@Autowired
	private ITourDao toDao;

	public void setToDao(ITourDao toDao) {
		this.toDao = toDao;
	}

	@Override
	public List<Tour> getAll() {
		return toDao.getAll();
	}

	@Override
	public Tour getById(int id) {
		return toDao.getById(id);
	}

	@Override
	public Tour getEnCours() {
		return toDao.getEnCours();
	}

	@Override
	public void create(Tour tour) {
		toDao.create(tour);
	}

	@Override
	public void update(Tour tour) {
		toDao.update(tour);
	}

	@Override
	public void delete(int id) {
		toDao.delete(id);
	}

}
