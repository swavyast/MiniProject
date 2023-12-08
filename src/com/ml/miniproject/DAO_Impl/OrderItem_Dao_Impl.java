package com.ml.miniproject.DAO_Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ml.miniproject.DAO.OrderItem_Dao;
import com.ml.miniproject.config.HibernateUtil;
import com.ml.miniproject.pojo.OrderItem;

public class OrderItem_Dao_Impl implements OrderItem_Dao {

	@Override
	public void saveOrderItem(OrderItem oi) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			OrderItem item = new OrderItem(oi.getItemCost(), oi.getItemCount(),  oi.getStatus());
			session.save(item);
			tx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Exception occured while saving order item records");
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}
		
	}

	@Override
	public void updateOrderItem(OrderItem oi) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			OrderItem item = new OrderItem(oi.getItemCost(), oi.getItemCount(),  oi.getStatus(),  oi.getMyBook());
			session.update(item);
			tx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Exception occured while updating order item records");
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}
		
	}

	@Override
	public void deleteOrderItem(long orderId) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			OrderItem item = session.load(OrderItem.class, orderId);
			session.delete(item);
			tx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Exception occured while deleting order item records");
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
			session.createQuery("delete from orderItems", OrderItem.class).executeUpdate();
			tx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Exception occured while deleting list of order items from the database");
			e.printStackTrace();
		}
		
	}

	@Override
	public OrderItem fetchOrderItem(long orderId) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			OrderItem item=session.load(OrderItem.class, orderId);
			tx.commit();
			session.close();
			return item;
		}catch (Exception e) {
			System.out.println("Exception occured while fetching order item records");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<OrderItem> fetchAll() {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			List<OrderItem> list=new ArrayList<OrderItem>();
			list=(List<OrderItem>)session.createQuery("select * from orderItems", OrderItem.class).list();
			tx.commit();
			session.close();
			return list;
		} catch (Exception e) {
			System.out.println("Exception occured fetching a list of order item from the database");
			e.printStackTrace();
			return null;
		}
	}

}
