package model.cart;

import dao.InitDB;
import entities.Phone;

public class RemoveFromCart {

	public static boolean removeFromCart(ShoppingCart cart, int phoneId) {
		Phone phone = InitDB.getPhoneDAO().getPhoneByID(phoneId);
		if (phone != null && cart.getPhoneQuantity(phone) > 0) {
			cart.remove(phone);
			return true;
		} else {
			return false;
		}
	}
}
