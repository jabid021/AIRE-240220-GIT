package eshop.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import eshop.dao.IDAOPersonne;
import eshop.model.Fournisseur;
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
<<<<<<< Updated upstream
		model.addAttribute("produit",new Produit());
		return "produits/produits";
=======
		return "produits/produits2";
>>>>>>> Stashed changes
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
	public String ajoutProduit(@Valid @ModelAttribute Produit produit,BindingResult result,Model model
			//@RequestParam String libelle, double prix, @RequestParam("fournisseur.id") Integer idFournisseur
			) 
	{
		if(result.hasErrors()) 
		{
			model.addAttribute("produits",produitSrv.getAll());
			model.addAttribute("fournisseurs",daoPersonne.findAllFournisseur());
			return "produits/produits";
		}
		produitSrv.insert(produit);
		return "redirect:/produit";
	}


	@PostMapping("/{id}")
	public String modifierProduit(@Valid @ModelAttribute Produit produit,BindingResult result, Model model) 
	{
		if(result.hasErrors()) 
		{
			model.addAttribute("fournisseurs",daoPersonne.findAllFournisseur());
			return "produits/updateProduit";
		}
		produitSrv.update(produit);
		return "redirect:/produit";
	}

	@GetMapping("/delete/{id}")
	public String supprimerProduit(@PathVariable Integer id) 
	{
		produitSrv.deleteById(id);
		return "redirect:/produit";
	}



}
