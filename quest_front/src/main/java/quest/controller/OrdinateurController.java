package quest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import quest.dao.IDAOCompte;
import quest.dao.IDAOOrdinateur;
import quest.model.Marque;
import quest.model.Ordinateur;
import quest.model.Stagiaire;


@WebServlet("/ordinateur")
public class OrdinateurController extends HttpServlet {
	@Autowired
	IDAOOrdinateur daoOrdinateur;
	@Autowired
	IDAOCompte daoCompte;
	
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("id")==null) 
		{
			//findAll
			List<Ordinateur> ordinateurs = daoOrdinateur.findAll();
			List<Stagiaire> stagiaires = daoCompte.findAllStagaire();
			
			
			request.setAttribute("marques", Marque.values());
			request.setAttribute("stagiaires", stagiaires);
			request.setAttribute("ordinateurs", ordinateurs);
			request.getRequestDispatcher("/WEB-INF/ordinateurs.jsp").forward(request, response);
		}
		else 
		{
			
			if(request.getParameter("delete")!=null) 
			{
				//delete
				Integer id = Integer.parseInt(request.getParameter("id"));
				daoOrdinateur.deleteById(id);
				response.sendRedirect("ordinateur");	
			}	
			else 
			{
				//findById	
				Integer id = Integer.parseInt(request.getParameter("id"));
				Ordinateur ordinateur = daoOrdinateur.findById(id).get();
				List<Stagiaire> stagiaires = daoCompte.findAllStagaire();
				
				request.setAttribute("ordinateur", ordinateur);
				request.setAttribute("marques", Marque.values());
				request.setAttribute("stagiaires", stagiaires);
				request.getRequestDispatcher("/WEB-INF/update-ordinateur.jsp").forward(request, response);
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("id")==null) 
		{
			//insert
			int ram = Integer.parseInt(request.getParameter("ram"));
			String choixMarque = request.getParameter("marque");
			
			Stagiaire stagiaire;
			if(request.getParameter("stagiaire.id").equals("")) 
			{
				stagiaire=null;	
			}
			else 
			{
				Integer idStagiaire = Integer.parseInt(request.getParameter("stagiaire.id"));
				stagiaire = (Stagiaire) daoCompte.findById(idStagiaire).get();
			}
			
			Ordinateur ordinateur = new Ordinateur(ram,Marque.valueOf(choixMarque),stagiaire);
			daoOrdinateur.save(ordinateur);
			
			response.sendRedirect("ordinateur");
			
		}
		
		else 
		{
			//update
			Integer id = Integer.parseInt(request.getParameter("id"));
			int ram = Integer.parseInt(request.getParameter("ram"));
			String choixMarque = request.getParameter("marque");
			
			Stagiaire stagiaire;
			if(request.getParameter("stagiaire.id").equals("")) 
			{
				stagiaire=null;	
			}
			else 
			{
				Integer idStagiaire = Integer.parseInt(request.getParameter("stagiaire.id"));
				stagiaire = (Stagiaire) daoCompte.findById(idStagiaire).get();
			}
			
			
			Ordinateur ordinateur = new Ordinateur(id,ram,Marque.valueOf(choixMarque),stagiaire);
			daoOrdinateur.save(ordinateur);
			response.sendRedirect("ordinateur");
		}
		
	}
}
