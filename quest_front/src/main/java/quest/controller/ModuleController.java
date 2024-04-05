package quest.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quest.context.Singleton;
import quest.model.Filiere;
import quest.model.Formateur;
import quest.model.Matiere;
import quest.model.Module;

@WebServlet("/module")
public class ModuleController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("id")==null) 
		{
			//findAll
			Integer idFiliere = Integer.parseInt(request.getParameter("filiere"));
			Filiere filiere = Singleton.getInstance().getDaoFiliere().findById(idFiliere);
			List<Module> modules = Singleton.getInstance().getDaoModule().findAllByFiliere(idFiliere);
			List<Matiere> matieres = Singleton.getInstance().getDaoMatiere().findAll();
			List<Formateur> formateurs = Singleton.getInstance().getDaoCompte().findAllFormateur();
			
			
			request.setAttribute("modules", modules);
			request.setAttribute("filiere", filiere);
			request.setAttribute("matieres", matieres);
			request.setAttribute("formateurs", formateurs);
			request.getRequestDispatcher("/filiere-modules.jsp").forward(request, response);
		}
		else 
		{

			if(request.getParameter("delete")!=null) 
			{
				//delete
				Integer idFiliere = Integer.parseInt(request.getParameter("filiere"));
				Integer id = Integer.parseInt(request.getParameter("id"));
				Singleton.getInstance().getDaoModule().deleteById(id);
				response.sendRedirect("module?filiere="+idFiliere);	
			}	
			else 
			{
				//findById	
				Integer id = Integer.parseInt(request.getParameter("id"));
				Module module = Singleton.getInstance().getDaoModule().findById(id);
				List<Matiere> matieres = Singleton.getInstance().getDaoMatiere().findAll();
				List<Formateur> formateurs = Singleton.getInstance().getDaoCompte().findAllFormateur();
				
				request.setAttribute("matieres", matieres);
				request.setAttribute("formateurs", formateurs);
				
				request.setAttribute("module", module);
				request.getRequestDispatcher("/update-module.jsp").forward(request, response);
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
				formateur=(Formateur) Singleton.getInstance().getDaoCompte().findById(IdFormateur);
			}
			Filiere filiere = Singleton.getInstance().getDaoFiliere().findById(idFiliere);
			Matiere matiere = Singleton.getInstance().getDaoMatiere().findById(idMatiere);
			
			Module module = new Module(debut,fin,quest,filiere,matiere,formateur);
			
			
			Singleton.getInstance().getDaoModule().save(module);

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
				formateur=(Formateur) Singleton.getInstance().getDaoCompte().findById(IdFormateur);
			}
			Filiere filiere = Singleton.getInstance().getDaoFiliere().findById(idFiliere);
			Matiere matiere = Singleton.getInstance().getDaoMatiere().findById(idMatiere);
			
			Module module = new Module(id,debut,fin,quest,filiere,matiere,formateur);
			
			
			Singleton.getInstance().getDaoModule().save(module);

			response.sendRedirect("module?filiere="+idFiliere);

		}

	}
}
