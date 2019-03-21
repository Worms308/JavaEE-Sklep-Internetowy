package model.filter;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import entities.Phone;

public class PhoneFilter {
	
	private List<Phone> phones;
	
	public PhoneFilter(List<Phone> phoneList) {
		phones.addAll(phoneList);
	}
	
	public int size() {
		return phones.size();
	}
	
	public List<Phone> getPhones() {
		return phones;
	}

	// Manufacturer
	public void filterByManufacturer(String manufacturer){
		phones = phones.stream().filter(phone -> manufacturer.equals(phone.getManufacturer())).collect(Collectors.toList());
	}
	
	// Model
	public void filterByModel(String model) {
		phones = phones.stream().filter(phone -> model.equals(phone.getModel())).collect(Collectors.toList());
	}
	
	// Processor
	public void filterByProcessor(String processor) {
		phones = phones.stream().filter(phone -> processor.equals(phone.getProcessor())).collect(Collectors.toList());
	}
	
	// System
	public void filterBySystem(String system) {
		phones = phones.stream().filter(phone -> system.equals(phone.getSystem())).collect(Collectors.toList());
	}
	
	// Screen Size (range)
	public void filterByScreenSize(double minimum, double maximum) {
		phones = phones.stream().filter(phone -> Double.parseDouble(phone.getScreenSize()) >= minimum && Double.parseDouble(phone.getScreenSize()) <= maximum).collect(Collectors.toList());
	}
	
	// RAM 
	public void filterByRAM(String ram) {
		phones = phones.stream().filter(phone -> ram.equals(phone.getRam())).collect(Collectors.toList());
	}
	
	// Storage
	public void filterByStorage(String storage) {
		phones = phones.stream().filter(phone -> storage.equals(phone.getStorage())).collect(Collectors.toList());
	}
	
	// Camera
	public void filterByCamera(String camera) {
		phones = phones.stream().filter(phone -> camera.equals(phone.getCamera())).collect(Collectors.toList());
	}
	
	// Price (range)
	public void filterByPrice(double minimum, double maximum) {
		phones = phones.stream().filter(phone -> phone.getPrice().compareTo(BigDecimal.valueOf(minimum)) >= 0 && phone.getPrice().compareTo(BigDecimal.valueOf(maximum)) <= 0).collect(Collectors.toList());
	}
	
	// Rating (range)
	public void filterByRating(double minimum, double maximum) {
		phones = phones.stream().filter(phone -> phone.getRating().compareTo(BigDecimal.valueOf(minimum)) >= 0 && phone.getRating().compareTo(BigDecimal.valueOf(maximum)) <= 0).collect(Collectors.toList());
	}
}
