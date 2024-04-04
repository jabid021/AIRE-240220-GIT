package eshop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eshop.context.Singleton;
import eshop.model.Fournisseur;
import eshop.model.Produit;

@WebServlet("/produit")
public class ProduitController extends HttpServlet {
	
	//findById => remplir le formulaire d'update
	//findAll => afficher le tableau
	//insert => pour insert les données de votre formulaire d'ajout
	//update => pour update les données de votre formulaire d'update
	//delete => pour le btn delete sur le tableau
	
	
	//doGet
		//findAll (si pas d'id)
			//(si id)
		//findById
		//	(si id + delete)
		//delete
	
	//doPost
		//insert (si pas d'id)
		//update(si id)
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		if(request.getParameter("id")==null) 
		{
			//findAll
		}
		else 
		{
			if(request.getParameter("delete")==null) 
			{
				//findById
				Integer id = Integer.parseInt(request.getParameter("id"));
				Produit p = Singleton.getInstance().getDaoProduit().findById(id);
				request.setAttribute("prod", p);
				request.getRequestDispatcher("/fiche-produit.jsp").forward(request, response);
			}
			else 
			{
				//delete		
			}
		}
		
		
		
		
	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("id")==null) 
		{
			//insert
			String libelle = request.getParameter("libelle");
			double prix = Double.parseDouble(request.getParameter("prix"));
			
			Fournisseur fournisseur = (Fournisseur) Singleton.getInstance().getDaoPersonne().findById(3);
			Produit produit = new Produit(libelle,prix,fournisseur);
			
			
			produit = Singleton.getInstance().getDaoProduit().save(produit);
			
			response.sendRedirect("produit?id="+produit.getId());
		}
		
		else 
		{
			//update	
		}
		
	}

}
