package quest.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * Application Lifecycle Listener implementation class RequestListener
 *
 */
public class RequestListener implements ServletRequestListener {

 
    public void requestDestroyed(ServletRequestEvent sre)  { 
         // TODO Auto-generated method stub
    }

	
    public void requestInitialized(ServletRequestEvent sre)  { 
       try {
    	sre.getServletRequest().setCharacterEncoding("UTF-8");
       }catch(Exception e) {};
    }
	
}
