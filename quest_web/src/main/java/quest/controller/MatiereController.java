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

import quest.model.Matiere;
import quest.service.MatiereService;

@Controller
@RequestMapping("/matiere")
public class MatiereController {

	@Autowired
	MatiereService matiereSrv;
	
	
	@GetMapping
	public String allMatieres(Model model) 
	{
		List<Matiere> matieres = matiereSrv.getAll();
		model.addAttribute("matieres",matieres);
		model.addAttribute("matiere",new Matiere());
		return "matieres/matieres";
	}
	
	@GetMapping("/{id}")
	public String ficheMatiere(@PathVariable("id") Integer idMatiere,Model model) 
	{
		Matiere matiere = matiereSrv.getById(idMatiere);
		model.addAttribute("matiere",matiere);
		return "matieres/update-matiere";
	}
	
	//En Ajoutant @Valid, notre controller peut verifier si l'objet recu (ici la matiere) respecte 
	//l'ensemble des validators coté back, si ce n'est pas le cas, le controlleur va interrompre le traitement
	//et afficher que l'objet n'est pas complet /valide ( La requête envoyée par le client était syntaxiquement incorrecte.)
	
	
	//Si on veut recup les erreurs de validation, on doit utiliser BindingResult
	@PostMapping
	public String ajoutMatiere(@Valid @ModelAttribute Matiere matiere, BindingResult result,Model model) 
	{
		if(result.hasErrors()) 
		{
			List<Matiere> matieres = matiereSrv.getAll();
			model.addAttribute("matieres",matieres);
			return "matieres/matieres";
		}
		else 
		{
			matiereSrv.insert(matiere);
			return "redirect:/matiere";
		}	
	}
	
	@PostMapping("/{id}")
	public String modifierMatiere(@Valid @ModelAttribute Matiere matiere,BindingResult result,Model model) 
	{
		if(result.hasErrors()) 
		{
			List<Matiere> matieres = matiereSrv.getAll();
			model.addAttribute("matieres",matieres);
			return "matieres/update-matiere";
		}
		else {
			matiereSrv.update(matiere);
			return "redirect:/matiere";
		}
	}
	
	@GetMapping("/delete/{id}")
	public String supprimerMatiere(@PathVariable Integer id) 
	{
		matiereSrv.deleteById(id);
		return "redirect:/matiere";
	}
}
