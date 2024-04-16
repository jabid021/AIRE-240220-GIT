package eshop.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eshop.model.Produit;

@RestController
@RequestMapping("/api/demo")
public class DemoRestController {
	
	@GetMapping("/{nb}")
	public String demo(@RequestParam String login, @PathVariable int nb) 
	{
		return "Requête avec les valeurs "+nb+" et "+login;
	}
	
	@GetMapping
	public Produit produit() 
	{
		return new Produit();
	}
	
	
	@PostMapping
	public void insertProduit(@RequestBody Produit produit) 
	{
		System.out.println(produit);
	}


}
