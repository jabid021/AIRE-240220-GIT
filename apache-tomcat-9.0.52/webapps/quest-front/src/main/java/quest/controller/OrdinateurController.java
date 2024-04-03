package quest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOOrdinateur;
import dao.DAOStagiaire;
import model.Ordinateur;
import model.Stagiaire;

@WebServlet("/ordinateur")
public class OrdinateurController extends HttpServlet {

	private DAOOrdinateur daoOrdinateur = new DAOOrdinateur();
	private DAOStagiaire daoStagiaire = new DAOStagiaire();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//findAll	
		if(request.getParameter("id")==null) 
		{
			List<Ordinateur> ordinateurs = daoOrdinateur.findAll();
			List<Stagiaire> stagiaires = daoStagiaire.findAll();
			request.setAttribute("ordinateurs", ordinateurs);
			request.setAttribute("stagiaires", stagiaires);
			
			request.getRequestDispatcher("/WEB-INF/ordinateurs.jsp").forward(request, response);
		}
		else 
		{
			//findById pour aller vers la page de modif
			if(request.getParameter("delete")==null) 
			{
				Integer id = Integer.parseInt(request.getParameter("id"));

				Ordinateur ordinateur = daoOrdinateur.findById(id);
				List<Stagiaire> stagiaires = daoStagiaire.findAll();
				
				request.setAttribute("ordinateur", ordinateur);
				request.setAttribute("stagiaires", stagiaires);

				request.getRequestDispatcher("/WEB-INF/updateOrdinateur.jsp").forward(request, response);
			}
			//delete
			else 
			{
				Integer id = Integer.parseInt(request.getParameter("id"));
				daoOrdinateur.delete(id);
				response.sendRedirect("ordinateur");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//insert
		if(request.getParameter("id")==null) 
		{
			String marque = request.getParameter("marque");
			Integer ram = Integer.parseInt(request.getParameter("ram"));
			Integer idStagiaire = Integer.parseInt(request.getParameter("stagiaire.id"));
			Stagiaire stagiaire = daoStagiaire.findById(idStagiaire);
			
			Ordinateur ordinateur = new Ordinateur(marque,ram,stagiaire);
			
			daoOrdinateur.insert(ordinateur);
			response.sendRedirect("ordinateur");
		}
		//update
		else 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));
			String marque = request.getParameter("marque");
			Integer ram = Integer.parseInt(request.getParameter("ram"));
			Integer idStagiaire = Integer.parseInt(request.getParameter("stagiaire.id"));
			Stagiaire stagiaire = daoStagiaire.findById(idStagiaire);
			
			Ordinateur ordinateur = new Ordinateur(id,marque,ram,stagiaire);
			
			
			daoOrdinateur.update(ordinateur);
			response.sendRedirect("ordinateur");
		}
	}

}
