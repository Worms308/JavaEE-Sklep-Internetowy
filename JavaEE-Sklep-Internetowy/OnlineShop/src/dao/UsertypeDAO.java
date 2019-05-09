package dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Usertype;

public class UsertypeDAO {

	private EntityManager manager;
	
	public UsertypeDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	public Usertype getUsertypeByDescription(String description) {
		Usertype usertype = (Usertype) manager.createQuery("SELECT u FROM Usertype u WHERE u.description = :description")
							.setParameter("description", description)
							.getSingleResult();
		return usertype;
	}
	
	public boolean addUsertype(Usertype usertype) {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(usertype);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			System.err.println("usertype adding error! " + new Date());
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean removeUsertype(Usertype usertype) {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.remove(usertype);
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
