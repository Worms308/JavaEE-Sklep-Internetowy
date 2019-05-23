package model.beans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import entities.Phone;
import entities.Sale;

public class SoldStats {
	
	private List<Sale> sales;
	
	public SoldStats(List<Sale> sales) {
		this.sales = sales; 
	}
	
	public List<Phone> soldLastMonth() {
		//PhoneDAO phoneDAO = InitDB.getPhoneDAO();
		List<Phone> result = new ArrayList<>();
		Date dt = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(dt);
		c.add(Calendar.MONTH, -1);
		dt = c.getTime();
		
		for (int i=sales.size()-1;i>-1;--i) {
			if (sales.get(i).getDate_order().before(dt)) break;
			
			Phone phone = sales.get(i).getSale_phone_id();
			boolean added = false;
			for (Phone it:result) {
				if (it.getPhoneId() == phone.getPhoneId()) {
					it.setQuantity(it.getQuantity()+1);
					added = true;
					break;
				}
			}
			if (!added) {
				phone.setQuantity(1);
				result.add(phone);
			}
		}
		
		return result;
	}
}
