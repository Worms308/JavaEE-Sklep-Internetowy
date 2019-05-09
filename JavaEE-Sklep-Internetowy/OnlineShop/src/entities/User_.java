package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-05-09T16:53:09.463+0200")
@StaticMetamodel(User.class)
public class User_ {
	public static volatile SingularAttribute<User, Integer> user_id;
	public static volatile SingularAttribute<User, String> email;
	public static volatile SingularAttribute<User, String> login;
	public static volatile SingularAttribute<User, String> name;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, String> phone;
	public static volatile SingularAttribute<User, String> surname;
	public static volatile SingularAttribute<User, Address> address;
	public static volatile SingularAttribute<User, Usertype> usertype;
	public static volatile ListAttribute<User, Sale> sales;
}
