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
import quest.dao.IDAOModule;
import quest.model.Formateur;
import quest.model.Module;

@WebServlet("/formateur")
public class FormateurController extends HttpServlet {

	@Autowired
	IDAOCompte daoCompte;
	@Autowired
	IDAOModule daoModule;
	
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("id")==null) 
		{
			//findAll
			List<Formateur> formateurs = daoCompte.findAllFormateur();
			request.setAttribute("formateurs", formateurs);
			request.getRequestDispatcher("/WEB-INF/formateurs.jsp").forward(request, response);
		}
		else 
		{
			if(request.getParameter("jumeau")!=null)
			{
				//alternate update
				Integer id = Integer.parseInt(request.getParameter("id"));
				Formateur formateur = (Formateur) daoCompte.findById(id).get();
				formateur.setPrenom(inverserVoyelles(formateur.getPrenom()));
				formateur.setNom(inverserVoyelles(formateur.getNom()));

				daoCompte.save(formateur);

				response.sendRedirect("formateur");
			}
			else if(request.getParameter("delete")!=null) 
			{
				//delete
				Integer id = Integer.parseInt(request.getParameter("id"));
				daoCompte.deleteById(id);
				response.sendRedirect("formateur");	
			}
			else if(request.getParameter("module")!=null) {
				Integer id = Integer.parseInt(request.getParameter("id"));
				Formateur formateur = (Formateur) daoCompte.findById(id).get();
				List<Module> modules = daoModule.findAllByFormateur(formateur.getId());
				request.setAttribute("formateur", formateur);
				request.setAttribute("modules", modules);
				request.getRequestDispatcher("/WEB-INF/formateur-module.jsp").forward(request, response);
			}
			else 
			{
				//findById	
				Integer id = Integer.parseInt(request.getParameter("id"));
				Formateur formateur = (Formateur) daoCompte.findById(id).get();
				request.setAttribute("formateur", formateur);
				request.getRequestDispatcher("/update-formateur.jsp").forward(request, response);
			}
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("id")==null && request.getParameter("jumeau")==null) 
		{
			//insert
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String prenom = request.getParameter("prenom");
			String nom = request.getParameter("nom");
			double tarif = Float.valueOf(request.getParameter("tarif"));

			Formateur formateur = new Formateur(email,password,prenom,nom,tarif);
			daoCompte.save(formateur);

			response.sendRedirect("formateur");

		}
		else 
		{
			//update
			Integer id = Integer.parseInt(request.getParameter("id"));
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String prenom = request.getParameter("prenom");
			String nom = request.getParameter("nom");
			double tarif = Float.valueOf(request.getParameter("tarif"));

			Formateur formateur = new Formateur(id,email,password,prenom,nom,tarif);
			daoCompte.save(formateur);

			response.sendRedirect("formateur");
		}

	}
	
	protected static String inverserVoyelles(String mot) {
        char[] voyelles = {'a', 'e', 'i', 'o', 'u', 'y', 'A', 'E', 'I', 'O', 'U', 'Y'};
        StringBuilder resultat = new StringBuilder(mot);
        int debut = 0;
        int fin = mot.length() - 1;

        while (debut < fin) {
            while (debut < fin && !estVoyelle(mot.charAt(debut), voyelles)) {
                debut++;
            }
            while (debut < fin && !estVoyelle(mot.charAt(fin), voyelles)) {
                fin--;
            }

            if (debut < fin) {
                char temp = resultat.charAt(debut);
                resultat.setCharAt(debut, resultat.charAt(fin));
                resultat.setCharAt(fin, temp);
                debut++;
                fin--;
            }
        }
        return resultat.toString();
    }

    protected static boolean estVoyelle(char c, char[] voyelles) {
        for (char voyelle : voyelles) {
            if (c == voyelle) {
                return true;
            }
        }
        return false;
    }
}
