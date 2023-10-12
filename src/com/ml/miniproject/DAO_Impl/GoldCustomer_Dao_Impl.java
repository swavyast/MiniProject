package com.ml.miniproject.DAO_Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ml.miniproject.DAO.GoldCustomer_Dao;
import com.ml.miniproject.config.HibernateUtil;
import com.ml.miniproject.pojo.GoldCustomer;

public class GoldCustomer_Dao_Impl implements GoldCustomer_Dao {

	@Override
	public void saveGoldCustomer(GoldCustomer gc) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			GoldCustomer gold = new GoldCustomer();
			gold.setCid(gc.getCid());
			gold.setCname(gc.getCname());
			gold.setEmail(gc.getEmail());
			gold.setDob(gc.getDob());
			gold.setPhone(gc.getPhone());
			gold.setSupportPhone(gc.getSupportPhone());
			gold.setRpoints(gc.getRpoints());
			gold.setEarlyAccess(gc.isEarlyAccess());
			gold.setMyCards(gc.getMyCards());
			gold.setMyOrders(gc.getMyOrders());
			session.save(gold);
			tx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Exception occured while saving gold customer details");
			e.printStackTrace();
		}

	}

	@Override
	public void updateGoldCustomer(GoldCustomer gc) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			GoldCustomer gold = new GoldCustomer();
			gold.setCid(gc.getCid());
			gold.setCname(gc.getCname());
			gold.setEmail(gc.getEmail());
			gold.setDob(gc.getDob());
			gold.setPhone(gc.getPhone());
			gold.setSupportPhone(gc.getSupportPhone());
			gold.setRpoints(gc.getRpoints());
			gold.setEarlyAccess(gc.isEarlyAccess());
			gold.setMyCards(gc.getMyCards());
			gold.setMyOrders(gc.getMyOrders());
			session.update(gold);
			tx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Exception occured while saving gold customer details");
			e.printStackTrace();
		}

	}

	@Override
	public GoldCustomer fetchGoldCustomer(long cid) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			GoldCustomer gc = session.load(GoldCustomer.class, cid);
			gc.getCid();
			gc.getCname();
			gc.getEmail();
			gc.getDob();
			gc.getPhone();
			gc.getSupportPhone();
			gc.getRpoints();
			gc.getMyCards();
			gc.getMyOrders();
			gc.getCashback();
			tx.commit();
			session.close();
			return gc;
		} catch (Exception e) {
			System.out.println("Exception occured fetching gold customer details from the database");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<GoldCustomer> fetchAll() {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			List<GoldCustomer> list = new ArrayList<GoldCustomer>();
			list = (List<GoldCustomer>) session.createNativeQuery("select * from goldCustomers").getResultList();
			tx.commit();
			session.close();
			return list;
		} catch (Exception e) {
			System.out.println("Exception occured fetching a list of gold customers from the database");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void deleteGoldCustomer(long cid) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			GoldCustomer gc = session.load(GoldCustomer.class, cid);
			session.delete(gc);
			tx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Exception occured fetching gold customer details from the database");
			e.printStackTrace();
		}

	}

	@Override
	public void deleteAll() {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			session.createNativeQuery("delete from goldCustomers");
			tx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Exception occured while deleting gold customer entries from the database");
			e.printStackTrace();
		}
		
	}

}
