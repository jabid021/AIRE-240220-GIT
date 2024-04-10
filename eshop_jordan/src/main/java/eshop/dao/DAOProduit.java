package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import eshop.model.Produit;


@Repository
@Transactional
public class DAOProduit implements IDAOProduit {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Produit findById(Integer id) {
		Produit produit = em.find(Produit.class, id);
		return produit;
	}

	@Override
	public List<Produit> findAll() {
		List<Produit> produits = em.createQuery("from Produit").getResultList();
		return produits;
	}

	@Override
	public Produit save(Produit produit) {
		produit = em.merge(produit);
		return produit;
	}

	@Override
	public void deleteById(Integer id) {
		Produit produit = em.find(Produit.class, id);
		em.remove(produit);
	}

	@Override
	public void delete(Produit produit) {
		produit = em.merge(produit);
		em.remove(produit);
	}

	@Override
	public List<Produit> findByLib(String libelle) {
		List<Produit> produits = em.createQuery("SELECT p from Produit p where p.libelle=:lib").setParameter("lib",libelle).getResultList();
		return produits;
	}

	@Override
	public Produit findByIdWithVentes(Integer idProduit) {
		Produit produit = (Produit) em.createQuery("SELECT p from Produit p LEFT JOIN FETCH p.ventes where p.id=:id").setParameter("id", idProduit).getSingleResult();
		return produit;
	}

	

}
