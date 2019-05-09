package entities;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-05-09T16:53:09.461+0200")
@StaticMetamodel(Sale.class)
public class Sale_ {
	public static volatile SingularAttribute<Sale, Integer> sale_id;
	public static volatile SingularAttribute<Sale, Integer> quantity;
	public static volatile SingularAttribute<Sale, Date> date_order;
	public static volatile SingularAttribute<Sale, Date> date_completed;
	public static volatile SingularAttribute<Sale, User> user;
	public static volatile SingularAttribute<Sale, Phone> phone;
}
