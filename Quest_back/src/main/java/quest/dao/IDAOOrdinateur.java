package quest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import quest.model.Ordinateur;

public interface IDAOOrdinateur extends JpaRepository<Ordinateur,Integer>{
	
	@Query("SELECT o from Ordinateur o where o.stagiaire.id=:id")
	public Ordinateur findByStagiaire(@Param("id") Integer idStagiaire);

}
