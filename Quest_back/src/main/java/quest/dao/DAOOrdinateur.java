package quest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import quest.model.Ordinateur;

@Repository
@Transactional
public class DAOOrdinateur implements IDAOOrdinateur {

	@PersistenceContext
	private EntityManager em;
	@Override
	public Ordinateur findById(Integer id) {
		Ordinateur ordinateur = em.find(Ordinateur.class, id);
		return ordinateur;
	}

	@Override
	public List<Ordinateur> findAll() {
		List<Ordinateur> ordinateurs = em.createQuery("from Ordinateur").getResultList();
		return ordinateurs;
	}

	@Override
	public Ordinateur save(Ordinateur ordinateur) {
		ordinateur = em.merge(ordinateur);
		return ordinateur;
	}

	@Override
	public void deleteById(Integer id) {
		Ordinateur ordinateur = em.find(Ordinateur.class, id);
		em.remove(ordinateur);
	}

	@Override
	public void delete(Ordinateur ordinateur) {
		ordinateur = em.merge(ordinateur);
		em.remove(ordinateur);
	}

	@Override
	public Ordinateur findByStagiaire(Integer idStagiaire) {
		Ordinateur ordinateur = null;
		try {
		ordinateur = (Ordinateur) em.createQuery("SELECT o from Ordinateur o where o.stagiaire.id=:id").setParameter("id", idStagiaire).getSingleResult();
		}
		catch(Exception e) {e.printStackTrace();}
		return ordinateur;
	}


	
	

}
