package quest.controller;

import java.time.LocalDate;
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

import quest.model.Filiere;
import quest.model.Matiere;
import quest.service.FiliereService;
import quest.service.MatiereService;

@Controller
@RequestMapping("/filiere")
public class FiliereController {

	@Autowired
	FiliereService filiereSrv;

	@GetMapping
	public String allFilieres(Model model) 
	{
		List<Filiere> filieres = filiereSrv.getAll();
		model.addAttribute("filieres",filieres);
		model.addAttribute("filiere",new Filiere());
		return "filieres/filieres";
	}


	@GetMapping("/{id}")
	public String ficheFiliere(@PathVariable("id") Integer idFilere,Model model) 
	{
		Filiere filiere = filiereSrv.getById(idFilere);
		model.addAttribute("filiere",filiere);
		return "filieres/update-filiere";
	}

	@PostMapping
	public String ajoutFiliere(@Valid @ModelAttribute Filiere filiere, BindingResult result,Model model) 
	{
		if(result.hasErrors()) 
		{
			List<Filiere> filieres = filiereSrv.getAll();
			model.addAttribute("filieres",filieres);
			return "filieres/filieres";
		}
		else 
		{
			filiereSrv.insert( filiere);
			return "redirect:/filiere";
		}	
	}

	@PostMapping("/{id}")
	public String modifierFiliere(@Valid @ModelAttribute Filiere filiere,BindingResult result,Model model) 
	{
		if(result.hasErrors()) 
		{
			List<Filiere> filieres = filiereSrv.getAll();
			model.addAttribute("filieres",filieres);
			return "filieres/update-filiere";
		}
		else {
			filiereSrv.update(filiere);
			return "redirect:/filiere";
		}
	}

	@GetMapping("/delete/{id}")
	public String supprimerFiliere(@PathVariable Integer id) 
	{
		filiereSrv.deleteById(id);
		return "redirect:/filiere";
	}

}
