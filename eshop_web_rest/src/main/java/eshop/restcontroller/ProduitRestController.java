package eshop.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
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

import eshop.model.Produit;
import eshop.service.ProduitService;
import eshop.view.Views;

@RestController
@RequestMapping("/api/produit")
@CrossOrigin("*")
public class ProduitRestController {

	@Autowired 
	ProduitService produitSrv;

	@GetMapping
	@JsonView(Views.Produit.class)
	public List<Produit> allProduits() 
	{
		return produitSrv.getAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.Produit.class)
	public Produit ficheProduit(@PathVariable Integer id) 
	{
		return produitSrv.getById(id);
	}

	@GetMapping("/ventes/{id}")
	@JsonView(Views.ProduitWithVentes.class)
	public Produit ficheProduitWithVentes(@PathVariable Integer id) 
	{
		return produitSrv.getByIdAvecVentes(id);
	}
	
	@PostMapping
	public Produit ajoutProduit(@Valid @RequestBody Produit produit, BindingResult result) 
	{
		if(result.hasErrors()) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le produit n'est pas valide");
		}
		return produitSrv.insert(produit);
	}
	
	@PutMapping("/{id}")
	public Produit modifierProduit(@PathVariable Integer id,@RequestBody Produit produit) 
	{
		produit.setId(id);
		return produitSrv.update(produit);
	}
	
	
	@DeleteMapping("/{id}")
	public void supprimerProduit(@PathVariable Integer id) 
	{
		produitSrv.deleteById(id);
	}
	
}
