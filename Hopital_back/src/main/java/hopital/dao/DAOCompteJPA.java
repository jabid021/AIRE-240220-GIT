package hopital.dao;

import java.util.List;

import javax.persistence.EntityManager;

import hopital.context.Singleton;
import hopital.model.Compte;

public class DAOCompteJPA implements IDAOCompte{

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
	public void delete(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Compte compte = em.find(Compte.class, id);
		em.getTransaction().begin();

		em.remove(compte);

		em.getTransaction().commit();
		em.close();
	}



	@Override
	public Compte findByLoginAndPassword(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Compte obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Compte update(Compte obj) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
