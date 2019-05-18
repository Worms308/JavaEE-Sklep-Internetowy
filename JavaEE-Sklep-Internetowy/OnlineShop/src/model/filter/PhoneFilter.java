package model.filter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import entities.Phone;

public class PhoneFilter {
	
	private List<Phone> phones = new ArrayList<>();
	
	public PhoneFilter(List<Phone> phoneList) {
		phones.addAll(phoneList);
	}
	
	public int size() {
		return phones.size();
	}
	
	public List<Phone> getPhones() {
		return phones;
	}
	
	public void filterByAll(String manufacturer, String model, String processor, String system, String screen, String ram, String storage, String camera, String price, String rating) {
		this.filterByManufacturer(manufacturer);
		this.filterByModel(model);
		this.filterByProcessor(processor);
		this.filterBySystem(system);
		this.filterByScreenSize(screen);
		this.filterByRAM(ram);
		this.filterByStorage(storage);
		this.filterByCamera(camera);
		this.filterByPrice(price);
		this.filterByRating(rating);
	}
	

	// Manufacturer
	public void filterByManufacturer(String manufacturer){
		if (manufacturer == null || manufacturer.equals("")) return;
		
		phones = phones.stream().filter(phone -> manufacturer.equals(phone.getManufacturer())).collect(Collectors.toList());
	}
	
	// Model
	public void filterByModel(String model) {
		if (model == null || model.equals("")) return;
		
		phones = phones.stream().filter(phone -> model.equals(phone.getModel())).collect(Collectors.toList());
	}
	
	// Processor
	public void filterByProcessor(String processor) {
		if (processor.equals("")) return;
		
		phones = phones.stream().filter(phone -> processor.equals(phone.getProcessor())).collect(Collectors.toList());
	}
	
	// System
	public void filterBySystem(String system) {
		if (system.equals("")) return;
		
		phones = phones.stream().filter(phone -> system.equals(phone.getSystem())).collect(Collectors.toList());
	}
	
	// Screen Size (range)
	public void filterByScreenSize(String size) {
		if (size.equals("")) return;
		
		final double minimum = 0.0, maximum;
		if (size.equals("5")) maximum = 5.0;
		else if (size.equals("6")) maximum = 6.0;
		else if (size.equals("7")) maximum = 7.0;
		else if (size.equals("8")) maximum = 8.0;
		else maximum = 999999.0;
		
		phones = phones.stream().filter(phone -> Double.parseDouble(phone.getScreenSize()) >= minimum && Double.parseDouble(phone.getScreenSize()) <= maximum).collect(Collectors.toList());
	}
	
	// RAM 
	public void filterByRAM(String ram) {
		if (ram.equals("")) return;
		
		phones = phones.stream().filter(phone -> ram.equals(phone.getRam())).collect(Collectors.toList());
	}
	
	// Storage
	public void filterByStorage(String storage) {
		if (storage.equals("")) return;
		
		phones = phones.stream().filter(phone -> storage.equals(phone.getStorage())).collect(Collectors.toList());
	}
	
	// Camera
	public void filterByCamera(String camera) {
		if (camera.equals("")) return;
		
		final double minimum, maximum;
		if (camera.equals("to_15")) {
			maximum = 15;
			minimum = 0.0;
		}
		else if (camera.equals("to_25")) {
			maximum = 25;
			minimum = 0.0;
		}
		else if (camera.equals("to_40")) {
			minimum = 0.0;
			maximum = 40;
		}
		else {
			minimum = 40.0;
			maximum = 999999.0;
		}
		
		phones = phones.stream().filter(phone -> Double.parseDouble(phone.getCamera()) >= minimum && Double.parseDouble(phone.getCamera()) <= maximum).collect(Collectors.toList());
	}
	
	// Price (range)
	public void filterByPrice(String price) {
		if (price.equals("")) return;
		final double minimum;
		final double maximum;
		if (price.equals("to_500")) {
			maximum = 500;
			minimum = 0.0;
		}
		else if (price.equals("to_1000")) {
			maximum = 1000.0;
			minimum = 0.0;
		}
		else if (price.equals("to_2000")) {
			minimum = 0.0;
			maximum = 2000.0;
		}
		else {
			minimum = 2000.0;
			maximum = 99999999.0;
		}
		
		phones = phones.stream().filter(phone -> phone.getPrice().compareTo(BigDecimal.valueOf(minimum)) >= 0 && phone.getPrice().compareTo(BigDecimal.valueOf(maximum)) <= 0).collect(Collectors.toList());
	}
	
	// Rating (range)
	public void filterByRating(String rating) {
		if (rating.equals("")) return;

		final double minimum;
		final double maximum;
		if (rating.equals("2")) {
			maximum = 2.0;
			minimum = 2.999;
		}
		else if (rating.equals("3")) {
			maximum = 3.0;
			minimum = 3.999;
		}
		else if (rating.equals("4")) {
			minimum = 4.0;
			maximum = 4.999;
		}
		else {
			minimum = 5.0;
			maximum = 5.0;
		}
		
		phones = phones.stream().filter(phone -> phone.getRating().compareTo(BigDecimal.valueOf(minimum)) >= 0 && phone.getRating().compareTo(BigDecimal.valueOf(maximum)) <= 0).collect(Collectors.toList());
	}
}
