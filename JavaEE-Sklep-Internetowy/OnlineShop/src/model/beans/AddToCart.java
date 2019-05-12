package model.beans;

import dao.InitDB;
import entities.Phone;
import model.cart.ShoppingCart;

public class AddToCart {

	public boolean addToCart(ShoppingCart cart, int phoneId) {
		Phone phone = InitDB.getPhoneDAO().getPhoneByID(phoneId);
		if (phone != null && phone.getQuantity() > 0) {
			cart.add(phone);
			return true;
		} else {
			return false;
		}
	}
}
