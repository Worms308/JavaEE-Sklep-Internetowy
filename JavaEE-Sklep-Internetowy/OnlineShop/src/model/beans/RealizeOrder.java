package model.beans;

import java.sql.Date;
import java.util.List;

import dao.InitDB;
import dao.SaleDAO;
import entities.Sale;
import entities.User;
import model.cart.CartPosition;
import model.cart.ShoppingCart;

public class RealizeOrder {
	
	public boolean realize(User user, ShoppingCart cart, String delivery, String payment) {
		List<CartPosition> positions = cart.getPhonesWithQuantity();
		SaleDAO saleDAO = InitDB.getSaleDAO();
		
		for (CartPosition position:positions) {
			Sale sale = new Sale();
			sale.setSale_user_id(user);
			sale.setSale_phone_id(position.getPhone());
			sale.setQuantity(position.getQuantity());
			sale.setDelivery(delivery);
			sale.setPayment(payment);
			sale.setDate_order(new Date(new java.util.Date().getTime()));
			
			if (saleDAO.addSale(sale) == false)
				return false;
		}
		cart.clear();
		return true;
	}
}
