package quest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import quest.model.Compte;
import quest.model.Formateur;
import quest.model.Stagiaire;

@Repository
@Transactional
public class DAOCompte implements IDAOCompte {

	@PersistenceContext
	private EntityManager em;
	@Override
	public Compte findById(Integer id) {
		Compte compte = em.find(Compte.class, id);
		return compte;
	}

	@Override
	public List<Compte> findAll() {
		List<Compte> comptes = em.createQuery("from Compte").getResultList();
		return comptes;
	}

	@Override
	public Compte save(Compte compte) {
		compte = em.merge(compte);
		return compte;
	}

	@Override
	public void deleteById(Integer id) {
		Compte compte = em.find(Compte.class, id);
		em.remove(compte);
	}

	@Override
	public void delete(Compte compte) {
		compte = em.merge(compte);
		em.remove(compte);
		}

	@Override
	public Compte findByEmailAndPassword(String email, String password) {
		Compte compte = null;
		try {
		compte = (Compte) em.createQuery("SELECT c from Compte c where c.email=:email and c.password=:password").setParameter("email", email).setParameter("password",password).getSingleResult();
		}
		catch(Exception e) {e.printStackTrace();}
	
		return compte;
	}

	@Override
	public List<Formateur> findAllFormateur() {
		List<Formateur> comptes = em.createQuery("from Formateur").getResultList();
		return comptes;
	}

	@Override
	public List<Stagiaire> findAllStagaire() {
		
		List<Stagiaire> comptes = em.createQuery("from Stagiaire").getResultList();
		return comptes;
	}

	

	
	

}
