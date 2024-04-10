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
import quest.dao.IDAOFiliere;
import quest.model.Adresse;
import quest.model.Filiere;
import quest.model.Stagiaire;

@WebServlet("/stagiaire")
public class StagiaireController extends HttpServlet {

	@Autowired
	IDAOCompte daoCompte;

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
			List<Stagiaire> stagiaires = daoCompte.findAllStagaire();

			request.setAttribute("stagiaires", stagiaires);
			request.setAttribute("filieres", filieres);
			request.getRequestDispatcher("/WEB-INF/stagiaires.jsp").forward(request, response);
		}
		else 
		{

			if(request.getParameter("delete")!=null) 
			{
				//delete
				Integer id = Integer.parseInt(request.getParameter("id"));
				daoCompte.deleteById(id);
				response.sendRedirect("stagiaire");	
			}	
			else 
			{
				//findById	
				Integer id = Integer.parseInt(request.getParameter("id"));
				List<Filiere> filieres =daoFiliere.findAll();
				Stagiaire stagiaire = (Stagiaire) daoCompte.findById(id).get();
				
				request.setAttribute("stagiaire", stagiaire);
				request.setAttribute("filieres", filieres);
				request.getRequestDispatcher("/WEB-INF/update-stagiaire.jsp").forward(request, response);
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("id")==null) 
		{
			//insert


			String mailSt= request.getParameter("email");
			String passwordSt = request.getParameter("password");
			String nomSt= request.getParameter("nom");
			String prenomSt= request.getParameter("prenom");
			String numeroSt= request.getParameter("adresse.numero");
			String voieSt= request.getParameter("adresse.voie");
			String villeSt= request.getParameter("adresse.ville");
			String cpST= request.getParameter("adresse.cp");
			
			Stagiaire stagiaire;
			Filiere filiere;

			Integer idFiliere = Integer.parseInt(request.getParameter("filiere.id"));
			filiere = daoFiliere.findById(idFiliere).get();

			Adresse adresse=new Adresse(numeroSt,voieSt,villeSt,cpST);
			stagiaire = new Stagiaire(mailSt,passwordSt,nomSt,prenomSt,adresse,filiere);
			daoCompte.save(stagiaire);

			response.sendRedirect("stagiaire");

		}

		else 
		{
			//update
			Integer id = Integer.parseInt(request.getParameter("id"));
			String mailSt= request.getParameter("email");
			String passwordSt = request.getParameter("password");
			String nomSt= request.getParameter("nom");
			String prenomSt= request.getParameter("prenom");
			String numeroSt= request.getParameter("adresse.numero");
			String voieSt= request.getParameter("adresse.voie");
			String villeSt= request.getParameter("adresse.ville");
			String cpST= request.getParameter("adresse.cp");
			
			Stagiaire stagiaire;
			Filiere filiere;

			Integer idFiliere = Integer.parseInt(request.getParameter("filiere.id"));
			filiere = daoFiliere.findById(idFiliere).get();

			Adresse adresse=new Adresse(numeroSt,voieSt,villeSt,cpST);
			stagiaire = new Stagiaire(id,mailSt,passwordSt,nomSt,prenomSt,adresse,filiere);
			daoCompte.save(stagiaire);

			response.sendRedirect("stagiaire");
		}

	}
}
