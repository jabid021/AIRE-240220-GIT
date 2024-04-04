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

//La servlet doit etre disponible à l'url : /fournisseur
public class FournisseurController extends HttpServlet {
	

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
		}
		
		else 
		{
			//update
		}
		
	}

}
