package spring.formation.todo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.formation.todo.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
	Optional<Utilisateur> findByLoginAndPassword(String login, String password);
}
