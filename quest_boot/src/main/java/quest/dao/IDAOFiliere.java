package quest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import quest.model.Filiere;

public interface IDAOFiliere extends JpaRepository<Filiere,Integer> {

	@Query("select f from Filiere f join fetch f.inscrits where f.id=:id")
	public Filiere findByIdWithStagiaires(@Param("id") Integer idFiliere);
}
