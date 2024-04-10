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

import quest.dao.IDAOMatiere;
import quest.model.Matiere;


@WebServlet("/matiere")
public class MatiereController extends HttpServlet {

	@Autowired
	IDAOMatiere daoMatiere;
	
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("id")==null) 
		{
			//findAll
			List<Matiere> matieres = daoMatiere.findAll();
			request.setAttribute("matieres", matieres);
			request.getRequestDispatcher("/WEB-INF/matieres.jsp").forward(request, response);
		}
		else 
		{

			if(request.getParameter("delete")!=null) 
			{
				//delete
				Integer id = Integer.parseInt(request.getParameter("id"));
				daoMatiere.deleteById(id);
				response.sendRedirect("matiere");	
			}	
			else 
			{
				//findById	
				Integer id = Integer.parseInt(request.getParameter("id"));
				Matiere matiere = daoMatiere.findById(id).get();
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
			daoMatiere.save(matiere);

			response.sendRedirect("matiere");

		}

		else 
		{
			//update
			Integer id = Integer.parseInt(request.getParameter("id"));
			String libelle = request.getParameter("libelle");

			Matiere matiere = new Matiere(id,libelle);

			daoMatiere.save(matiere);
			response.sendRedirect("matiere");
		}

	}
}
