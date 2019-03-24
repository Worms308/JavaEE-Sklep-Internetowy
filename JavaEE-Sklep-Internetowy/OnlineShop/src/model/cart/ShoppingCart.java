package model.cart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import entities.Phone;

public class ShoppingCart {

	private List<Phone> phones;
	private List<Integer> quantity;
	
	public ShoppingCart() {
		phones = new ArrayList<>();
		quantity = new ArrayList<>();
	}
	
	public void addElement(Phone phone) {
		if (phones.contains(phone)) {
			quantity.set(phones.indexOf(phone), quantity.get(phones.indexOf(phone)) + 1);
		} else {
			phones.add(phone);
			quantity.add(1);
		}
	}
	
	public void removeElement(Phone phone) {
		if (phones.contains(phone)) {
			quantity.set(phones.indexOf(phone), quantity.get(phones.indexOf(phone)) - 1);
			if (quantity.get(phones.indexOf(phone)) == 0) {
				quantity.remove(quantity.get(phones.indexOf(phone)));
				phones.remove(phone);
			}
		}
	}
	
	public void clear() {
		phones.clear();
		quantity.clear();
	}
	
	public double getTotalPrice() {
		BigDecimal totalPrice = new BigDecimal(0.0);
		for (int i=0;i<phones.size();++i)
			totalPrice.add(phones.get(i).getPrice().multiply(BigDecimal.valueOf(quantity.get(i))));
		
		return totalPrice.doubleValue();
	}
	
	public List<Phone> getPhones() {
		ArrayList<Phone> result = new ArrayList<>();
		for (int i=0;i<phones.size();++i) {
			for (int j=0;j<quantity.get(i).intValue();++j)
				result.add(phones.get(i));
		}
		return result;
	}
}
