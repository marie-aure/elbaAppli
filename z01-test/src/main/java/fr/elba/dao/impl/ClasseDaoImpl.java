package fr.elba.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.elba.dao.IClasseDao;
import fr.elba.model.Classe;

@Repository
@Transactional
public class ClasseDaoImpl implements IClasseDao {

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<Classe> getAll() {
		Session s = sf.getCurrentSession();
		String req = "FROM Classe";
		Query query = s.createQuery(req);
		return (List<Classe>) query.list();
	}

	@Override
	public Classe getById(int id) {
		Session s = sf.getCurrentSession();
		return (Classe) s.get(Classe.class, id);
	}

	@Override
	public Classe getByName(String name) {
		Session s = sf.getCurrentSession();
		String req = "FROM Classe WHERE libelle = ?";
		Query query = s.createQuery(req);
		query.setParameter(0, name);
		query.setMaxResults(1);
		return (Classe) query.uniqueResult();
	}

	@Override
	public void create(Classe classe) {
		Session s = sf.getCurrentSession();
		s.save(classe);
	}

	@Override
	public void update(Classe classe) {
		Session s = sf.getCurrentSession();
		s.update(classe);
	}

	@Override
	public void delete(int id) {
		Session s = sf.getCurrentSession();
		Classe classe = (Classe) s.get(Classe.class, id);
		s.delete(classe);
	}

}
