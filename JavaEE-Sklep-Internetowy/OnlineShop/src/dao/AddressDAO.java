package dao;

import javax.persistence.EntityManager;

public class AddressDAO {

	private EntityManager manager;
	
	public AddressDAO(EntityManager manager) {
		this.manager = manager;
	}
}
