package model.beans;

import dao.InitDB;
import dao.UserDAO;
import entities.Address;
import entities.User;

public class ChangeAddress {
	
	public boolean change(User user, Address newAddress) {
		UserDAO userDAO = InitDB.getUserDAO();
		return userDAO.changeUserAddress(user.getId(), newAddress);
	}

}
