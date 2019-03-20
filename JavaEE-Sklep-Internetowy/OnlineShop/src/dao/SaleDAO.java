package dao;

import javax.persistence.EntityManager;

public class SaleDAO {

	private EntityManager manager;
	
	public SaleDAO(EntityManager manager) {
		this.manager = manager;
	}
}
