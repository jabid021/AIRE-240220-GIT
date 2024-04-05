package quest.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quest.context.Singleton;
import quest.model.Compte;


@WebServlet("/home")
public class HomeController extends HttpServlet {



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("disconnect")!=null) 
		{
			request.getSession().invalidate();
		}
		request.getRequestDispatcher("/home.jsp").forward(request, response);
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Compte compte = Singleton.getInstance().getDaoCompte().findByEmailAndPassword(email, password);
		if(compte == null) 
		{
			request.setAttribute("error", "Identifiants invalides");
			request.getRequestDispatcher("/home.jsp").forward(request, response);
		}
		else 
		{
			request.getSession().setAttribute("compte", compte);
			
			request.getRequestDispatcher("/index.html").forward(request, response);
		}

	}

}
