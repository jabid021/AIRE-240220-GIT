package quest.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class StartListener implements ServletContextListener {


    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("Tomcat STOP");
    }

	
    public void contextInitialized(ServletContextEvent sce)  { 
       System.out.println("Tomcat START");
    }
	
}
