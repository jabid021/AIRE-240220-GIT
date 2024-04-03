package quest.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFiliere;
import model.Filiere;

@WebServlet("/filiere")
public class FiliereController extends HttpServlet {

	private DAOFiliere daoFiliere = new DAOFiliere();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//findAll			
		if(request.getParameter("id")==null) 
		{
			List<Filiere> filieres = daoFiliere.findAll();
			request.setAttribute("filieres", filieres);
			
			request.getRequestDispatcher("/WEB-INF/filieres.jsp").forward(request, response);
		}
		else 
		{
			//findById pour aller vers la page de modif
			if(request.getParameter("delete")==null) 
			{
				Integer id = Integer.parseInt(request.getParameter("id"));

				Filiere filiere = daoFiliere.findById(id);
				
				request.setAttribute("filiere", filiere);

				request.getRequestDispatcher("/WEB-INF/updateFiliere.jsp").forward(request, response);
			}
			//delete
			else 
			{
				Integer id = Integer.parseInt(request.getParameter("id"));
				daoFiliere.delete(id);
				response.sendRedirect("filiere");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//insert
		if(request.getParameter("id")==null) 
		{
			String libelle = request.getParameter("libelle");
			LocalDate debut = LocalDate.parse(request.getParameter("debut"));
			LocalDate fin = LocalDate.parse(request.getParameter("fin"));
			
			Filiere filiere  = new Filiere(libelle,debut,fin);
			daoFiliere.insert(filiere);
			response.sendRedirect("filiere");
		}
		//update
		else 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));
			String libelle = request.getParameter("libelle");
			LocalDate debut = LocalDate.parse(request.getParameter("debut"));
			LocalDate fin = LocalDate.parse(request.getParameter("fin"));
			
			Filiere filiere  = new Filiere(id,libelle,debut,fin);
			
			daoFiliere.update(filiere);
			response.sendRedirect("filiere");
		}
	}

}
