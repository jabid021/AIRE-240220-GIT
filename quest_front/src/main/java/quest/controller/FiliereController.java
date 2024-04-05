package quest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

import quest.context.Singleton;
import quest.model.Filiere;
import quest.model.Matiere;



@WebServlet("/filiere")
public class FiliereController  extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("id")==null) 
		{
			//findAll
			List<Filiere> filieres = Singleton.getInstance().getDaoFiliere().findAll();
			request.setAttribute("filieres", filieres);
			request.getRequestDispatcher("/filieres.jsp").forward(request, response);
		}
		else 
		{

			if(request.getParameter("delete")!=null) 
			{
				//delete
				Integer id = Integer.parseInt(request.getParameter("id"));
				Singleton.getInstance().getDaoFiliere().deleteById(id);
				response.sendRedirect("filiere");	
			}	
			else 
			{
				//findById	
				Integer id = Integer.parseInt(request.getParameter("id"));
				Filiere filiere = Singleton.getInstance().getDaoFiliere().findById(id);
				request.setAttribute("filiere", filiere);
				request.getRequestDispatcher("/update-filiere.jsp").forward(request, response);
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("id")==null) 
		{
			//insert
			
			String libelle = request.getParameter("libelle");
			
			String datevar = request.getParameter("debut");
			LocalDate debut = LocalDate.parse(datevar);
			
			datevar = request.getParameter("fin");
			LocalDate fin = LocalDate.parse(datevar);

			Filiere filiere = new Filiere(libelle,debut, fin);
			Singleton.getInstance().getDaoFiliere().save(filiere);

			response.sendRedirect("filiere");

		}

		else 
		{
			//update
			Integer id = Integer.parseInt(request.getParameter("id"));
			String libelle = request.getParameter("libelle");
			String datevar = request.getParameter("debut");
			LocalDate debut = LocalDate.parse(datevar);
			
			datevar = request.getParameter("fin");
			LocalDate fin = LocalDate.parse(datevar);

			Filiere filiere = new Filiere(id,libelle,debut,fin);

			Singleton.getInstance().getDaoFiliere().save(filiere);
			response.sendRedirect("filiere");
		}

	}
}
