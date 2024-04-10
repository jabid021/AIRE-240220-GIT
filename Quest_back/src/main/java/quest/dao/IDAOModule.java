package quest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import quest.model.Module;

public interface IDAOModule extends JpaRepository<Module,Integer>{
	
	@Query("SELECT m from Module m where m.filiere.id=:id")
	public List<Module> findAllByFiliere(@Param("id") Integer idFiliere);
	
	@Query("SELECT m from Module m where m.formateur.id=:id")
	public List<Module> findAllByFormateur(@Param("id") Integer idFormateur);
}
