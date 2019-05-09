package dao;

import javax.persistence.EntityManager;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

import utilities.DBConfig;


@WebListener
public class InitDB implements ServletRequestListener {

	private static UserDAO userDAO;
	private static SaleDAO saleDAO;
	private static PhoneDAO phoneDAO;
	private static UsertypeDAO usertypeDAO;
	private static AddressDAO addressDAO;

	public void requestDestroyed(ServletRequestEvent sre)  { 
         // TODO Auto-generated method stub
    }

    public void requestInitialized(ServletRequestEvent sre)  { 
    	EntityManager manager = DBConfig.createEntityManager();
    	userDAO = new UserDAO(manager);
    	saleDAO = new SaleDAO(manager);
    	phoneDAO = new PhoneDAO(manager);
    	usertypeDAO = new UsertypeDAO(manager);
    	addressDAO = new AddressDAO(manager);
    	
    	ServletRequest request = sre.getServletRequest();
    	request.setAttribute("userDAO", userDAO);
    	request.setAttribute("saleDAO", saleDAO);
    	request.setAttribute("PhoneDAO", phoneDAO);
    	request.setAttribute("UsertypeDAO", usertypeDAO);
    	request.setAttribute("AddressDAO", addressDAO);
    }
    
    public static UserDAO getUserDao() {
		return userDAO;
	}
    public static UserDAO getUserDAO() {
  		return userDAO;
  	}

  	public static SaleDAO getSaleDAO() {
  		return saleDAO;
  	}

  	public static PhoneDAO getPhoneDAO() {
  		return phoneDAO;
  	}

  	public static UsertypeDAO getUsertypeDAO() {
  		return usertypeDAO;
  	}

  	public static AddressDAO getAddressDAO() {
  		return addressDAO;
  	}

}
