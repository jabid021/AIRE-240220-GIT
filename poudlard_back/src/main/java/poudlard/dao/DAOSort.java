package poudlard.dao;

import java.util.List;

import javax.persistence.EntityManager;

import poudlard.context.Singleton;
import poudlard.model.Sort;

public class DAOSort implements IDAOSort {

	@Override
	public Sort findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Sort sort = em.find(Sort.class, id);
		em.close();
		return sort;
	}

	@Override
	public List<Sort> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Sort> sorts = em.createQuery("from Sort").getResultList();
		em.close();
		return sorts;
	}

	@Override
	public Sort save(Sort sort) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();

		sort = em.merge(sort);

		em.getTransaction().commit();
		em.close();
		return sort;
	}

	@Override
	public void deleteById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Sort sort = em.find(Sort.class, id);
		em.getTransaction().begin();

		em.remove(sort);

		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void delete(Sort sort) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		sort = em.merge(sort);
		em.getTransaction().begin();
		em.remove(sort);
		em.getTransaction().commit();
		em.close();
	}

}
