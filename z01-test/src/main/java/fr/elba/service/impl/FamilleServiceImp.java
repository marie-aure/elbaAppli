package fr.elba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.elba.dao.IFamilleDao;
import fr.elba.model.Classe;
import fr.elba.model.Famille;
import fr.elba.model.LiaisonSITR;
import fr.elba.model.Sim;
import fr.elba.model.Starter;
import fr.elba.model.Tour;
import fr.elba.service.IClasseService;
import fr.elba.service.IFamilleService;
import fr.elba.service.IStarterService;
import fr.elba.service.ITourService;

@Service("FamilleService")
public class FamilleServiceImp implements IFamilleService {

	@Autowired
	private IFamilleDao faDao;

	@Autowired
	private IClasseService clSer;

	@Autowired
	private IStarterService stSer;

	@Autowired
	private ITourService toSer;

	public void setFaDao(IFamilleDao faDao) {
		this.faDao = faDao;
	}

	public void setClSer(IClasseService clSer) {
		this.clSer = clSer;
	}

	public void setStSer(IStarterService stSer) {
		this.stSer = stSer;
	}

	public void setToSer(ITourService toSer) {
		this.toSer = toSer;
	}

	@Override
	public List<Famille> getAll() {
		return faDao.getAll();
	}

	@Override
	public Famille getById(int id) {
		return faDao.getById(id);
	}

	@Override
	public Famille getByName(String name) {
		return faDao.getByName(name);
	}

	@Override
	public void create(Famille famille) {
		faDao.create(famille);
	}

	@Override
	public void update(Famille famille) {
		faDao.update(famille);
	}

	@Override
	public void delete(int id) {
		faDao.delete(id);
	}

	@Override
	public void validerGroupe(List<LiaisonSITR> lStarters) {
		// pour chaque couple du groupe (boucle 8)
		for (int i = 0; i < 8; i++) {

			// déterminer le nom de famille et le chef de famille
			Starter starter1 = (Starter) lStarters.get(2 * i).getSim();
			Starter starter2 = (Starter) lStarters.get(2 * i + 1).getSim();

			Sim chef;

			if (!starter1.getSexe().equals(starter2.getSexe()) && starter1.getSexe().equals("M")) {
				chef = starter1;
				starter2.setNomOrigine(starter2.getNom());
				starter2.setNom(starter1.getNom());
			} else if (!starter1.getSexe().equals(starter2.getSexe()) && starter2.getSexe().equals("M")) {
				chef = starter2;
				starter1.setNomOrigine(starter1.getNom());
				starter1.setNom(starter2.getNom());
			} else if (starter1.getNom().substring(0, 1).compareTo(starter2.getNom().substring(0, 1)) > 0) {
				chef = starter2;
				starter1.setNomOrigine(starter1.getNom());
				starter1.setNom(starter2.getNom());
			} else {
				chef = starter1;
				starter2.setNomOrigine(starter2.getNom());
				starter2.setNom(starter1.getNom());
			}
			// créer famille
			Classe pauvre = clSer.getByName("Pauvre");
			Famille famille = new Famille(chef.getNom(), 1, 0, pauvre, null, chef);
			Tour tour = new Tour(false, 0, famille, pauvre);
			create(famille);
			starter1.setFamille(famille);
			starter2.setFamille(famille);
			starter1.setFamilleOrigine(famille);
			starter2.setFamilleOrigine(famille);
			stSer.update(starter1);
			stSer.update(starter2);
			toSer.create(tour);
		}

	}

}
