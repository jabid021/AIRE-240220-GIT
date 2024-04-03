package quest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFiliere;
import dao.DAOStagiaire;
import model.Filiere;
import model.Stagiaire;

@WebServlet("/stagiaire")
public class StagiaireController extends HttpServlet {

	private DAOStagiaire daoStagiaire = new DAOStagiaire();
	private DAOFiliere daoFiliere = new DAOFiliere();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//findAll	
		if(request.getParameter("id")==null) 
		{
			List<Stagiaire> stagiaires = daoStagiaire.findAll();
			List<Filiere> filieres = daoFiliere.findAll();
			request.setAttribute("stagiaires", stagiaires);
			request.setAttribute("filieres", filieres);
			
			request.getRequestDispatcher("/WEB-INF/stagiaires.jsp").forward(request, response);
		}
		else 
		{
			//findById pour aller vers la page de modif
			if(request.getParameter("delete")==null) 
			{
				Integer id = Integer.parseInt(request.getParameter("id"));

				Stagiaire stagiaire = daoStagiaire.findById(id);
				List<Filiere> filieres = daoFiliere.findAll();
				
				request.setAttribute("stagiaire", stagiaire);
				request.setAttribute("filieres", filieres);

				request.getRequestDispatcher("/WEB-INF/updateStagiaire.jsp").forward(request, response);
			}
			//delete
			else 
			{
				Integer id = Integer.parseInt(request.getParameter("id"));
				daoStagiaire.delete(id);
				response.sendRedirect("stagiaire");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//insert
		if(request.getParameter("id")==null) 
		{
			String prenom = request.getParameter("prenom");
			String nom = request.getParameter("nom");
			String email = request.getParameter("email");
			Integer idFiliere = Integer.parseInt(request.getParameter("filiere.id"));
			Filiere filiere = daoFiliere.findById(idFiliere);
			
			Stagiaire stagiaire = new Stagiaire(nom, prenom, email, filiere);
			
			daoStagiaire.insert(stagiaire);
			response.sendRedirect("stagiaire");
		}
		//update
		else 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));
			String prenom = request.getParameter("prenom");
			String nom = request.getParameter("nom");
			String email = request.getParameter("email");
			Integer idFiliere = Integer.parseInt(request.getParameter("filiere.id"));
			Filiere filiere = daoFiliere.findById(idFiliere);
			
			Stagiaire stagiaire = new Stagiaire(id,nom, prenom, email, filiere);
			
			
			daoStagiaire.update(stagiaire);
			response.sendRedirect("stagiaire");
		}
	}

}
