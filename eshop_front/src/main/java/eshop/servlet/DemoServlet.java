package eshop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eshop.context.Singleton;
import eshop.model.Produit;

@WebServlet("/demo.jsp")
public class DemoServlet extends HttpServlet {


 //Gestion des pages web en java : 
	//v1 : on fait du java et on ajoute du html dedans
	//v2 : on fait du html et on ajoute du java dedans
	//v3 : design pattern MVC (Model Vue Controller) => jsp pour afficher .. et servlet pour Controller et faire le pont vers le model
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
	/*	List<Produit> produits = Singleton.getInstance().getDaoProduit().findAll();
		
		response.getWriter().println("<body>");
		response.getWriter().println("<h1>Liste des produits</h1>");
		response.getWriter().println("<table>");
		response.getWriter().println("<tr><th>ID</th><th>Libelle</th><th>Prix</th></tr>");
		for(Produit p : produits) 
		{
			response.getWriter().println("<tr><td>"+p.getId()+"</td><td>"+p.getLibelle()+"</td><td>"+p.getPrix()+"</td></tr>");
		}
		response.getWriter().println("</table>");
		
		response.getWriter().println("</body>");*/
		
		//String login = request.getParameter("login");
		Integer id = Integer.parseInt(request.getParameter("id"));
	
		Produit p = Singleton.getInstance().getDaoProduit().findById(id);
	
		response.getWriter().println("<body>");
		response.getWriter().println("<h1>Fiche du produit "+id+"</h1>");
		response.getWriter().println("<table>");
		response.getWriter().println("<tr><th>ID</th><th>Libelle</th><th>Prix</th></tr>");
		response.getWriter().println("<tr><td>"+p.getId()+"</td><td>"+p.getLibelle()+"</td><td>"+p.getPrix()+"</td></tr>");
		response.getWriter().println("</table>");
		
		response.getWriter().println("</body>");
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}