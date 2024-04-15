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

import quest.model.Marque;
import quest.model.Ordinateur;
import quest.model.Stagiaire;
import quest.service.OrdinateurService;
import quest.service.StagiaireService;



@Controller
@RequestMapping("/ordinateur")
public class OrdinateurController {

	@Autowired
	OrdinateurService ordinateurSrv;

	@Autowired
	StagiaireService stagiaireSrv;

	@GetMapping
	public String allOrdinateurs(Model model) 
	{
		List<Ordinateur> ordinateurs = ordinateurSrv.getAll();
		model.addAttribute("ordinateurs",ordinateurs);
		model.addAttribute("ordinateur",new Ordinateur());
		model.addAttribute("marques", Marque.values());
		
		List<Stagiaire> stagiaires = stagiaireSrv.getAll();
	
		model.addAttribute("stagiaires",stagiaires);
		
		
		return "ordinateurs/ordinateurs";
	}

	@GetMapping("/{id}")
	public String ficheOrdinateur(@PathVariable("id") Integer idOrdinateur,Model model) 
	{
		Ordinateur ordinateur = ordinateurSrv.getById(idOrdinateur);
		model.addAttribute("ordinateur",ordinateur);
		
		List<Stagiaire> stagiaires= stagiaireSrv.getAll();

		model.addAttribute("stagiaires",stagiaires);
		
		return "ordinateurs/update-ordinateur";
	}

	//En Ajoutant @Valid, notre controller peut verifier si l'objet recu (ici la ordinateur) respecte 
	//l'ensemble des validators coté back, si ce n'est pas le cas, le controlleur va interrompre le traitement
	//et afficher que l'objet n'est pas complet /valide ( La requête envoyée par le client était syntaxiquement incorrecte.)


	//Si on veut recup les erreurs de validation, on doit utiliser BindingResult
	@PostMapping
	public String ajoutOrdinateur(@Valid @ModelAttribute Ordinateur ordinateur, BindingResult result,Model model) 
	{
		if(result.hasErrors()) 
		{
			List<Ordinateur> ordinateurs = ordinateurSrv.getAll();
			model.addAttribute("ordinateurs",ordinateurs);
			
			List<Stagiaire> stagiaires= stagiaireSrv.getAll();
			model.addAttribute("stagiaires",stagiaires);
			
			return "ordinateurs/ordinateurs";
		}
		else 
		{
			ordinateurSrv.insert(ordinateur);
			return "redirect:/ordinateur";
		}	
	}

	@PostMapping("/{id}")
	public String modifierOrdinateur(@Valid @ModelAttribute Ordinateur ordinateur,BindingResult result,Model model) 
	{
		if(result.hasErrors()) 
		{
			List<Ordinateur> ordinateurs = ordinateurSrv.getAll();
			model.addAttribute("ordinateurs",ordinateurs);
			
			
			List<Stagiaire> stagiaires= stagiaireSrv.getAll();
			model.addAttribute("stagiaires",stagiaires);
			
			return "ordinateurs/update-ordinateur";
		}
		else {
			ordinateurSrv.update(ordinateur);
			return "redirect:/ordinateur";
		}
	}

	@GetMapping("/delete/{id}")
	public String supprimerOrdinateur(@PathVariable Integer id) 
	{
		ordinateurSrv.deleteById(id);
		return "redirect:/ordinateur";
	}
}
