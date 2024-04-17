package eshop.restcontroller;

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

import eshop.model.Produit;
import eshop.service.ProduitService;

import eshop.view.Views;

@RestController
@RequestMapping("/api/ordinateur")
@CrossOrigin("*")
public class ProduitRestController {

	@Autowired 
	ProduitService produitSrv;

	@GetMapping
	@JsonView(Views.Produit.class)
	public List<Produit> allProduit() 
	{
		return produitSrv.getAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.Produit.class)
	public Produit ficheProduit(@PathVariable Integer id) 
	{
		return produitSrv.getById(id);
	}

	
	@PostMapping
	public Produit ajoutProduit(@Valid @RequestBody Produit ordinateur, BindingResult result) 
	{
		if(result.hasErrors()) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le ordinateur n'est pas valide");
		}
		return produitSrv.insert(ordinateur);
	}
	
	@PutMapping("/{id}")
	public Produit modifierProduit(@PathVariable Integer id,@RequestBody Produit ordinateur) 
	{
		ordinateur.setId(id);
		return produitSrv.update(ordinateur);
	}
	
	
	@DeleteMapping("/{id}")
	public void supprimerOrdinateur(@PathVariable Integer id) 
	{
		produitSrv.deleteById(id);
	}
	
}
