package quest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import quest.model.Compte;
import quest.model.Formateur;
import quest.model.Stagiaire;

public interface IDAOCompte extends JpaRepository<Compte,Integer> {

	//@Query("SELECT c from Compte c where c.email=:email and c.password=:password")
	//public Compte findByEmailAndPassword(@Param("email") String email, @Param("password")String password);
	
	public Compte findByEmailAndPassword(String email, String password);
	
	@Query("from Formateur")
	public List<Formateur> findAllFormateur();
	
	@Query("from Stagiaire")
	public List<Stagiaire> findAllStagaire();
}
