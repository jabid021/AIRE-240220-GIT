package quest.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonView;

import quest.dao.IDAOCompte;
import quest.dao.IDAOFiliere;
import quest.model.Compte;
import quest.model.Filiere;
import quest.model.Formateur;
import quest.model.Matiere;
import quest.model.Module;
import quest.service.MatiereService;
import quest.service.ModuleService;
import quest.view.Views;

@Controller
@RequestMapping("/module")
public class ModuleController {

	@Autowired
	ModuleService moduleSrv;
	
	@Autowired
	IDAOCompte daoCompte;
	
	@Autowired
	IDAOFiliere daoFiliere;
	
	@Autowired
	MatiereService matiereSrv;
	
	@GetMapping("/filiere-{filiere}")
	@JsonView(Views.Module.class)
	public String allModulesByFiliere(@PathVariable("filiere") Integer idFiliere,Model model) 
	{
		List<Module> modules = moduleSrv.getAllByFiliere(idFiliere);
		List<Formateur> formateurs = daoCompte.findAllFormateur();
		List<Matiere> matieres = matiereSrv.getAll();
		
		Filiere filiere = daoFiliere.findById(idFiliere).get();
		model.addAttribute("filiere",filiere);
		model.addAttribute("modules",modules);
		model.addAttribute("formateurs",formateurs);
		model.addAttribute("matieres",matieres);
		return "modules/filiere-modules";
	}
	
	@GetMapping("/formateur-{formateur}")
	@JsonView(Views.Module.class)
	public String allModulesByFormateur(@PathVariable("formateur") Integer idFormateur,Model model) 
	{
		List<Module> modules = moduleSrv.getAllByFormateur(idFormateur);
		Compte formateur = daoCompte.findById(idFormateur).get();
		
		model.addAttribute("modules",modules);
		model.addAttribute("formateur",formateur);
		return "modules/formateur-modules";
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.Module.class)
	public String ficheModule(@PathVariable("id") Integer idModule,Model model) 
	{
		Module module = moduleSrv.getById(idModule);
		List<Formateur> formateurs = daoCompte.findAllFormateur();
		List<Matiere> matieres = matiereSrv.getAll();
		model.addAttribute("module",module);
		model.addAttribute("formateurs",formateurs);
		model.addAttribute("matieres",matieres);
		return "modules/update-module";
	}
	
	@PostMapping
	public String ajoutModule(LocalDate debut,LocalDate fin,int quest,@RequestParam("filiere.id") Integer idFiliere,@RequestParam("matiere.id") Integer idMatiere,@RequestParam(value="formateur.id",required = false) Integer idFormateur ) 
	{
		Formateur formateur = null;
		if(idFormateur!=null) 
		{
			formateur = (Formateur) daoCompte.findById(idFormateur).get();
		}
		Matiere matiere = matiereSrv.getById(idMatiere);
		Filiere filiere = daoFiliere.findById(idFiliere).get();
		
		//J'avais ecrit LocalDate.parse("debut")....
		Module module = new Module(debut,fin,quest,filiere,matiere,formateur);
		moduleSrv.insert(module);
		
		return "redirect:/module/filiere-"+idFiliere;
	}
	
	@PostMapping("/{id}")
	public String modifierModule(@ModelAttribute Module module) 
	{
		moduleSrv.update(module);
		return "redirect:/module/filiere-"+module.getFiliere().getId();
	}
	
	@GetMapping("/delete/{id}")
	public String supprimerModule(@PathVariable Integer id) 
	{
		Module module = moduleSrv.getById(id);
		moduleSrv.deleteById(id);
		return "redirect:/module/filiere-"+module.getFiliere().getId();
	}
}
