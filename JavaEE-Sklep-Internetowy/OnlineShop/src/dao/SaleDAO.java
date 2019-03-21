package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Sale;
import entities.User;

public class SaleDAO {

	private EntityManager manager;
	
	public SaleDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	public Sale getSaleByID(int id) {
		Sale sale = (Sale)manager.createQuery("SELECT s FROM sale s WHERE s.sale_id = :id")
					.setParameter("id", id)
					.getSingleResult();
		return sale;
	}
	
	public List<Sale> getAllSales() {
		@SuppressWarnings("unchecked")
		List<Sale> result = manager.createQuery("SELECT s FROM sale s").getResultList();
		return result;
	}
	
	public List<Sale> getSaleByUser(User user) {
		return user.getSales();
	}
	
	public boolean addSale(Sale sale) {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(sale);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			System.err.println("Sale adding error! " + new Date());
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean removeSale(Sale sale) {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.remove(sale);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			System.err.println("Sale removing error! " + new Date());
			e.printStackTrace();
			return false;
		}
	}
}
