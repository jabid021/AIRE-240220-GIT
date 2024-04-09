package quest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import quest.model.Module;

@Repository
@Transactional

public class DAOModule implements IDAOModule {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Module findById(Integer id) {
		Module module = em.find(Module.class, id);
		return module;
	}

	@Override
	public List<Module> findAll() {
		List<Module> modules = em.createQuery("from Module").getResultList();
		return modules;
	}

	@Override
	public Module save(Module module) {
		module = em.merge(module);
		return module;
	}

	@Override
	public void deleteById(Integer id) {
		Module module = em.find(Module.class, id);
		em.remove(module);
	}

	@Override
	public void delete(Module module) {
		module = em.merge(module);
		em.remove(module);
	}

	@Override
	public List<Module> findAllByFiliere(Integer idFiliere) {
		List<Module> modules = em.createQuery("SELECT m from Module m where m.filiere.id=:id").setParameter("id", idFiliere).getResultList();
		return modules;
	}

	@Override
	public List<Module> findAllByFormateur(Integer idFormateur) {
		List<Module> modules = em.createQuery("SELECT m from Module m where m.formateur.id=:id").setParameter("id", idFormateur).getResultList();
		return modules;
	}

}
