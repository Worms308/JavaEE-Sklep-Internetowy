package model.beans;

import dao.InitDB;
import dao.UserDAO;
import entities.User;
import utilities.MD5Creator;

public class ChangePassword {

	public String change(User user, String oldPass, String newPass, String newPass2) {
		if (user.getPassword().equals(MD5Creator.getMD5(oldPass))) {
			if (newPass.equals(newPass2) && !newPass.isEmpty()) {
				UserDAO userDAO = InitDB.getUserDAO();
				user.setPassword(MD5Creator.getMD5(newPass));
				if (userDAO.changeUserPassword(user.getId(), user)) {
					return "Zmieniono hasło";
				} else {
					return "Błąd serwera, spróbuj później";
				}
			} else {
				return "Nowe hasła nie są identyczne";
			}
		} else {
			return "Stare hasło niezgodne z aktualnym";
		}
	}
}
