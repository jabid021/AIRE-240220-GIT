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

import quest.dao.IDAOCompte;
import quest.dao.IDAOFiliere;
import quest.dao.IDAOMatiere;
import quest.dao.IDAOModule;
import quest.model.Filiere;
import quest.model.Formateur;
import quest.model.Matiere;
import quest.model.Module;

@WebServlet("/module")
public class ModuleController extends HttpServlet {

	@Autowired
	IDAOModule daoModule;
	@Autowired
	IDAOCompte daoCompte;
	@Autowired
	IDAOFiliere daoFiliere;
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
			Integer idFiliere = Integer.parseInt(request.getParameter("filiere"));
			Filiere filiere = daoFiliere.findById(idFiliere).get();
			List<Module> modules = daoModule.findAllByFiliere(idFiliere);
			List<Matiere> matieres = daoMatiere.findAll();
			List<Formateur> formateurs = daoCompte.findAllFormateur();
			
			
			request.setAttribute("modules", modules);
			request.setAttribute("filiere", filiere);
			request.setAttribute("matieres", matieres);
			request.setAttribute("formateurs", formateurs);
			request.getRequestDispatcher("/WEB-INF/filiere-modules.jsp").forward(request, response);
		}
		else 
		{

			if(request.getParameter("delete")!=null) 
			{
				//delete
				Integer idFiliere = Integer.parseInt(request.getParameter("filiere"));
				Integer id = Integer.parseInt(request.getParameter("id"));
				daoModule.deleteById(id);
				response.sendRedirect("module?filiere="+idFiliere);	
			}	
			else 
			{
				//findById	
				Integer id = Integer.parseInt(request.getParameter("id"));
				Module module = daoModule.findById(id).get();
				List<Matiere> matieres = daoMatiere.findAll();
				List<Formateur> formateurs = daoCompte.findAllFormateur();
				
				request.setAttribute("matieres", matieres);
				request.setAttribute("formateurs", formateurs);
				
				request.setAttribute("module", module);
				request.getRequestDispatcher("/WEB-INF/update-module.jsp").forward(request, response);
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("id")==null) 
		{
			//insert
			LocalDate debut = LocalDate.parse(request.getParameter("debut"));
			LocalDate fin = LocalDate.parse(request.getParameter("fin"));
			int quest = Integer.parseInt(request.getParameter("quest"));
			Integer idFiliere = Integer.parseInt(request.getParameter("filiere.id"));
			Integer idMatiere = Integer.parseInt(request.getParameter("matiere.id"));
			
			Formateur formateur;
			if(request.getParameter("formateur.id").isBlank()) {formateur=null;}
			else {
				Integer IdFormateur = Integer.parseInt(request.getParameter("formateur.id"));
				formateur=(Formateur) daoCompte.findById(IdFormateur).get();
			}
			Filiere filiere = daoFiliere.findById(idFiliere).get();
			Matiere matiere = daoMatiere.findById(idMatiere).get();
			
			Module module = new Module(debut,fin,quest,filiere,matiere,formateur);
			
			
			daoModule.save(module);

			response.sendRedirect("module?filiere="+idFiliere);

		}

		else 
		{
			//update
			Integer id = Integer.parseInt(request.getParameter("id"));
			LocalDate debut = LocalDate.parse(request.getParameter("debut"));
			LocalDate fin = LocalDate.parse(request.getParameter("fin"));
			int quest = Integer.parseInt(request.getParameter("quest"));
			Integer idFiliere = Integer.parseInt(request.getParameter("filiere.id"));
			Integer idMatiere = Integer.parseInt(request.getParameter("matiere.id"));
			
			Formateur formateur;
			if(request.getParameter("formateur.id").isBlank()) {formateur=null;}
			else {
				Integer IdFormateur = Integer.parseInt(request.getParameter("formateur.id"));
				formateur=(Formateur) daoCompte.findById(IdFormateur).get();
			}
			Filiere filiere = daoFiliere.findById(idFiliere).get();
			Matiere matiere = daoMatiere.findById(idMatiere).get();
			
			Module module = new Module(id,debut,fin,quest,filiere,matiere,formateur);
			
			
			daoModule.save(module);

			response.sendRedirect("module?filiere="+idFiliere);

		}

	}
}
