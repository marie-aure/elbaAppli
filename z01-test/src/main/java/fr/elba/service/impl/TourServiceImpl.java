package fr.elba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.elba.dao.IClasseDao;
import fr.elba.dao.ITourDao;
import fr.elba.model.Classe;
import fr.elba.model.Tour;
import fr.elba.service.ITourService;

@Service("TourService")
public class TourServiceImpl implements ITourService {

	@Autowired
	private ITourDao toDao;

	@Autowired
	private IClasseDao clDao;

	public void setClDao(IClasseDao clDao) {
		this.clDao = clDao;
	}

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
	public int nombreTour(Classe classe){
		return toDao.nombreTour(classe);
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

	@Override
	public void selectionSuivant(Tour tour) {
		// Y même classe mais nb inférieur ?
		List<Tour> lTours = toDao.getSuivantParClasse(tour.getClasse(), tour.getNb());
		Tour suivant = new Tour();
		if (lTours.size() > 0) {
			suivant = lTours.get(0);
		} else if (tour.getClasse().getClasseSup() != null) {
			lTours = toDao.getSuivantParClasse(tour.getClasse().getClasseSup(), tour.getNb());
			if (lTours.size() > 0) {
				suivant = lTours.get(0);
			} else if (tour.getClasse().getLibelle().equals("Illégitime")) {
				Classe classe = clDao.getByName("Paysan");
				lTours = toDao.getSuivantParClasse(classe, tour.getNb());
				tour = lTours.get(0);
			} else if (tour.getClasse().getLibelle().equals("Noblesse")) {
				Classe classe = clDao.getByName("Illégitime");
				lTours = toDao.getSuivantParClasse(classe, tour.getNb() + 1);
				tour = lTours.get(0);
			}
		}

		suivant.setEnCours(true);
		toDao.update(suivant);
	}

}
