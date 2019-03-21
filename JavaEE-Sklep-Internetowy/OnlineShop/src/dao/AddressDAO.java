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
		Address address = (Address) manager.createQuery("SELECT a FROM address a WHERE a.address_id = :id")
						  .setParameter("id", id)
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
