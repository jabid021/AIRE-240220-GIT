package quest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quest.context.Singleton;
import quest.model.Marque;
import quest.model.Matiere;


@WebServlet("/matiere")
public class MatiereController extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("id")==null) 
		{
			//findAll
			List<Matiere> matieres = Singleton.getInstance().getDaoMatiere().findAll();
			request.setAttribute("matieres", matieres);
			request.getRequestDispatcher("/WEB-INF/matieres.jsp").forward(request, response);
		}
		else 
		{

			if(request.getParameter("delete")!=null) 
			{
				//delete
				Integer id = Integer.parseInt(request.getParameter("id"));
				Singleton.getInstance().getDaoMatiere().deleteById(id);
				response.sendRedirect("matiere");	
			}	
			else 
			{
				//findById	
				Integer id = Integer.parseInt(request.getParameter("id"));
				Matiere matiere = Singleton.getInstance().getDaoMatiere().findById(id);
				request.setAttribute("matiere", matiere);
				request.getRequestDispatcher("/WEB-INF/update-matiere.jsp").forward(request, response);
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("id")==null) 
		{
			//insert
			String libelle = request.getParameter("libelle");

			Matiere matiere = new Matiere(libelle);
			Singleton.getInstance().getDaoMatiere().save(matiere);

			response.sendRedirect("matiere");

		}

		else 
		{
			//update
			Integer id = Integer.parseInt(request.getParameter("id"));
			String libelle = request.getParameter("libelle");

			Matiere matiere = new Matiere(id,libelle);

			Singleton.getInstance().getDaoMatiere().save(matiere);
			response.sendRedirect("matiere");
		}

	}
}
