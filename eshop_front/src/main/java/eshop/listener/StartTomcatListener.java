package eshop.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import eshop.context.Singleton;


public class StartTomcatListener implements ServletContextListener {

	

    public void contextInitialized(ServletContextEvent sce)  { 
    	
    	//Cette fonction se lance toute seule quand Tomcat start
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
    	
    	Singleton.getInstance();
    	
    	
    }
	
	
    public void contextDestroyed(ServletContextEvent sce)  { 
    	//Cette fonction se lance toute seule quand Tomcat stop
    	Singleton.getInstance().getEmf().close();
    }

	
	
}
