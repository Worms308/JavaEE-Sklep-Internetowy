package model.cart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import entities.Phone;

public class ShoppingCart {
	
	private List<CartPosition> positions;
	
	public ShoppingCart() {
		positions = new ArrayList<>();
	}
		
	public void add(Phone phone) {
		for (CartPosition cartPosition:positions) {
			if (cartPosition.getPhone().equals(phone)) {
				cartPosition.setQuantity(cartPosition.getQuantity() + 1);
				return;
			}
		}
		
		positions.add(new CartPosition(phone, 1));
	}
	
	public void remove(Phone phone) {
		for (CartPosition cartPosition:positions) {
			if (cartPosition.getPhone().equals(phone)) {
				cartPosition.setQuantity(cartPosition.getQuantity() - 1);
				if (cartPosition.getQuantity() == 0) {
					positions.remove(cartPosition);
					break;
				}
			}
		}
	}
	
	public BigDecimal getTotalPriceWithDiscount() {
		BigDecimal result = new BigDecimal(0.0);
		
		for (CartPosition cartPosition:positions) {
			result = result.add(cartPosition.getTotalPriceWithDiscount());
		}
			
		return result;
	}
	
	public void clear() {
		positions.clear();
	}
	
	public ArrayList<CartPosition> getPhonesWithQuantity() {
		return new ArrayList<CartPosition>(positions);
	}
	
	public int getPhoneQuantity(Phone phone) {
		int result = 0;
		for (CartPosition position:positions)
			if (position.getPhone().equals(phone))
				result++;
		return result;
	}

}
