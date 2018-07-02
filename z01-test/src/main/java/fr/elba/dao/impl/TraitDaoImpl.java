package fr.elba.dao.impl;

import java.util.List;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.elba.dao.ITraitDao;
import fr.elba.model.Souhait;
import fr.elba.model.Trait;

@Repository
@Transactional
public class TraitDaoImpl implements ITraitDao {

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<Trait> getAll() {
		Session s = sf.getCurrentSession();
		String req = "FROM Trait";
		Query query = s.createQuery(req);
		return (List<Trait>) query.list();
	}

	@Override
	public Trait getById(int id) {
		Session s = sf.getCurrentSession();
		return (Trait) s.get(Trait.class, id);
	}

	@Override
	public Trait getRandom(String type) {

		Session s = sf.getCurrentSession();
		Criterion critere = Restrictions.eq("type", type);
		Criteria crit = s.createCriteria(Trait.class);
		crit.add(critere);
		crit.setProjection(Projections.rowCount());
		int count = ((Number) crit.uniqueResult()).intValue();
		Trait trait = null;
		if (0 != count) {
			int index = new Random().nextInt(count);
			crit = s.createCriteria(Trait.class);
			crit.add(critere);
			trait = (Trait) crit.setFirstResult(index).setMaxResults(1).uniqueResult();
		}
		return trait;
	}

	@Override
	public Trait getRandom() {
		Session s = sf.getCurrentSession();
		Criteria crit = s.createCriteria(Trait.class);
		crit.setProjection(Projections.rowCount());
		int count = ((Number) crit.uniqueResult()).intValue();
		Trait trait = null;
		if (0 != count) {
			int index = new Random().nextInt(count);
			crit = s.createCriteria(Trait.class);
			trait = (Trait) crit.setFirstResult(index).setMaxResults(1).uniqueResult();
		}
		return trait;
	}

	@Override
	public void create(Trait trait) {
		Session s = sf.getCurrentSession();
		s.save(trait);
	}

	@Override
	public void update(Trait trait) {
		Session s = sf.getCurrentSession();
		s.update(trait);
	}

	@Override
	public void delete(int id) {
		Session s = sf.getCurrentSession();
		Trait trait = (Trait) s.get(Trait.class, id);
		s.delete(trait);
	}

}
