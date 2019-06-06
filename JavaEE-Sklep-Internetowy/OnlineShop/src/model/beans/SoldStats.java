package model.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import dao.InitDB;
import dao.PhoneDAO;
import entities.Phone;
import entities.Sale;

public class SoldStats {
	
	private List<Sale> sales;
	
	public SoldStats(List<Sale> sales) {
		this.sales = sales; 
	}
	
	public List<Phone> getPhones(List<Phone> phones){
		List<Phone> nowe = new ArrayList<>();
		for (Phone it:phones) {
			nowe.add(new Phone());
			nowe.get(nowe.size()-1).setQuantity(it.getQuantity());
			nowe.get(nowe.size()-1).setManufacturer(it.getManufacturer());
			nowe.get(nowe.size()-1).setModel(it.getModel());
		}
		return nowe;
	}
	
	public List<Phone> soldLastMonth() {
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

	private Date getStartDate() {
		Date firstDate = sales.get(0).getDate_order();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(firstDate);
		calendar.set( Calendar.DAY_OF_MONTH, 1); 
		calendar.set( Calendar.HOUR, 0); 
		calendar.set( Calendar.MINUTE, 0); 
		calendar.set( Calendar.SECOND, 0);
		calendar.set( Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	
	
	private Date addMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add( Calendar.MONTH, 1); 
		return calendar.getTime();
	}
	
	private String getDateString(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return "\'" + calendar.get(Calendar.YEAR) + "/" + (calendar.get(Calendar.MONTH)+1) + "\'";
	}
	
	private List<Phone> soldLastMonth(Date start) {
		List<Phone> result = new ArrayList<>();
		Date end = start;
		Calendar c = Calendar.getInstance(); 
		c.setTime(end);
		c.add(Calendar.MONTH, 1);
		end = c.getTime();

		for (int i=0;i<sales.size();++i) {
			if (sales.get(i).getDate_order().after(end)) continue;
			if (sales.get(i).getDate_order().before(start)) continue;
			
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
	
	private int calcPhonesNumber(List<Phone> fromLastMonth, List<Phone> allPhones, int phoneId) {
		int result = 0;
		String fullName2 = allPhones.get(phoneId).getManufacturer() + " " + allPhones.get(phoneId).getModel();
		for (Phone it:fromLastMonth) {
			String fullName1 = it.getManufacturer() + " " + it.getModel();
			if (fullName1.equals(fullName2))
				result = it.getQuantity();
		}
		return result;
	}
	
	public String soldComboChartData(List<Phone> phones) {
		StringBuilder result = new StringBuilder();
		
		// DODANIE PIERWSZEGO WIERSZA Z MODELAMI
		String modelsRow[] = new String[phones.size() + 1];
		modelsRow[0] = "\'Miesiąc\'";
		for (int i=0;i<phones.size();++i) {
			modelsRow[i+1] = "\'" + phones.get(i).getManufacturer() + " " + phones.get(i).getModel() + "\'";
		}
		result.append(Arrays.toString(modelsRow));
		result.append(",");
		
		Date start = this.getStartDate();
		
		while(start.before(new Date())) {
			String row[] = new String[modelsRow.length];
			row[0] = this.getDateString(start);
			
			List<Phone> phonesInternal = this.soldLastMonth(start);
//			for (Phone it:phonesInternal)
//				System.out.println(it.getQuantity());
			for (int i=0;i<phones.size();++i) {
				row[i+1] = String.valueOf(this.calcPhonesNumber(phonesInternal, phones, i));
			}
			
			result.append(Arrays.toString(row)+",");
			start = this.addMonth(start);
		}
		
		result.deleteCharAt(result.length()-1);
		return result.toString();
	}
	
	private List<Double> findPhoneTrend(Phone phone) {
		List<Double> result = new ArrayList<>();
		
		List<Phone> phones = InitDB.getPhoneDAO().getAllPhone();
		Date start = this.getStartDate();
		
		while(start.before(new Date())) {
			List<Phone> phonesInternal = this.soldLastMonth(start);

			result.add((double) this.calcPhonesNumber(phonesInternal, phones, phone.getPhoneId()-1));
			
			start = this.addMonth(start);
		}
		result.remove(result.size()-1);
		return result;
	}
	
	private double estimatedTrendValue(List<Double> trend) {
		double result = 0.0;
		for (int i=trend.size()-1, j=0;i>0 && j<=3;--i, ++j) {
			double difference = trend.get(i) - trend.get(i-1);
			switch (j) {
			case 0:
				result += difference * 1.5;
				break;
			case 1:
				result += difference * 1;
				break;
			case 2:	
				result += difference * 0.6;
				break;
			case 3:	
				result += difference * 0.3;
				break;
				
			}
		}
		return result;
	}
	
	public List<Phone> getEstimatedOrder() {
		PhoneDAO phoneDAO = InitDB.getPhoneDAO();
		List<Phone> phones = phoneDAO.getAllPhone();
		List<Phone> result = new ArrayList<>();
		
		for (Phone it:phones) {
			double estimated = this.estimatedTrendValue(this.findPhoneTrend(it));
			int roundEstimated = (int)Math.ceil(estimated);
			Phone tmp = new Phone();
			tmp.setManufacturer(it.getManufacturer());
			tmp.setModel(it.getModel());
			tmp.setQuantity(roundEstimated - phoneDAO.getPhoneByID(it.getPhoneId()).getQuantity());
			
			if (tmp.getQuantity() > 0)
				result.add(tmp);
		}
		
		return result;
	}
}
