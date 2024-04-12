package eshop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	
	@RequestMapping(path={"/home",""}, method = RequestMethod.GET)
	public String home() 
	{
		return "/WEB-INF/home.jsp";
	}
	
	@RequestMapping(path="/home", method = RequestMethod.POST)
	public String connect(@RequestParam String login,String password, Model model,HttpSession session) 
	{
		model.addAttribute("role","admin");
		session.setAttribute("login", login);
		return "/WEB-INF/menu.jsp";
	}
}
