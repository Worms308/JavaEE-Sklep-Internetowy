package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Sale;
import entities.User;
import entities.Usertype;
import utilities.MD5Creator;

public class UserDAO {

	private EntityManager manager;
	
	public UserDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	public User getUserByID(int id) {
		User user = (User)manager.createQuery("SELECT u FROM user u WHERE u.user_id = :id")
				.setParameter("id", id)
				.getSingleResult();
	return user;
	}
	

	public User getUserByLogin(String login) {
		User user = (User)manager.createQuery("SELECT u FROM user u WHERE u.login = :login")
					.setParameter("login", login)
					.getSingleResult();
		return user;
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
	
	public List<Sale> getUserSales(User user) {
		return user.getSales();
	}
	
	public boolean removeUser(User user) {
		//TODO implementacja
		return false;
	}
}
