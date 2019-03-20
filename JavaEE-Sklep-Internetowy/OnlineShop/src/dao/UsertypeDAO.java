package dao;

import javax.persistence.EntityManager;

public class UsertypeDAO {

	private EntityManager manager;
	
	public UsertypeDAO(EntityManager manager) {
		this.manager = manager;
	}
}
