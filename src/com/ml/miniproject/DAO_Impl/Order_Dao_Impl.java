package com.ml.miniproject.DAO_Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ml.miniproject.DAO.Order_Dao;
import com.ml.miniproject.config.HibernateUtil;
import com.ml.miniproject.pojo.Order;

public class Order_Dao_Impl implements Order_Dao {

	@Override
	public void saveOrder(Order o) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			Order o1=new Order();
			o1.setOrderId(o.getOrderId());
			o1.setOrderDate(o.getOrderDate());
			o1.setStatus(o.getStatus());
			o1.setDeliveryDate(o.getDeliveryDate());
			o1.setOrderQuantity(o.getOrderQuantity());
			o1.setOrderCost(o.getOrderCost());
			o1.setMyAddress(o.getMyAddress());
			o1.setMyOrderItems(o.getMyOrderItems());
			session.save(o1);
			tx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Exception Occured While Saving Order Records");
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}
		
	}

	@Override
	public void upateOrder(Order o) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			Order o1= session.load(Order.class, o.getOrderId());
			o1.setOrderId(o.getOrderId());
			o1.setOrderDate(o.getOrderDate());
			o1.setStatus(o.getStatus());
			o1.setDeliveryDate(o.getDeliveryDate());
			o1.setOrderQuantity(o.getOrderQuantity());
			o1.setOrderCost(o.getOrderCost());
			o1.setMyAddress(o.getMyAddress());
			o1.setMyOrderItems(o.getMyOrderItems());
			session.update(o1);
			tx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Exception Occured While Saving Order Records");
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}
		
	}

	@Override
	public void deleteOrder(long oid) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			Order o1=session.load(Order.class, oid);
			session.delete(o1);
			tx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Exception Occured While Saving Order Records");
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}
		
	}

	@Override
	public void deleteAll() {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			session.createNativeQuery("delete from orders");
			tx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Exception occured while deleting order entries from the database");
			e.printStackTrace();
		}
		
	}

	@Override
	public Order fetchOrder(long oid) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			Order o = session.load(Order.class, oid);
			o.getOrderId();
			o.getStatus();
			o.getCustomer();
			o.getOrderDate();
			o.getDeliveryDate();
			o.getMyAddress();
			o.getOrderQuantity();
			o.getOrderCost();
			o.getMyOrderItems();
			tx.commit();
			session.close();
			return o;
		} catch (Exception e) {
			System.out.println("Exception Ocuured Fetching Order details from the database");
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			return null;
		}
	}

	@Override
	public List<Order> fetchAll() {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			List<Order> list=new ArrayList<Order>();
			list=(List<Order>)session.createNativeQuery("select * from orders").getResultList();
			tx.commit();
			session.close();
			return list;
		} catch (Exception e) {
			System.out.println("Exception occured fetching a list of orders from the database");
			e.printStackTrace();
			return null;
		}
		}

}
