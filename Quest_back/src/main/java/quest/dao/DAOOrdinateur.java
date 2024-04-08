package quest.dao;

import java.util.List;

import javax.persistence.EntityManager;

import quest.context.Singleton;
import quest.model.Module;
import quest.model.Ordinateur;

public class DAOOrdinateur implements IDAOOrdinateur {

	@Override
	public Ordinateur findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Ordinateur ordinateur = em.find(Ordinateur.class, id);
		em.close();
		return ordinateur;
	}

	@Override
	public List<Ordinateur> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Ordinateur> ordinateurs = em.createQuery("from Ordinateur").getResultList();
		em.close();
		return ordinateurs;
	}

	@Override
	public Ordinateur save(Ordinateur ordinateur) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();

		ordinateur = em.merge(ordinateur);

		em.getTransaction().commit();
		em.close();
		return ordinateur;
	}

	@Override
	public void deleteById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Ordinateur ordinateur = em.find(Ordinateur.class, id);
		em.getTransaction().begin();

		em.remove(ordinateur);

		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void delete(Ordinateur ordinateur) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		ordinateur = em.merge(ordinateur);
		em.getTransaction().begin();
		em.remove(ordinateur);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Ordinateur findByStagiaire(Integer idStagiaire) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Ordinateur ordinateur = null;
		try {
		ordinateur = (Ordinateur) em.createQuery("SELECT o from Ordinateur o where o.stagiaire.id=:id").setParameter("id", idStagiaire).getSingleResult();
		}
		catch(Exception e) {e.printStackTrace();}
		em.close();
		return ordinateur;
	}


	
	

}
