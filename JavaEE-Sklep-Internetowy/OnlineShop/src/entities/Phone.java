package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the phone database table.
 * 
 */
@Entity
@Table(name="phone")
public class Phone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int phone_id;
	private String camera;
	private String manufacturer;
	private String model;
	private BigDecimal price;
	private String processor;
	private String ram;
	private BigDecimal rating;
	private int rating_count;
	private String screen_size;
	private String storage;
	private String system;
	private BigDecimal discount;
	private int quantity;
	private String img;

	//bi-directional many-to-one association to Sale
	@OneToMany(mappedBy="phone", fetch=FetchType.EAGER)
	private List<Sale> sales;



	public int getPhoneId() {
		return this.phone_id;
	}

	public void setPhoneId(int phoneId) {
		this.phone_id = phoneId;
	}

	public String getCamera() {
		return this.camera;
	}

	public void setCamera(String camera) {
		this.camera = camera;
	}

	public String getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getProcessor() {
		return this.processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public String getRam() {
		return this.ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public BigDecimal getRating() {
		return this.rating;
	}

	public void setRating(BigDecimal rating) {
		this.rating = rating;
	}

	public int getRatingCount() {
		return this.rating_count;
	}

	public void setRatingCount(int ratingCount) {
		this.rating_count = ratingCount;
	}

	public String getScreenSize() {
		return this.screen_size;
	}

	public void setScreenSize(String screenSize) {
		this.screen_size = screenSize;
	}

	public String getStorage() {
		return this.storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	public String getSystem() {
		return this.system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public List<Sale> getSales() {
		return this.sales;
	}

	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}