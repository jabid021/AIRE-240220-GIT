package quest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import quest.model.Matiere;

@Repository
@Transactional
public class DAOMatiere implements IDAOMatiere {

	@PersistenceContext
	private EntityManager em;
	@Override
	public Matiere findById(Integer id) {
		Matiere matiere = em.find(Matiere.class, id);
		return matiere;
	}

	@Override
	public List<Matiere> findAll() {
		List<Matiere> matieres = em.createQuery("from Matiere").getResultList();
		return matieres;
	}

	@Override
	public Matiere save(Matiere matiere) {
		matiere = em.merge(matiere);
		return matiere;
	}

	@Override
	public void deleteById(Integer id) {
		Matiere matiere = em.find(Matiere.class, id);
		em.remove(matiere);
	}

	@Override
	public void delete(Matiere matiere) {
		matiere = em.merge(matiere);
		em.remove(matiere);
	}

	

	
	

}
