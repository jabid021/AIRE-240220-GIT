package quest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quest.context.Singleton;
import quest.model.Adresse;
import quest.model.Filiere;
import quest.model.Stagiaire;

@WebServlet("/stagiaire")
public class StagiaireController extends HttpServlet {




	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("id")==null) 
		{
			//findAll
			List<Filiere> filieres = Singleton.getInstance().getDaoFiliere().findAll();
			List<Stagiaire> stagiaires = Singleton.getInstance().getDaoCompte().findAllStagaire();


			request.setAttribute("stagiaires", stagiaires);
			request.setAttribute("filieres", filieres);
			request.getRequestDispatcher("/stagiaires.jsp").forward(request, response);
		}
		else 
		{

			if(request.getParameter("delete")!=null) 
			{
				//delete
				Integer id = Integer.parseInt(request.getParameter("id"));
				Singleton.getInstance().getDaoCompte().deleteById(id);
				response.sendRedirect("stagiaire");	
			}	
			else 
			{
				//findById	
				Integer id = Integer.parseInt(request.getParameter("id"));
				//Ordinateur ordinateur = Singleton.getInstance().getDaoOrdinateur().findById(id);
				List<Stagiaire> stagiaires = Singleton.getInstance().getDaoCompte().findAllStagaire();

				//request.setAttribute("ordinateur", ordinateur);
				//request.setAttribute("marques", Marque.values());
				request.setAttribute("stagiaires", stagiaires);
				request.getRequestDispatcher("/update-ordinateur.jsp").forward(request, response);
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
			//Filiere filiereST= request.getParameter("filiere");

			Stagiaire stagiaire;
			Filiere filiere;

			Integer idFiliere = Integer.parseInt(request.getParameter("filiere.id"));
			filiere = (Filiere) Singleton.getInstance().getDaoFiliere().findById(idFiliere);

			Adresse adresse=new Adresse(numeroSt,voieSt,villeSt,cpST);
			stagiaire = new Stagiaire(mailSt,passwordSt,nomSt,prenomSt,adresse,filiere);
			Singleton.getInstance().getDaoCompte().save(stagiaire);

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
			//Filiere filiereST= request.getParameter("filiere");

			Stagiaire stagiaire;
			Filiere filiere;

			Integer idFiliere = Integer.parseInt(request.getParameter("filiere.id"));
			filiere = (Filiere) Singleton.getInstance().getDaoFiliere().findById(idFiliere);

			Adresse adresse=new Adresse(numeroSt,voieSt,villeSt,cpST);
			stagiaire = new Stagiaire(id,mailSt,passwordSt,nomSt,prenomSt,adresse,filiere);
			Singleton.getInstance().getDaoCompte().save(stagiaire);

			response.sendRedirect("stagiaire");
		}

	}
}
