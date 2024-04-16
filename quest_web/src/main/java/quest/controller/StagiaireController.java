package quest.controller;

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

import quest.model.Stagiaire;
import quest.service.FiliereService;
import quest.service.StagiaireService;

@Controller
@RequestMapping("/stagiaire")
public class StagiaireController {
	
	
	@Autowired
	StagiaireService stagiaireSrv;
	@Autowired
	FiliereService filiereSrv;
	

	
	@GetMapping
	public String allStagiaires(Model model) 
	{
		List<Stagiaire> stagiaires = stagiaireSrv.getAll();
		model.addAttribute("filieres", filiereSrv.getAll());
		model.addAttribute("stagiaires",stagiaires);
		model.addAttribute("stagiaire",new Stagiaire());
		return "stagiaires/stagiaires";
	}
	

	@GetMapping("/{id}")
	public String ficheStagiaire(@PathVariable("id") Integer idStagiaire,Model model) 
	{
		Stagiaire stagiaire= stagiaireSrv.getById(idStagiaire);
		model.addAttribute("filieres", filiereSrv.getAll());
		model.addAttribute("stagiaire",stagiaire);
		System.out.println(stagiaire);
		return "stagiaires/update-stagiaire";
	}

	
	@PostMapping
	public String ajoutStagiaire(@Valid @ModelAttribute Stagiaire stagiaire, BindingResult result,Model model) 
	{
		if(result.hasErrors()) 
		{
			List<Stagiaire> stagiaires = stagiaireSrv.getAll();
			model.addAttribute("filieres", filiereSrv.getAll());
			model.addAttribute("stagiaires",stagiaires);
			return "stagiaires/stagiaires";
		}
		else 
		{
			stagiaireSrv.insert(stagiaire);
			return "redirect:/stagiaire";
		}	
	}
	
	@PostMapping("/{id}")
	public String modifierStagiaire(@Valid @ModelAttribute Stagiaire stagiaire,BindingResult result,Model model) 
	{
		if(result.hasErrors()) 
		{
			List<Stagiaire> stagiaires = stagiaireSrv.getAll();
			model.addAttribute("stagiaires",stagiaires);
			model.addAttribute("filieres",filiereSrv.getAll());
			return "stagiaires/update-stagiaire";
		}
		else {
			stagiaireSrv.update(stagiaire);
			return "redirect:/stagiaire";
		}
	}
	
	@GetMapping("/delete/{id}")
	public String supprimerStagiaire(@PathVariable Integer id) 
	{
		stagiaireSrv.deleteById(id);
		return "redirect:/stagiaire";
	}
}
