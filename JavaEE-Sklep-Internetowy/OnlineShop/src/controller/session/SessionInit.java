package controller.session;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import model.cart.ShoppingCart;


@WebListener
public class SessionInit implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent se)  { 
        //System.out.println("Tworze sesje");
        se.getSession().setAttribute("shoppingCard", new ShoppingCart());
        se.getSession().setMaxInactiveInterval(3600 * 24 * 14);
   }

   public void sessionDestroyed(HttpSessionEvent se)  { 
        //System.out.println("Zamykam sesje");
   }
	
}
