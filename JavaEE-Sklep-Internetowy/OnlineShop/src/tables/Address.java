package tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	

	public Address(String country, String city, String street, String streetNumber, String homeNumber,
			String postalCode) {
		this.country = country;
		this.city = city;
		this.street = street;
		this.streetNumber = streetNumber;
		this.homeNumber = homeNumber;
		this.postalCode = postalCode;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="country")
	private String country;
	
	@Column(name="city")
	private String city;
	
	@Column(name="street")
	private String street;
	
	@Column(name="street_number")
	private String streetNumber;
	
	@Column(name="home_number")
	private String homeNumber;
	
	@Column(name="postal_code")
	private String postalCode;



}
