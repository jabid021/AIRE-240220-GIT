package quest.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import quest.dao.IDAOFiliere;
import quest.model.Filiere;



@WebServlet("/filiere")
public class FiliereController  extends HttpServlet {

	@Autowired
	IDAOFiliere daoFiliere;
	
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("id")==null) 
		{
			//findAll
			List<Filiere> filieres = daoFiliere.findAll();
			request.setAttribute("filieres", filieres);
			request.getRequestDispatcher("/WEB-INF/filieres.jsp").forward(request, response);
		}
		else 
		{

			if(request.getParameter("delete")!=null) 
			{
				//delete
				Integer id = Integer.parseInt(request.getParameter("id"));
				daoFiliere.deleteById(id);
				response.sendRedirect("filiere");	
			}	
			else 
			{
				//findById	
				Integer id = Integer.parseInt(request.getParameter("id"));
				Filiere filiere = daoFiliere.findById(id).get();
				request.setAttribute("filiere", filiere);
				request.getRequestDispatcher("/WEB-INF/update-filiere.jsp").forward(request, response);
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
			daoFiliere.save(filiere);

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

			daoFiliere.save(filiere);
			response.sendRedirect("filiere");
		}

	}
}
