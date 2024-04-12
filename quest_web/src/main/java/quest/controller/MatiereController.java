package quest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
		return "matieres/matieres";
	}
	
	@GetMapping("/{id}")
	public String ficheMatiere(@PathVariable("id") Integer idMatiere,Model model) 
	{
		Matiere matiere = matiereSrv.getById(idMatiere);
		model.addAttribute("matiere",matiere);
		return "matieres/update-matiere";
	}
	
	@PostMapping
	public String ajoutMatiere(String libelle) 
	{
		Matiere matiere = new Matiere(libelle);
		matiereSrv.insert(matiere);
		
		return "redirect:/matiere";
	}
	
	@PostMapping("/{id}")
	public String modifierMatiere(@PathVariable Integer id, String libelle) 
	{
		Matiere matiere = new Matiere(id,libelle);
		matiereSrv.update(matiere);
		
		return "redirect:/matiere";
	}
	
	@GetMapping("/delete/{id}")
	public String supprimerMatiere(@PathVariable Integer id) 
	{
		matiereSrv.deleteById(id);
		return "redirect:/matiere";
	}
}
