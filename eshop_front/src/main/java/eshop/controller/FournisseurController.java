package eshop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eshop.context.Singleton;
import eshop.model.Adresse;
import eshop.model.Fournisseur;
import eshop.model.Personne;

//La servlet doit etre disponible à l'url : /fournisseur
@WebServlet("/fournisseur")
public class FournisseurController extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("id")==null) 
		{
			//findAll
		}
		else 
		{
			
			if(request.getParameter("delete")!=null) 
			{
				//delete	
			}
			else 
			{
				//findById
				Integer id = Integer.parseInt(request.getParameter("id"));
				Personne f = Singleton.getInstance().getDaoPersonne().findById(id);
				request.setAttribute("fournisseur", f);
				request.getRequestDispatcher("/fiche-fournisseur.jsp").forward(request, response);		
			}
		}
		
		
		
		
	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("id")==null) 
		{
			//insert
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String numero=request.getParameter("adresse.numero");;
			String voie=request.getParameter("adresse.voie");;
			String ville=request.getParameter("adresse.ville");;
			String cp=request.getParameter("adresse.cp");;
			String societe=request.getParameter("societe");;
			
			
			Personne p = new Fournisseur(nom,prenom,new Adresse(numero,voie,ville,cp),societe);
			p= Singleton.getInstance().getDaoPersonne().save(p);
			response.sendRedirect("fournisseur?id="+p.getId());
		}
		
		else 
		{
			//update
		}
		
	}

}
