package quest.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DemoController {
	
	@RequestMapping(path = "/demo", method = RequestMethod.GET)
	public String demo(Integer test) 
	{				
		System.out.println(test);
		return "/WEB-INF/demo.jsp";
	}
	

	@RequestMapping(path = "/demo",method = RequestMethod.POST)
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
