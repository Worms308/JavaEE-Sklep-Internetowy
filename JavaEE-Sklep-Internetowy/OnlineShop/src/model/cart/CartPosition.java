package model.cart;

import java.math.BigDecimal;

import entities.Phone;

public class CartPosition {
	
	private Phone phone;
	private int quantity;
	
	public CartPosition() {
		super();
	}

	public CartPosition(Phone phone, int quantity) {
		super();
		this.phone = phone;
		this.quantity = quantity;
	}
	
	public BigDecimal getTotalPriceWithDiscount() {
		BigDecimal result;
		result = phone.getPrice().multiply(new BigDecimal(quantity)).multiply(new BigDecimal(1.0).subtract(phone.getDiscount()));
		return result;
	}
	
	public Phone getPhone() {
		return phone;
	}
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
