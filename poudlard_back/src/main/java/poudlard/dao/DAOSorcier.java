package poudlard.dao;

import java.util.List;

import javax.persistence.EntityManager;

import poudlard.context.Singleton;
import poudlard.model.Professeur;
import poudlard.model.Sorcier;

public class DAOSorcier implements IDAOSorcier {

	@Override
	public Sorcier findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Sorcier sorcier = em.find(Sorcier.class, id);
		em.close();
		return sorcier;
	}

	@Override
	public List<Sorcier> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Sorcier> sorciers = em.createQuery("from Sorcier").getResultList();
		em.close();
		return sorciers;
	}

	@Override
	public Sorcier save(Sorcier sorcier) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();

		sorcier = em.merge(sorcier);

		em.getTransaction().commit();
		em.close();
		return sorcier;
	}

	@Override
	public void deleteById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Sorcier sorcier = em.find(Sorcier.class, id);
		em.getTransaction().begin();

		em.remove(sorcier);

		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void delete(Sorcier sorcier) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		sorcier = em.merge(sorcier);
		em.getTransaction().begin();
		em.remove(sorcier);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Professeur> findAllProfesseur() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Professeur> professeurs = em.createQuery("from Professeur").getResultList();
		em.close();
		return professeurs;
	}

}
