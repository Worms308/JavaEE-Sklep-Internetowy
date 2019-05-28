package model.beans;

import dao.InitDB;
import entities.User;

public class ChangePersonalData {
	
	public boolean change(User user, User data) {
		return InitDB.getUserDAO().changeUserData(user.getId(), data);
	}

}
