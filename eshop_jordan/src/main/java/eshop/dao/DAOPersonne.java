package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import eshop.context.Singleton;
import eshop.model.Client;
import eshop.model.Fournisseur;
import eshop.model.Personne;

public class DAOPersonne implements IDAOPersonne {

	@Override
	public Personne findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Personne personne = em.find(Personne.class, id);
		em.close();
		return personne;
	}

	@Override
	public List<Personne> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Personne> personnes = em.createQuery("from Personne").getResultList();
		em.close();
		return personnes;
	}

	@Override
	public Personne save(Personne personne) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();

		personne = em.merge(personne);

		em.getTransaction().commit();
		em.close();
		return personne;
	}

	@Override
	public void deleteById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Personne personne = em.find(Personne.class, id);
		em.getTransaction().begin();

		em.remove(personne);

		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void delete(Personne personne) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		personne = em.merge(personne);
		em.getTransaction().begin();
		em.remove(personne);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Fournisseur> findAllFournisseur() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Fournisseur> fournisseurs = em.createQuery("from Fournisseur").getResultList();
		em.close();
		return fournisseurs;
	}

	@Override
	public List<Client> findAllClient() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Client> clients = em.createQuery("from Client").getResultList();
		em.close();
		return clients;
	}

	@Override
	public Client findByIdWithAchats(Integer idClient) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("SELECT c from Client c LEFT JOIN FETCH  c.achats  where  c.id=:id");
		requete.setParameter("id", idClient);
		Client client = (Client) requete.getSingleResult();
		return client;
	}

	@Override
	public Fournisseur findByIdWithStock(Integer idFournisseur) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Fournisseur fournisseur = (Fournisseur) em.createQuery("SELECT f from Fournisseur f LEFT JOIN FETCH f.stock where f.id=:id").setParameter("id", idFournisseur).getSingleResult();
		return fournisseur;
	}


	

}
