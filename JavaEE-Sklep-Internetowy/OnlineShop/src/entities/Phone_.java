package entities;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-05-09T16:53:09.455+0200")
@StaticMetamodel(Phone.class)
public class Phone_ {
	public static volatile SingularAttribute<Phone, Integer> phone_id;
	public static volatile SingularAttribute<Phone, String> camera;
	public static volatile SingularAttribute<Phone, String> manufacturer;
	public static volatile SingularAttribute<Phone, String> model;
	public static volatile SingularAttribute<Phone, BigDecimal> price;
	public static volatile SingularAttribute<Phone, String> processor;
	public static volatile SingularAttribute<Phone, String> ram;
	public static volatile SingularAttribute<Phone, BigDecimal> rating;
	public static volatile SingularAttribute<Phone, Integer> rating_count;
	public static volatile SingularAttribute<Phone, String> screen_size;
	public static volatile SingularAttribute<Phone, String> storage;
	public static volatile SingularAttribute<Phone, String> system;
	public static volatile SingularAttribute<Phone, BigDecimal> discount;
	public static volatile ListAttribute<Phone, Sale> sales;
}
