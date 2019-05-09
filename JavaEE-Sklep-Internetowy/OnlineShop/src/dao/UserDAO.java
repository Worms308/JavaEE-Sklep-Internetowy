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
}
