package quest.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import quest.model.Matiere;
import quest.service.MatiereService;

@Controller
@RequestMapping("/demo")
public class Demo1 
{

	@Autowired
	MatiereService matiereSrv;
	
	
	@GetMapping
	@ResponseBody
	public String demo() 
	{
		return "Ceci est du JSON";
	}
	
	@GetMapping("/matiere/{id}")
	@ResponseBody
	public List<Matiere> afficheMatiere(@RequestParam String login, @PathVariable Integer id) 
	{
		System.out.println(login);
		System.out.println(id);
		return matiereSrv.getAll();
	}
	
	
}
