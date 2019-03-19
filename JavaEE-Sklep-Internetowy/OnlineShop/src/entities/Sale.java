package entities;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Sale
 *
 */
@Entity
@Table(name="sale")
public class Sale implements Serializable {

	   
	@Id
	private int sale_id;
	private int quantity;
	private Date date_order;
	private Date date_completed;
	private int sale_user_id;
	private int sale_phone_id;
	private static final long serialVersionUID = 1L;

	public Sale() {
		super();
	}   
	public int getSale_id() {
		return this.sale_id;
	}

	public void setSale_id(int sale_id) {
		this.sale_id = sale_id;
	}   
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}   
	public Date getDate_order() {
		return this.date_order;
	}

	public void setDate_order(Date date_order) {
		this.date_order = date_order;
	}   
	public Date getDate_completed() {
		return this.date_completed;
	}

	public void setDate_completed(Date date_completed) {
		this.date_completed = date_completed;
	}   
	public int getSale_user_id() {
		return this.sale_user_id;
	}

	public void setSale_user_id(int sale_user_id) {
		this.sale_user_id = sale_user_id;
	}   
	public int getSale_phone_id() {
		return this.sale_phone_id;
	}

	public void setSale_phone_id(int sale_phone_id) {
		this.sale_phone_id = sale_phone_id;
	}
   
}
