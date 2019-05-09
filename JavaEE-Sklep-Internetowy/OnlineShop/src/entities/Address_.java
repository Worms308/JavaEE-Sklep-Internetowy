package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-05-09T16:53:09.335+0200")
@StaticMetamodel(Address.class)
public class Address_ {
	public static volatile SingularAttribute<Address, Integer> address_id;
	public static volatile SingularAttribute<Address, String> city;
	public static volatile SingularAttribute<Address, String> country;
	public static volatile SingularAttribute<Address, String> home_number;
	public static volatile SingularAttribute<Address, String> postal_code;
	public static volatile SingularAttribute<Address, String> street;
	public static volatile SingularAttribute<Address, String> street_number;
	public static volatile ListAttribute<Address, User> users;
}
