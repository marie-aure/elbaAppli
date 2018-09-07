package fr.elba.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.elba.dao.ITourDao;
import fr.elba.model.Classe;
import fr.elba.model.LiaisonSITR;
import fr.elba.model.Tour;

@Repository
@Transactional
public class TourDaoImpl implements ITourDao {

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<Tour> getAll() {
		Session s = sf.getCurrentSession();
		String req = "FROM Tour";
		Query query = s.createQuery(req);
		return (List<Tour>) query.list();
	}

	@Override
	public List<Tour> getSuivantParClasse(Classe classe, int nb) {
		Session s = sf.getCurrentSession();
		String req = "FROM Tour WHERE classe = :classe and nb < :nb";
		Query query = s.createQuery(req);
		query.setParameter("classe", classe);
		query.setParameter("nb", nb);
		return (List<Tour>) query.list();
	}

	@Override
	public Tour getById(int id) {
		Session s = sf.getCurrentSession();
		return (Tour) s.get(Tour.class, id);
	}

	@Override
	public Tour getEnCours() {
		Session s = sf.getCurrentSession();
		String req = "FROM Tour WHERE enCours = 1";
		Query query = s.createQuery(req);
		query.setMaxResults(1);
		return (Tour) query.uniqueResult();
	}

	@Override
	public int nombreTour(Classe classe){
		Session s = sf.getCurrentSession();
		
		 String req = "call get_nombreTour(:classe)";
			Query query = s.createSQLQuery(req);
			query.setParameter("classe", classe.getId());
			
			int nb = 0;
			try {
					nb = (int) query.uniqueResult();
			} catch (Exception e){
				System.out.println("C'est null mon neveu!!");
			}
			return nb;
					
					
		
	}

	@Override
	public void create(Tour tour) {
		Session s = sf.getCurrentSession();
		s.save(tour);
	}

	@Override
	public void update(Tour tour) {
		Session s = sf.getCurrentSession();
		s.update(tour);
	}

	@Override
	public void delete(int id) {
		Session s = sf.getCurrentSession();
		Tour tour = (Tour) s.get(Tour.class, id);
		s.delete(tour);
	}

}
