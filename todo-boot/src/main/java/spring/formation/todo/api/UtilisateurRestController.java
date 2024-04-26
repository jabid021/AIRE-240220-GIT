package spring.formation.todo.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import spring.formation.todo.model.Utilisateur;
import spring.formation.todo.model.Views;
import spring.formation.todo.repository.UtilisateurRepository;

@RestController
@RequestMapping("/api/utilisateur")
@CrossOrigin("*")
public class UtilisateurRestController {

	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@GetMapping("")
	@JsonView(Views.ViewUtilisateur.class)
	public List<Utilisateur> findAll() {
		return this.utilisateurRepository.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewUtilisateur.class)
	public Utilisateur findById(@PathVariable("id") Long id) {
		Optional<Utilisateur> optUtilisateur = this.utilisateurRepository.findById(id);

		if (optUtilisateur.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id Utilisateur inexistant");
		}

		return optUtilisateur.get();
	}
	
	@GetMapping("/{id}/detail")
	@JsonView(Views.ViewUtilisateurDetail.class)
	public Utilisateur findDetailById(@PathVariable("id") Long id) {
		Optional<Utilisateur> optUtilisateur = this.utilisateurRepository.findById(id);

		if (optUtilisateur.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id Utilisateur inexistant");
		}

		return optUtilisateur.get();
	}

	@PostMapping("")
	@JsonView(Views.ViewUtilisateur.class)
	public Utilisateur create(@RequestBody Utilisateur utilisateur) {
		return this.utilisateurRepository.save(utilisateur);
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewUtilisateur.class)
	public Utilisateur update(@RequestBody Utilisateur utilisateur, @PathVariable("id") Long id) {
		if (id != utilisateur.getId() || !this.utilisateurRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id Utilisateur inexistant");
		}

		return this.utilisateurRepository.save(utilisateur);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		if (!this.utilisateurRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id Utilisateur inexistant");
		}

		this.utilisateurRepository.deleteById(id);
	}

}
