package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import eshop.model.Achat;

@Repository
@Transactional
public class DAOAchat implements IDAOAchat {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Achat findById(Integer id) {
		Achat achat = em.find(Achat.class, id);
		return achat;
	}

	@Override
	public List<Achat> findAll() {
		List<Achat> achats = em.createQuery("from Achat").getResultList();
		return achats;
	}

	@Override
	public Achat save(Achat achat) {
		achat = em.merge(achat);
		return achat;
	}

	@Override
	public void deleteById(Integer id) {
		Achat achat = em.find(Achat.class, id);
		em.remove(achat);
	}

	@Override
	public void delete(Achat achat) {
		achat = em.merge(achat);
		em.remove(achat);
	}



}
