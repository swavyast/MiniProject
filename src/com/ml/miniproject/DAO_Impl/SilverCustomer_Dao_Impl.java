package com.ml.miniproject.DAO_Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ml.miniproject.DAO.SilverCustomer_Dao;
import com.ml.miniproject.config.HibernateUtil;
import com.ml.miniproject.pojo.SilverCustomer;

public class SilverCustomer_Dao_Impl implements SilverCustomer_Dao {

	@Override
	public void saveSilverCustomer(SilverCustomer sc) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			SilverCustomer customer = new SilverCustomer(sc.getSupportEmail(), sc.getShippingCharges(), 
				sc.getDiscounts(), sc.getHandlingCharges());
			session.save(customer);
			tx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Exception occured while saving silver customer records");
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}

	}

	@Override
	public void updateSilverCustomer(SilverCustomer sc) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			SilverCustomer customer = new SilverCustomer(sc.getCname(), sc.getEmail(), sc.getPhone(), 
				sc.getDob(), sc.getSupportEmail(), sc.getShippingCharges(), sc.getDiscounts(), 
				sc.getHandlingCharges());
			session.update(customer);
			tx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Exception occured while updating silver customer records");
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}

	}

	@Override
	public SilverCustomer fetchSilverCustomer(long cid) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			SilverCustomer customer = session.load(SilverCustomer.class, cid);
			tx.commit();
			session.close();
			return customer;
		}catch (Exception e) {
			System.out.println("Exception occured while fetching silver customer records");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<SilverCustomer> fetchAll() {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			List<SilverCustomer> list=new ArrayList<SilverCustomer>();
			list=(List<SilverCustomer>)session.createQuery("select * from silverCustomers", SilverCustomer.class)
				.list();
			tx.commit();
			session.close();
			return list;
		} catch (Exception e) {
			System.out.println("Exception occured fetching a list of silver customers from the database");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void deleteSilverCustomer(long cid) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			SilverCustomer customer = session.load(SilverCustomer.class, cid);
			session.delete(customer);
			tx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Exception occured while deleting silver customer records");
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
			session.createQuery("delete from silverCustomers", SilverCustomer.class).executeUpdate();
			tx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Exception occured while deleting silver customer entries from the database");
			e.printStackTrace();
		}

	}

}
