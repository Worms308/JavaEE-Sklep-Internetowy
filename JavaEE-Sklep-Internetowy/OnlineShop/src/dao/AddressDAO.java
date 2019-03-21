package dao;

import javax.persistence.EntityManager;

import entities.Address;
import entities.User;


public class AddressDAO {

	private EntityManager manager;
	
	public AddressDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	public Address getAddressByID(int id) {
		Address address = (Address) manager.createQuery("SELECT a FROM address a WHERE a.address_id = id")
						  .setParameter("id", id)
						  .getSingleResult();
		return address;
	}
}
