package eshop.controller;

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

import eshop.dao.IDAOPersonne;
import eshop.model.Fournisseur;
import eshop.model.Produit;
import eshop.service.ProduitService;

@WebServlet("/produit")
public class ProduitController extends HttpServlet {


	@Autowired
	ProduitService produitService;
	
	@Autowired
	IDAOPersonne daoPersonne;

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



	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("id")==null) 
		{
			//findAll
			List<Produit> produits = produitService.getAll();
			List<Fournisseur> fournisseurs = daoPersonne.findAllFournisseur();
			request.setAttribute("fournisseurs", fournisseurs);
			request.setAttribute("produits", produits);
			request.getRequestDispatcher("/WEB-INF/produits.jsp").forward(request, response);
		}
		else 
		{
			if(request.getParameter("delete")==null) 
			{
				//findById
				List<Fournisseur> fournisseurs = daoPersonne.findAllFournisseur();
				request.setAttribute("fournisseurs", fournisseurs);
				
				Integer id = Integer.parseInt(request.getParameter("id"));
				Produit p = produitService.getById(id);
				request.setAttribute("produit", p);
				
				request.getRequestDispatcher("/WEB-INF/updateProduit.jsp").forward(request, response);
			}
			else 
			{
				//delete	
				Integer id = Integer.parseInt(request.getParameter("id"));
				produitService.deleteById(id);
				response.sendRedirect("produit");
			}
		}






	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("id")==null) 
		{
			//insert
			String libelle = request.getParameter("libelle");
			double prix = Double.parseDouble(request.getParameter("prix"));
			Integer idFournisseur = Integer.parseInt(request.getParameter("fournisseur.id"));
			Fournisseur fournisseur = (Fournisseur) daoPersonne.findById(idFournisseur).get();
			Produit produit = new Produit(libelle,prix,fournisseur);


			produit =produitService.insert(produit);

			response.sendRedirect("produit");
		}

		else 
		{
			//update	
			Integer id = Integer.parseInt(request.getParameter("id"));
			Integer idFournisseur = Integer.parseInt(request.getParameter("fournisseur.id"));
			String libelle = request.getParameter("libelle");
			double prix = Double.parseDouble(request.getParameter("prix"));

			Fournisseur fournisseur = (Fournisseur) daoPersonne.findById(idFournisseur).get();
			Produit produit = new Produit(id,libelle,prix,fournisseur);


			produit =produitService.insert(produit);

			response.sendRedirect("produit");
		}

	}

}
