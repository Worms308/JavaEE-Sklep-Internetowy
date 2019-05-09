package dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Address;


public class AddressDAO {

	private EntityManager manager;
	
	public AddressDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	public Address getAddressByID(int id) {
		Address address = (Address) manager.createQuery("SELECT a FROM Address a WHERE a.address_id = :id")
						  .setParameter("id", id)
						  .getSingleResult();
		return address;
	}
	
	public Address getAddressByAddress(String country, String city, String street, String street_number, String home_number, String postal) {
		Address address = (Address) manager.createQuery("SELECT a FROM Address a WHERE a.country = :country AND a.city = :city AND a.street = :street AND a.street_number = :street_number AND a.home_number = :home_number AND a.postal_code = :postal")
				  .setParameter("country", country)
				  .setParameter("city", city)
				  .setParameter("street", street)
				  .setParameter("street_number", street_number)
				  .setParameter("home_number", home_number)
				  .setParameter("postal", postal)
				  .getSingleResult();
return address;
	}
	
	public boolean addAddress(Address address) {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(address);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			System.err.println("Address adding error! " + new Date());
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean removeAddress(Address address) {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.remove(address);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			System.err.println("Address removing error! " + new Date());
			e.printStackTrace();
			return false;
		}
	}
}
