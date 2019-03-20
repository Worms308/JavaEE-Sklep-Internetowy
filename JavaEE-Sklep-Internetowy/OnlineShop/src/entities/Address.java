package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the address database table.
 * 
 */
@Entity
@Table(name="address")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int address_id;
	private String city;
	private String country;
	private String home_number;
	private String postal_code;
	private String street;
	private String street_number;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="address", fetch=FetchType.EAGER)
	private List<User> users;



	public int getAddressId() {
		return this.address_id;
	}

	public void setAddressId(int addressId) {
		this.address_id = addressId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getHomeNumber() {
		return this.home_number;
	}

	public void setHomeNumber(String homeNumber) {
		this.home_number = homeNumber;
	}

	public String getPostalCode() {
		return this.postal_code;
	}

	public void setPostalCode(String postalCode) {
		this.postal_code = postalCode;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreetNumber() {
		return this.street_number;
	}

	public void setStreetNumber(String streetNumber) {
		this.street_number = streetNumber;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setAddress(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setAddress(null);

		return user;
	}

}