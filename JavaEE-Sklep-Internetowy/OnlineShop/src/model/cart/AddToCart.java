package model.cart;

import dao.InitDB;
import entities.Phone;

public class AddToCart {

	public boolean addToCart(ShoppingCart cart, int phoneId) {
		Phone phone = InitDB.getPhoneDAO().getPhoneByID(phoneId);
		if (phone != null && phone.getQuantity() > 0 && cart.getPhoneQuantity(phone) < phone.getQuantity()) {
			cart.add(phone);
			return true;
		} else {
			return false;
		}
	}
}
