package eshop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eshop.dao.IDAOPersonne;
import eshop.model.Fournisseur;
import eshop.model.Personne;
import eshop.model.Produit;
import eshop.service.ProduitService;

@Controller
@RequestMapping("/produit")
public class ProduitController {

	@Autowired
	ProduitService produitSrv;
	
	@Autowired
	IDAOPersonne daoPersonne;
	
	
	@GetMapping
	public String allProduits(Model model) 
	{
		List<Produit> produits = produitSrv.getAll();
		List<Fournisseur> fournisseurs = daoPersonne.findAllFournisseur();
		model.addAttribute("produits",produits);
		model.addAttribute("fournisseurs",fournisseurs);
		return "produits/produits";
	}
	
	@GetMapping("/{id}")
	public String ficheProduit(@PathVariable("id") Integer idProduit,Model model) 
	{
		Produit produit = produitSrv.getById(idProduit);
		List<Fournisseur> fournisseurs = daoPersonne.findAllFournisseur();
		model.addAttribute("produit",produit);
		model.addAttribute("fournisseurs",fournisseurs);
		return "produits/updateProduit";
	}
	
	@PostMapping
	public String ajoutProduit(@RequestParam String libelle, double prix, @RequestParam("fournisseur.id") Integer idFournisseur) 
	{
		
		Optional<Personne> opt = daoPersonne.findById(idFournisseur); 
		if(opt.isPresent()) 
		{
			if(opt.get() instanceof Fournisseur) 
			{
				Fournisseur fournisseur = (Fournisseur) opt.get();	
				Produit produit = new Produit(libelle,prix,fournisseur);
				produitSrv.insert(produit);
			}
		}
		return "redirect:/produit";
	}
	
	@PostMapping("/{id}")
	public String modifierProduit(@PathVariable Integer id,  @RequestParam String libelle, double prix, @RequestParam("fournisseur.id") Integer idFournisseur) 
	{
		Optional<Personne> opt = daoPersonne.findById(idFournisseur); 
		if(opt.isPresent()) 
		{
			if(opt.get() instanceof Fournisseur) 
			{
				Fournisseur fournisseur = (Fournisseur) opt.get();	
				Produit produit = new Produit(id,libelle,prix,fournisseur);
				produitSrv.update(produit);
			}
		}
		return "redirect:/produit";
	}
	
	@GetMapping("/delete/{id}")
	public String supprimerProduit(@PathVariable Integer id) 
	{
		produitSrv.deleteById(id);
		return "redirect:/produit";
	}
	
	
	
}
