package model.beans;

import dao.InitDB;
import entities.Phone;
import model.cart.ShoppingCart;

public class AddToCart {

	public boolean addToCart(ShoppingCart cart, int phoneId) {
		Phone phone = InitDB.getPhoneDAO().getPhoneByID(phoneId);
//		System.out.println("W koszyku: " + cart.getPhoneQuantity(phone));
//		System.out.println("W magazyn: " + phone.getQuantity());
		if (phone != null && phone.getQuantity() > 0 && cart.getPhoneQuantity(phone) < phone.getQuantity()) {
			cart.add(phone);
			return true;
		} else {
			return false;
		}
	}
}
