package dao;

import javax.persistence.EntityManager;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

import utilities.DBConfig;


@WebListener
public class InitDB implements ServletRequestListener {


    public void requestDestroyed(ServletRequestEvent sre)  { 
         // TODO Auto-generated method stub
    }

    public void requestInitialized(ServletRequestEvent sre)  { 
    	EntityManager manager = DBConfig.createEntityManager();
    	UserDAO userDAO = new UserDAO(manager);
    	SaleDAO saleDAO = new SaleDAO(manager);
    	PhoneDAO phoneDAO = new PhoneDAO(manager);
    	UsertypeDAO usertypeDAO = new UsertypeDAO(manager);
    	AddressDAO addressDAO = new AddressDAO(manager);
    	
    	ServletRequest request = sre.getServletRequest();
    	request.setAttribute("userDAO", userDAO);
    	request.setAttribute("saleDAO", saleDAO);
    	request.setAttribute("PhoneDAO", phoneDAO);
    	request.setAttribute("UsertypeDAO", usertypeDAO);
    	request.setAttribute("AddressDAO", addressDAO);
    }
	
}
