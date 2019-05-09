package model.beans;

import javax.persistence.NoResultException;

import dao.AddressDAO;
import dao.InitDB;
import dao.UserDAO;
import dao.UsertypeDAO;
import entities.Address;
import entities.User;
import entities.Usertype;


public class RegisterBean {
	public boolean registerUser(String name, String surname, String phone, String country, String city, String street, String streetNum, String home, String postal, String login, String email, String password, String password2) {
		if (name != null && surname != null && phone != null && country != null && city != null && street != null && streetNum != null && home != null && postal != null && login != null && email != null && password != null && password2 != null) {
			if (password.equals(password2)) {
				UserDAO userDAO = InitDB.getUserDao();
				AddressDAO addressDAO = InitDB.getAddressDAO();
				UsertypeDAO usertypeDAO = InitDB.getUsertypeDAO();
				try {
					userDAO.getUserByLogin(login);
					// uzytkownik juz istnieje
					return false;
				} catch (NoResultException e) {
					User user = new User();
					user.setName(name);
					user.setSurname(surname);
					user.setPhone(phone);
					user.setLogin(login);
					user.setEmail(email);
					user.setPassword(password);
					Usertype usertype = new Usertype();
					usertype.setLogin(login);
					if (!usertypeDAO.addUsertype(usertype))
						return false;
					Address userAddress;
					try {
						userAddress = addressDAO.getAddressByAddress(country, city, street, streetNum, home, postal);
					} catch (NoResultException e2) {
						userAddress = new Address();
						userAddress.setCountry(country);
						userAddress.setCity(city);
						userAddress.setStreet(street);
						userAddress.setStreetNumber(streetNum);
						userAddress.setStreetNumber(home);
						userAddress.setPostalCode(postal);
						if (!addressDAO.addAddress(userAddress)) {
							usertypeDAO.removeUsertype(usertype);
							return false;
						}
					}
					user.setAddress(userAddress);
					if (userDAO.addUser(user, usertype)) {
						return true; // udało sie dodac usera
					} else {
						return false;
					}
				}
			}
		}
		return false;
	}
}
