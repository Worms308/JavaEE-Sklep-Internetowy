package dao;

import java.util.Set;

import javax.persistence.EntityManager;

import entities.Usertype;

public class UsertypeDAO {

	private EntityManager manager;
	
	public UsertypeDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	public Usertype getUsertypeByDescription(String description) {
		Usertype usertype = (Usertype) manager.createQuery("SELECT u FROM usertype u WHERE u.description = description")
							.setParameter("description", description)
							.getSingleResult();
		return usertype;
	}
}
