package quest.dao;

import java.util.List;

import javax.persistence.EntityManager;

import quest.context.Singleton;
import quest.model.Compte;
import quest.model.Formateur;
import quest.model.Stagiaire;

public class DAOCompte implements IDAOCompte {

	@Override
	public Compte findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Compte compte = em.find(Compte.class, id);
		em.close();
		return compte;
	}

	@Override
	public List<Compte> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Compte> comptes = em.createQuery("from Compte").getResultList();
		em.close();
		return comptes;
	}

	@Override
	public Compte save(Compte compte) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();

		compte = em.merge(compte);

		em.getTransaction().commit();
		em.close();
		return compte;
	}

	@Override
	public void deleteById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Compte compte = em.find(Compte.class, id);
		em.getTransaction().begin();

		em.remove(compte);

		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void delete(Compte compte) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		compte = em.merge(compte);
		em.getTransaction().begin();
		em.remove(compte);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Compte findByEmailAndPassword(String email, String password) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Compte compte = null;
		try {
		compte = (Compte) em.createQuery("SELECT c from Compte c where c.email=:email and c.password=:password").setParameter("email", email).setParameter("password",password).getSingleResult();
		}
		catch(Exception e) {e.printStackTrace();}
		em.close();
		return compte;
	}

	@Override
	public List<Formateur> findAllFormateur() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Formateur> comptes = em.createQuery("from Formateur").getResultList();
		em.close();
		return comptes;
	}

	@Override
	public List<Stagiaire> findAllStagaire() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Stagiaire> comptes = em.createQuery("from Stagiaire").getResultList();
		em.close();
		return comptes;
	}

	

	
	

}
