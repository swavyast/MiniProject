package com.ml.miniproject.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.ml.miniproject.pojo.Author;
import com.ml.miniproject.pojo.Book;
import com.ml.miniproject.pojo.CreditCard;
import com.ml.miniproject.pojo.Customer;
import com.ml.miniproject.pojo.GoldCustomer;
import com.ml.miniproject.pojo.Order;
import com.ml.miniproject.pojo.OrderItem;
import com.ml.miniproject.pojo.ShippingAddress;
import com.ml.miniproject.pojo.SilverCustomer;

public class HibernateUtil {
	static SessionFactory sessionFactory;
	static {
		Configuration cfg = new Configuration();
		Properties props = new Properties();
		props.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
		props.put(Environment.URL, "jdbc:mysql://localhost:3306/testing");
		props.put(Environment.USER, "root");
		props.put(Environment.PASS, "68921794");
		props.put(Environment.SHOW_SQL, "true");
		props.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
		props.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
		props.put(Environment.HBM2DDL_AUTO, "create");
		props.put(Environment.HBM2DDL_AUTO, "update");
		cfg.setProperties(props);
		cfg.addAnnotatedClass(Customer.class);
		cfg.addAnnotatedClass(SilverCustomer.class);
		cfg.addAnnotatedClass(GoldCustomer.class);
		cfg.addAnnotatedClass(ShippingAddress.class);
		cfg.addAnnotatedClass(CreditCard.class);
		cfg.addAnnotatedClass(Order.class);
		cfg.addAnnotatedClass(OrderItem.class);
		cfg.addAnnotatedClass(Book.class);
		cfg.addAnnotatedClass(Author.class);
		StandardServiceRegistryBuilder ssrbuilder = new StandardServiceRegistryBuilder();
		StandardServiceRegistry serviceReg = ssrbuilder.applySettings(cfg.getProperties()).build();
		sessionFactory = cfg.buildSessionFactory(serviceReg);
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}