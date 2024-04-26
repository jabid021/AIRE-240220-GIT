package spring.formation.todo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import spring.formation.todo.model.Todo;
import spring.formation.todo.model.Utilisateur;
import spring.formation.todo.repository.TodoRepository;
import spring.formation.todo.repository.UtilisateurRepository;

@SpringBootTest
class TodoBootApplicationTests {
	
	@Autowired
	private TodoRepository todoRepository;
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@Test
	void contextLoads() {
		Utilisateur hana = new Utilisateur("AZID", "Hana", "hazid", "123456", false);
		Utilisateur hedieh = new Utilisateur("BARDOU", "Hedieh", "hbardou", "123456", false);
		Utilisateur marieAntoine = new Utilisateur("SAMY", "Marie Antoine", "msamy", "123456", true);
		Utilisateur eric = new Utilisateur("SULTAN", "Eric", "esultan", "123456", false);
		
		hana = utilisateurRepository.save(hana);
		hedieh = utilisateurRepository.save(hedieh);
		marieAntoine = utilisateurRepository.save(marieAntoine);
		eric = utilisateurRepository.save(eric);
		
		Todo todo1 = new Todo("Faire le repassage", false);
		todo1.setUser(hana);
		Todo todo2 = new Todo("Passer la tondeuse", true);
		todo2.setUser(hana);
		Todo todo3 = new Todo("Aspirer", true);
		todo3.setUser(marieAntoine);
		
		todo1 = todoRepository.save(todo1);
		todo2 = todoRepository.save(todo2);
		todo3 = todoRepository.save(todo3);
	}

}
