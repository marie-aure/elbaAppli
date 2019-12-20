package fr.elba.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.elba.dao.IProfessionDao;
import fr.elba.model.Profession;

@Repository
@Transactional
public class ProfessionDaoImpl implements IProfessionDao {

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<Profession> getAll() {
		Session s = sf.getCurrentSession();
		String req = "FROM Profession";
		Query query = s.createQuery(req);
		return (List<Profession>) query.list();
	}

	@Override
	public Profession getById(int id) {
		Session s = sf.getCurrentSession();
		return (Profession) s.get(Profession.class, id);
	}

	@Override
	public void create(Profession profession) {
		Session s = sf.getCurrentSession();
		s.save(profession);
	}

	@Override
	public void update(Profession profession) {
		Session s = sf.getCurrentSession();
		s.update(profession);
	}

	@Override
	public void delete(int id) {
		Session s = sf.getCurrentSession();
		Profession profession = (Profession) s.get(Profession.class, id);
		s.delete(profession);
	}

}
