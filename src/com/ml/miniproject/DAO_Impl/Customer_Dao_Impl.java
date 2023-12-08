package com.ml.miniproject.DAO_Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ml.miniproject.DAO.Customer_Dao;
import com.ml.miniproject.config.HibernateUtil;
import com.ml.miniproject.pojo.Customer;

public class Customer_Dao_Impl implements Customer_Dao{

	@Override
	public Customer fetchCustomer(long cid) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			Customer customer=session.load(Customer.class, cid);
			tx.commit();
			session.close();
			return customer;
		} catch (Exception e) {
			System.out.println("Exception occured fetching Customer's details from the database");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Customer> fetchAll() {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			List<Customer> list = new ArrayList<Customer>();
			list = (List<Customer>) session.createNativeQuery("select * from myCstmrs", Customer.class).list();
			tx.commit();
			session.close();
			return list;
		} catch (Exception e) {
			System.out.println("Exception occured fetching a list of Customers from the database");
			e.printStackTrace();
			return null;
		}
	}

}
