package poudlard.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.validation.Valid;

import poudlard.context.Singleton;
import poudlard.model.Maison;

public class DAOMaison implements IDAOMaison {

	@Override
	public Maison findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Maison maison = em.find(Maison.class, id);
		em.close();
		return maison;
	}

	@Override
	public List<Maison> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Maison> maisons = em.createQuery("from Maison").getResultList();
		em.close();
		return maisons;
	}

	@Override
	public Maison save(Maison maison) {
		EntityManager em = null;
		EntityTransaction tx  = null;

		try 
		{
			em = Singleton.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			maison = em.merge(maison);
			tx.commit();

		}catch(Exception e) 
		{
			if(tx!=null && tx.isActive()) 
			{
				tx.rollback();
			}
		}
		finally {
			if(em!=null) 
			{
				em.close();
			}
		}
		return maison;
	}

	@Override
	public void deleteById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Maison maison = em.find(Maison.class, id);
		em.getTransaction().begin();

		em.remove(maison);

		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void delete(Maison maison) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		maison = em.merge(maison);
		em.getTransaction().begin();
		em.remove(maison);
		em.getTransaction().commit();
		em.close();
	}

}
