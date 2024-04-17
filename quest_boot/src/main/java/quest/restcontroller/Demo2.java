package quest.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import quest.model.Filiere;
import quest.model.Matiere;
import quest.service.FiliereService;
import quest.service.MatiereService;

@RestController
@RequestMapping("/demo2")
public class Demo2 
{

	@Autowired
	MatiereService matiereSrv;
	
	@Autowired
	FiliereService filiereSrv;
	
	
	
	@GetMapping
	public String demo() 
	{
		return "Ceci est du JSON";
	}
	
	@GetMapping("/matiere/{id}")
	public List<Matiere> afficheMatiere(@RequestParam String login, @PathVariable Integer id) 
	{
		System.out.println(login);
		System.out.println(id);
		return matiereSrv.getAll();
	}
	
	
	@GetMapping("/filieres")
	public List<Filiere> filieres()
	{
		return filiereSrv.getAll();
	}
}
