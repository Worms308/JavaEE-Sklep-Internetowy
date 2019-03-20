package entities;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.*;


@Entity
@Table(name="sale")
public class Sale implements Serializable {
	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private int sale_id;
	private int quantity;
	private Date date_order;
	private Date date_completed;
	
	@ManyToOne
	@JoinColumn(name="user")
	private int user;
	
	@ManyToOne
	@JoinColumn(name="phone")
	private int phone;
	


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
		return this.user;
	}

	public void setSale_user_id(int sale_user_id) {
		this.user = sale_user_id;
	}   
	public int getSale_phone_id() {
		return this.phone;
	}

	public void setSale_phone_id(int sale_phone_id) {
		this.phone = sale_phone_id;
	}
   
}
