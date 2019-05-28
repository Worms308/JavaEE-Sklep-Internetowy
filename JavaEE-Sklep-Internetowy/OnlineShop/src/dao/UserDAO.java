package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Address;
import entities.User;
import entities.Usertype;
import utilities.MD5Creator;

public class UserDAO {

	private EntityManager manager;
	
	public UserDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	public User getUserByID(int id) {
		User user = (User)manager.createQuery("SELECT u FROM User u WHERE u.user_id = :id")
				.setParameter("id", id)
				.getSingleResult();
	return user;
	}

	public User getUserByLogin(String login) {
		User user = (User)manager.createQuery("SELECT u FROM User u WHERE u.login = :login")
					.setParameter("login", login)
					.getSingleResult();
		return user;
	}
	
	public List<User> getAllUser() {
		@SuppressWarnings("unchecked")
		List<User> result = manager.createQuery("SELECT u FROM User u").getResultList();
		return result;
	}
	
	public boolean addUser(User user, Usertype usertype) {
		user.setPassword(MD5Creator.getMD5(user.getPassword()));
		user.setUsertype(usertype);
		
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(user);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			System.err.println("User adding error! " + new Date());
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean removeUser(User user) {
		Address userAddress = user.getAddress();
		boolean deleteAddress = false;
		
		if (userAddress.getUsers().size() <= 1) {
			deleteAddress = true;
		}
		
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.remove(user);
			if (deleteAddress)
				manager.remove(userAddress);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			System.err.println("User removing error! " + new Date());
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean changeUserData(int id, User newData) {
		User fromDB = manager.find(User.class, id);
		
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			if (newData.getEmail() != null)
				fromDB.setEmail(newData.getEmail());
			if (newData.getName() != null)
				fromDB.setName(newData.getName());
			if (newData.getSurname() != null)
				fromDB.setSurname(newData.getSurname());
			if (newData.getPhone() != null)
				fromDB.setPhone(newData.getPhone());
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			System.err.println("Phone quantity changing error! " + new Date());
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean changeUserAddress(int id, Address newAddress) {
		User fromDB = manager.find(User.class, id);
		Address address = manager.find(Address.class, fromDB.getAddress().getAddressId());
		
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			//if (newAddress.getCity().isEmpty())
				address.setCity(newAddress.getCity());
			//if (newAddress.getCountry().isEmpty())
				address.setCountry(newAddress.getCountry());
			//if (newAddress.getHomeNumber().isEmpty())
				address.setHomeNumber(newAddress.getHomeNumber());
			//if (newAddress.getPostalCode().isEmpty())
				address.setPostalCode(newAddress.getPostalCode());
			//if (newAddress.getStreet().isEmpty())
				address.setStreet(newAddress.getStreet());
			//if (newAddress.getStreetNumber().isEmpty())
				address.setStreetNumber(newAddress.getStreetNumber());
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			System.err.println("Phone quantity changing error! " + new Date());
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean changeUserPassword(int id, User newData) {
		User fromDB = manager.find(User.class, id);
		
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			fromDB.setPassword(newData.getPassword());
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			System.err.println("Phone quantity changing error! " + new Date());
			e.printStackTrace();
			return false;
		}
	}
}
