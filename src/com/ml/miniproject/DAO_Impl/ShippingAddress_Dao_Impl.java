package com.ml.miniproject.DAO_Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ml.miniproject.DAO.ShippingAddress_Dao;
import com.ml.miniproject.config.HibernateUtil;
import com.ml.miniproject.pojo.ShippingAddress;

public class ShippingAddress_Dao_Impl implements ShippingAddress_Dao {

	@Override
	public void saveShippingAddress(ShippingAddress sa) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			ShippingAddress address = new ShippingAddress(sa.getStreet(), sa.getLocality(), sa.getCity(), sa.getState(), sa.getCountry(), sa.getPincode());
			session.save(address);
			tx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Exception occured while saving shipping address records");
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}

	}

	@Override
	public void updateShippingAddress(ShippingAddress sa) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			ShippingAddress address = new ShippingAddress(sa.getStreet(), sa.getLocality(), sa.getCity(), sa.getState(), sa.getCountry(), sa.getPincode(), sa.getOrder());
			session.update(address);
			tx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Exception occured while updating shipping address records");
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}

	}

	@Override
	public void deleteShippingAddress(long adId) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			ShippingAddress address = session.load(ShippingAddress.class, adId);
			session.delete(address);
			tx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Exception occured while deleting Shipping Address records");
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
			session.createQuery("delete from shippingAddress", ShippingAddress.class).executeUpdate();
			tx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Exception occured while deleting shipping address entries from the database");
			e.printStackTrace();
		}

	}

	@Override
	public ShippingAddress fetchShippingAddress(long adId) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			ShippingAddress address=session.load(ShippingAddress.class, adId);
			tx.commit();
			session.close();
			return address;
		}catch (Exception e) {
			System.out.println("Exception occured while fetching shipping address records");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<ShippingAddress> fetchAll() {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			List<ShippingAddress> list=new ArrayList<ShippingAddress>();
			list=(List<ShippingAddress>)session.createQuery("select * from shippingAddress", ShippingAddress.class).list();
			tx.commit();
			session.close();
			return list;
		} catch (Exception e) {
			System.out.println("Exception occured fetching a list of shipping address from the database");
			e.printStackTrace();
			return null;
		}
	}

}
