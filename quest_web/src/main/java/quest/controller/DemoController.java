package quest.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import quest.dao.IDAOMatiere;

@Controller
@RequestMapping("/demo")
public class DemoController {


	@Autowired
	IDAOMatiere daoMatiere;

	@GetMapping
	public String demo(Integer test) 
	{				
		System.out.println(test);
		System.out.println(daoMatiere.findAll());
		return "/WEB-INF/demo.jsp";
	}

	@GetMapping("/{firstname}")
	public String demoPathVariable(@PathVariable(name = "firstname") String prenom) 
	{				
		System.out.println(prenom);
		return "/WEB-INF/demo.jsp";
	}

	@RequestMapping(method = {RequestMethod.POST,RequestMethod.PUT})
	public String demo2(String prenom,int age,Model model,HttpSession session) 
	{
		System.out.println(prenom);
		System.out.println(age);
		model.addAttribute("monLogin", prenom);
		model.addAttribute("age", age);

		session.setAttribute("connected", "yes");
		if(session.getAttribute("connected").equals("yes")) 
		{
			System.out.println("On est connecté");
		}
		return "/WEB-INF/page2.jsp";
	}

}
