package controller.session;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import model.cart.ShoppingCart;


@WebListener
public class SessionInit implements HttpSessionListener {

	/**
	 * Sesja trwa 2 tygodnie nieaktywności na stronie.
	 */
	public void sessionCreated(HttpSessionEvent se)  { 
        se.getSession().setAttribute("shoppingCard", new ShoppingCart());
        System.out.println("init sesja");
        //se.getSession().setMaxInactiveInterval(3600 * 24 * 14); 
   }

   public void sessionDestroyed(HttpSessionEvent se)  { 
        //System.out.println("Zamykam sesje");
   }
	
}
