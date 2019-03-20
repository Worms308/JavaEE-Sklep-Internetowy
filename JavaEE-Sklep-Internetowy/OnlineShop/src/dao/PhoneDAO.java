package dao;

import javax.persistence.EntityManager;

public class PhoneDAO {

	private EntityManager manager;
	
	public PhoneDAO(EntityManager manager) {
		this.manager = manager;
	}
}
