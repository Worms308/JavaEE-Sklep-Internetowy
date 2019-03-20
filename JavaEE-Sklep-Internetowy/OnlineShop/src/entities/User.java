package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String email;
	private String login;
	private String name;
	private String password;
	private String phone;
	private String surname;

	//bi-directional many-to-one association to Address
	@ManyToOne
	@JoinColumn(name="user_address_id")
	private Address address;

	//bi-directional many-to-one association to Usertype
	@ManyToOne
	@JoinColumn(name="user_usertype_id")
	private Usertype usertype;

	//bi-directional many-to-one association to Sale
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	private List<Sale> sales;


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Usertype getUsertype() {
		return this.usertype;
	}

	public void setUsertype(Usertype usertype) {
		this.usertype = usertype;
	}

	public List<Sale> getSales() {
		return this.sales;
	}

	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}

}