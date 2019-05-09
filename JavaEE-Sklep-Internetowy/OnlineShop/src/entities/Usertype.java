package entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usertype
 *
 */
@Entity
@Table(name="usertype")
public class Usertype implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int usertype_id;
	private String login;
	private String description;
	private static final long serialVersionUID = 1L;

 
	public int getUsertype_id() {
		return this.usertype_id;
	}

	public void setUsertype_id(int usertype_id) {
		this.usertype_id = usertype_id;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
   
}
