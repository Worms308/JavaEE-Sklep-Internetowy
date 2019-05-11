package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Phone;

public class PhoneDAO {

	private EntityManager manager;
	
	public PhoneDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	public Phone getPhoneByID(int id) {
		Phone phone = (Phone)manager.createQuery("SELECT p FROM Phone p WHERE p.phone_id = :id")
					  .setParameter("id", id)
					  .getSingleResult();
		return phone;
	}
	
	public List<Phone> getAllPhone() {
		@SuppressWarnings("unchecked")
		List<Phone> result = manager.createQuery("SELECT p FROM Phone p").getResultList();
		return result;
	}
	
	public boolean addPhone(Phone phone) {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(phone);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			System.err.println("Phone adding error! " + new Date());
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean removePhone(Phone phone) {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.remove(phone);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			System.err.println("Phone removing error! " + new Date());
			e.printStackTrace();
			return false;
		}
	}
}
