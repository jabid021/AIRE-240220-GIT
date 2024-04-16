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

import quest.model.Stagiaire;
import quest.service.StagiaireService;

@RestController
@RequestMapping("/api/stagiaire")
@CrossOrigin("*")
public class StagiaireRestController {

	@Autowired 
	StagiaireService stagiaireSrv;

	@GetMapping
	public List<Stagiaire> allStagiaires() 
	{
		return stagiaireSrv.getAll();
	}
	
	@GetMapping("/{id}")
	public Stagiaire ficheStagiaire(@PathVariable Integer id) 
	{
		return stagiaireSrv.getById(id);
	}

	
	@PostMapping
	public Stagiaire ajoutStagiaire(@Valid @RequestBody Stagiaire stagiaire, BindingResult result) 
	{
		if(result.hasErrors()) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le stagiaire n'est pas valide");
		}
		return stagiaireSrv.insert(stagiaire);
	}
	
	@PutMapping("/{id}")
	public Stagiaire modifierStagiaire(@PathVariable Integer id,@RequestBody Stagiaire stagiaire) 
	{
		stagiaire.setId(id);
		return stagiaireSrv.update(stagiaire);
	}
	

	@PatchMapping("/{id}")
	public Stagiaire modifierPartiellementStagiaire(@PathVariable Integer id,@RequestBody Stagiaire stagiaire) 
	{
		stagiaire.setId(id);
		return stagiaireSrv.updatePartiel(stagiaire);
	}
	
	@DeleteMapping("/{id}")
	public void supprimerStagiaire(@PathVariable Integer id) 
	{
		stagiaireSrv.deleteById(id);
	}
	
}
