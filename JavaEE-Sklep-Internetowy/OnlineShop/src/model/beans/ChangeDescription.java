package model.beans;

import dao.InitDB;
import entities.User;
import entities.Usertype;

public class ChangeDescription {

	public void changeDescription(int id) {
		User user = InitDB.getUserDAO().getUserByID(id);
		Usertype type = user.getUsertype();
		
		InitDB.getUsertypeDAO().changeDescription(type, type.getDescription().equals("user")?"admin":"user");
	}
}
