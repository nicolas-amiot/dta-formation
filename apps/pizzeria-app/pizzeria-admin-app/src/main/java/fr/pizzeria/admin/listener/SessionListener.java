package fr.pizzeria.admin.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {


    public void sessionCreated(HttpSessionEvent se)  {
    	Integer compteur = (Integer) se.getSession().getServletContext().getAttribute("compteur");
    	if(compteur == null){
    		compteur = 0;
    	}
    	se.getSession().getServletContext().setAttribute("compteur", compteur + 1);
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
        
    }
	
}
