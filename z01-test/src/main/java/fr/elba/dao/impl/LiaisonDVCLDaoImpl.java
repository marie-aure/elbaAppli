package fr.elba.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.elba.dao.ILiaisonDVCLDao;
import fr.elba.model.LiaisonDVCL;

@Repository
@Transactional
public class LiaisonDVCLDaoImpl implements ILiaisonDVCLDao {

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<LiaisonDVCL> getAll() {
		Session s = sf.getCurrentSession();
		String req = "From LiaisonDVCL";
		Query query = s.createQuery(req);
		return (List<LiaisonDVCL>) query.list();
	}

	@Override
	public LiaisonDVCL getById(int id) {
		Session s = sf.getCurrentSession();
		return (LiaisonDVCL) s.get(LiaisonDVCL.class, id);
	}

	@Override
	public void create(LiaisonDVCL liaisonDVCL) {
		Session s = sf.getCurrentSession();
		s.save(liaisonDVCL);
	}

	@Override
	public void update(LiaisonDVCL liaisonDVCL) {
		Session s = sf.getCurrentSession();
		s.update(liaisonDVCL);
	}

	@Override
	public void delete(int id) {
		Session s = sf.getCurrentSession();
		LiaisonDVCL liaisonDVCL = (LiaisonDVCL) s.get(LiaisonDVCL.class, id);
		s.delete(liaisonDVCL);
	}

}
