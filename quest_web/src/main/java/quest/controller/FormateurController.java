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

import quest.model.Formateur;
import quest.service.FormateurService;

@Controller
@RequestMapping("/formateur")
public class FormateurController{

	@Autowired
	FormateurService formateurSrv;
		
	@GetMapping
	public String allFormateurs(Model model) 
	{
		model.addAttribute("formateurs",formateurSrv.getAll());
		model.addAttribute("formateur",new Formateur());
		return "formateurs/formateurs";
	}
	
	@GetMapping("/{id}")
	public String ficheFormateur(@PathVariable("id") Integer id,Model model) {
		model.addAttribute("formateur",formateurSrv.getById(id));
		return "formateurs/update-formateur";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteFormateur(@PathVariable("id") Integer id) {
		formateurSrv.deleteById(id);
		return "redirect:/formateur";
	}
	
	@GetMapping("/jumeau/{id}")
	public String replaceFormateur(@PathVariable("id") Integer id) {
		formateurSrv.updateJumeau(id);
		return "redirect:/formateur";
	}
	
	@PostMapping
	public String ajoutFormateur(@Valid @ModelAttribute Formateur formateur, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("formateur",formateur);
			return "formateurs/update-formateur";
		}
		formateurSrv.insert(formateur);
		return "redirect:/formateur";
	}
	
	@PostMapping("/{id}")
	public String modifFormateur(@Valid @ModelAttribute Formateur formateur, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("formateur",formateur);
			return "formateurs/update-formateur";
		}
		formateurSrv.update(formateur);
		return "redirect:/formateur";
	}
		
	
}
