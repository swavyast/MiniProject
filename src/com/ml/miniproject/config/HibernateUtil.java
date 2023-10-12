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
	static SessionFactory sessionFactory=null;
	static {
		try {
			Configuration cfg = new Configuration();
			//Adding Configuration Properties
			Properties prop = new Properties();
			prop.put(Environment.DRIVER, "oracle.jdbc.driver.OracleDriver");
			prop.put(Environment.DIALECT, "org.hibernate.dialect.Oracle12cDialect");
			prop.put(Environment.SHOW_SQL, "true");
			prop.put(Environment.AUTO_CLOSE_SESSION, "true");
			prop.put(Environment.HBM2DDL_AUTO, "create");
			prop.put(Environment.HBM2DDL_AUTO, "update");
			prop.put(Environment.URL, "jdbc:oracle:thin:@localhost:1521:xe");
			prop.put(Environment.USER, "system");
			prop.put(Environment.PASS, "68921794");
			prop.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
			cfg.setProperties(prop);
			//Adding Annotated Classes
			cfg.addAnnotatedClass(Author.class);
			cfg.addAnnotatedClass(Book.class);
			cfg.addAnnotatedClass(Customer.class);
			cfg.addAnnotatedClass(OrderItem.class);
			cfg.addAnnotatedClass(CreditCard.class);
			cfg.addAnnotatedClass(Order.class);
			cfg.addAnnotatedClass(GoldCustomer.class);
			cfg.addAnnotatedClass(SilverCustomer.class);
			cfg.addAnnotatedClass(ShippingAddress.class);
			StandardServiceRegistryBuilder ssrBuilder = new StandardServiceRegistryBuilder();
			StandardServiceRegistry ssr = ssrBuilder.applySettings(cfg.getProperties()).build();
			sessionFactory = cfg.buildSessionFactory(ssr);
		} catch (Exception e) {
			System.out.println("Problem Occured at the time of Configuration, kindly check your concerned classes");
			e.printStackTrace();
		}finally {
			sessionFactory.close();
		}
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
