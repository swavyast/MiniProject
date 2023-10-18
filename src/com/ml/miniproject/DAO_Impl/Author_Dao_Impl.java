package com.ml.miniproject.DAO_Impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ml.miniproject.DAO.Author_Dao;
import com.ml.miniproject.config.HibernateUtil;
import com.ml.miniproject.pojo.Author;

public class Author_Dao_Impl implements Author_Dao {
	
	@Override
	public void saveAuthor(Author ath) {
		Transaction tx = null;
		try  /*(Session session=HibernateUtil.getSessionFactory().openSession())*/{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			//Author a=new Author(ath.getAuthorName(), ath.getEmail(), ath.getPhone(), ath.getSkills(), ath.getQualifications(), ath.getMyExp(), ath.getMyBooks());
			session.save(ath);
			tx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Exception Occured While Saving Author's Records");
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}
	}

	@Override
	public void upateAuthor(Author ath) {
		Transaction tx = null;
		try  /*(Session session=HibernateUtil.getSessionFactory().openSession())*/{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			//Author a=new Author(ath.getAuthorName(), ath.getEmail(), ath.getPhone(), ath.getSkills(), ath.getQualifications(), ath.getMyExp(), ath.getMyBooks());
			session.saveOrUpdate(ath);
			tx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Exception Occured Updating Author's Records");
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}

	}

	@Override
	public void deleteAuthor(long aid) {
		Transaction tx = null;
		try  /*(Session session=HibernateUtil.getSessionFactory().openSession())*/{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			Author a=session.load(Author.class, aid);
			session.delete(a);
			tx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Exception Occured Deleting Author by Author-Id");
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}

	}

	@Override
	public void deleteAll() {
		Transaction tx = null;
		try  /*(Session session=HibernateUtil.getSessionFactory().openSession())*/{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			session.createQuery("delete from authors").executeUpdate();
			tx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Exception occured while deleting author entries from the database");
			e.printStackTrace();
		}
		
	}
	@Override
	public Author fetchAuthor(long aid) {

		Transaction tx = null;
		try  /*(Session session=HibernateUtil.getSessionFactory().openSession())*/{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			Author auth = session.load(Author.class, aid);
			tx.commit();
			session.close();
			return auth;
		} catch (Exception e) {
			System.out.println("Exception Ocuured Fetching Author by Author-Id");
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Author> listAuthors(long aid) {

		Transaction tx = null;
		try /*(Session session=HibernateUtil.getSessionFactory().openSession())*/{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			List<Author> listOfAuthors = new ArrayList<Author>();
			listOfAuthors=session.createQuery("from authors").list();
			tx.commit();
			session.close();
			return listOfAuthors;
		} catch (Exception e) {
			System.out.println("Exception Ocuured Fetching List of Authors");
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			return null;
		}
	}
}
