package model.beans;

import java.util.ArrayList;
import java.util.List;

import entities.Phone;

public class FilterData {
	
	private List<Phone> phones;
	
	public FilterData(List<Phone> phones) {
		this.phones = phones;
	}
	
	public List<String> getAvaiableModels() {
		List<String> result = new ArrayList<>();
		for (Phone phone:phones) 
			if (!result.contains(phone.getModel()))
				result.add(phone.getModel());
		
		return result;
	}
	
	public List<String> getAvaiableManufacturers() {
		List<String> result = new ArrayList<>();
		for (Phone phone:phones) 
			if (!result.contains(phone.getManufacturer()))
				result.add(phone.getManufacturer());
		
		return result;
	}
	
	public List<String> getAvaiableSystems() {
		List<String> result = new ArrayList<>();
		for (Phone phone:phones) 
			if (!result.contains(phone.getSystem()))
				result.add(phone.getSystem());
		
		return result;
	}
	
	public List<String> getAvaiableProcessor() {
		List<String> result = new ArrayList<>();
		for (Phone phone:phones) 
			if (!result.contains(phone.getProcessor()))
				result.add(phone.getProcessor());
		
		return result;
	}
}
