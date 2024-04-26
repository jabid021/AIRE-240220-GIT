package spring.formation.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.formation.todo.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{

}
