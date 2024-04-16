package quest.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import quest.model.Ordinateur;
import quest.service.OrdinateurService;
import quest.view.Views;

@RestController
@RequestMapping("/api/ordinateur")
@CrossOrigin("*")
public class OrdinateurRestController {

	@Autowired 
	OrdinateurService ordinateurSrv;

	@GetMapping
	@JsonView(Views.Ordinateur.class)
	public List<Ordinateur> allOrdinateurs() 
	{
		return ordinateurSrv.getAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.Ordinateur.class)
	public Ordinateur ficheOrdinateur(@PathVariable Integer id) 
	{
		return ordinateurSrv.getById(id);
	}

	
	@PostMapping
	public Ordinateur ajoutOrdinateur(@Valid @RequestBody Ordinateur ordinateur, BindingResult result) 
	{
		if(result.hasErrors()) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le ordinateur n'est pas valide");
		}
		return ordinateurSrv.insert(ordinateur);
	}
	
	@PutMapping("/{id}")
	public Ordinateur modifierOrdinateur(@PathVariable Integer id,@RequestBody Ordinateur ordinateur) 
	{
		ordinateur.setId(id);
		return ordinateurSrv.update(ordinateur);
	}
	
	
	@DeleteMapping("/{id}")
	public void supprimerOrdinateur(@PathVariable Integer id) 
	{
		ordinateurSrv.deleteById(id);
	}
	
}
