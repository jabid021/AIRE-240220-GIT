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

import spring.formation.todo.model.Liste;
import spring.formation.todo.model.Views;
import spring.formation.todo.repository.ListeRepository;

@RestController
@RequestMapping("/api/liste")
@CrossOrigin("*")
public class ListeRestController {

	@Autowired
	private ListeRepository listeRepository;

	@GetMapping("")
	@JsonView(Views.ViewListe.class)
	public List<Liste> findAll() {
		return this.listeRepository.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewListe.class)
	public Liste findById(@PathVariable("id") Long id) {
		Optional<Liste> optListe = this.listeRepository.findById(id);

		if (optListe.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id Liste inexistant");
		}

		return optListe.get();
	}

	@PostMapping("")
	@JsonView(Views.ViewListe.class)
	public Liste create(@RequestBody Liste liste) {
		return this.listeRepository.save(liste);
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewListe.class)
	public Liste update(@RequestBody Liste liste, @PathVariable("id") Long id) {
		if (id != liste.getId() || !this.listeRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id Liste inexistant");
		}

		return this.listeRepository.save(liste);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		if (!this.listeRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id Liste inexistant");
		}

		this.listeRepository.deleteById(id);
	}

}
