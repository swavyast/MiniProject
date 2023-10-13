package com.ml.miniproject.DAO_Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ml.miniproject.DAO.CreditCard_Dao;
import com.ml.miniproject.config.HibernateUtil;
import com.ml.miniproject.pojo.Book;
import com.ml.miniproject.pojo.CreditCard;

public class CreditCard_Dao_Impl implements CreditCard_Dao {

	@Override
	public void saveCreditCard(CreditCard c) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			CreditCard cc = session.load(CreditCard.class, c.getcCardId());
			cc.setCardType(c.getCardType());
			cc.setcCardNumber(c.getcCardNumber());
			cc.setCustomer(c.getCustomer());
			cc.setCvv(c.getCvv());
			cc.setExpDate(c.getExpDate());
			cc.setStatus(c.getStatus());
			session.save(cc);
			tx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Exception occured while saving credit card details");
			e.printStackTrace();
		}
	}

	@Override
	public void updateCreditCard(CreditCard c) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			CreditCard cc = new CreditCard();
			cc.setCardType(c.getCardType());
			cc.setcCardNumber(c.getcCardNumber());
			cc.setCustomer(c.getCustomer());
			cc.setCvv(c.getCvv());
			cc.setExpDate(c.getExpDate());
			cc.setStatus(c.getStatus());
			session.update(cc);
			tx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Exception occured while saving credit card details");
			e.printStackTrace();
		}

	}

	@Override
	public CreditCard fetchCreditCard(long cCardId) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			CreditCard cc = session.load(CreditCard.class, cCardId);
			cc.getCardType();
			cc.getcCardId();
			cc.getcCardNumber();
			cc.getCustomer();
			cc.getCvv();
			cc.getExpDate();
			cc.getStatus();
			tx.commit();
			session.close();
			return cc;
		} catch (Exception e) {
			System.out.println("Exception occured fetching creditcard details from the database");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<CreditCard> fetchAll() {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			List<CreditCard> list = new ArrayList<CreditCard>();
			list = (List<CreditCard>) session.createNativeQuery("select * from cCards").getResultList();
			tx.commit();
			session.close();
			return list;
		} catch (Exception e) {
			System.out.println("Exception occured fetching a list of creditcards from the database");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void deleteCreditCard(long cCardId) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			CreditCard cc = session.load(CreditCard.class, cCardId);
			session.delete(cc);
			tx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Exception occured deleting creditcard details from the database");
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
			session.createNativeQuery("delete from cCards");
			tx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Exception occured while deleting card entries from the database");
			e.printStackTrace();
		}
		
	}

}
