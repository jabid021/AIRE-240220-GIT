package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import eshop.model.Client;
import eshop.model.Fournisseur;
import eshop.model.Personne;

@Repository
@Transactional
public class DAOPersonne implements IDAOPersonne {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Personne findById(Integer id) {
		Personne personne = em.find(Personne.class, id);
		return personne;
	}

	@Override
	public List<Personne> findAll() {
		List<Personne> personnes = em.createQuery("from Personne").getResultList();
		return personnes;
	}

	@Override
	public Personne save(Personne personne) {
		personne = em.merge(personne);
		return personne;
	}

	@Override
	public void deleteById(Integer id) {
		Personne personne = em.find(Personne.class, id);
		em.remove(personne);
	}

	@Override
	public void delete(Personne personne) {
		personne = em.merge(personne);
		em.remove(personne);
	}

	@Override
	public List<Fournisseur> findAllFournisseur() {
		List<Fournisseur> fournisseurs = em.createQuery("from Fournisseur").getResultList();
		return fournisseurs;
	}

	@Override
	public List<Client> findAllClient() {
		List<Client> clients = em.createQuery("from Client").getResultList();
		return clients;
	}

	@Override
	public Client findByIdWithAchats(Integer idClient) {
		Query requete = em.createQuery("SELECT c from Client c LEFT JOIN FETCH  c.achats  where  c.id=:id");
		requete.setParameter("id", idClient);
		Client client = (Client) requete.getSingleResult();
		return client;
	}

	@Override
	public Fournisseur findByIdWithStock(Integer idFournisseur) {
		Fournisseur fournisseur = (Fournisseur) em.createQuery("SELECT f from Fournisseur f LEFT JOIN FETCH f.stock where f.id=:id").setParameter("id", idFournisseur).getSingleResult();
		return fournisseur;
	}


	

}
