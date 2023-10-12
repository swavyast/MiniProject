package com.ml.miniproject.DAO_Impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ml.miniproject.DAO.Author_Dao;
import com.ml.miniproject.config.HibernateUtil;
import com.ml.miniproject.pojo.Author;
import com.ml.miniproject.pojo.Book;

public class Author_Dao_Impl implements Author_Dao {

	@Override
	public Author getAuthorById(long aid) {

		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			Author auth = session.load(Author.class, aid);
			Author a=new Author();
			a.setAuthorId(auth.getAuthorId());
			a.setAuthorName(auth.getAuthorName());
			a.setEmail(auth.getEmail());
			a.setMyBooks(auth.getMyBooks());
			a.setMyExp(auth.getMyExp());
			a.setPhone(auth.getPhone());
			a.setQualifications(auth.getQualifications());
			a.setSkills(auth.getSkills());
			tx.commit();
			session.close();
			return a;
		} catch (Exception e) {
			System.out.println("Exception Ocuured Fetching Author by Author-Id");
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			return null;
		}
	}

	@Override
	public List<Author> listAuthors(long aid) {

		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			List<Author> listOfAuthors = new ArrayList<Author>();
			while(session.get(Author.class, aid) != null) {
			Author a=session.load(Author.class, aid);
			Author author=new Author();
			author.setAuthorName(a.getAuthorName()); 
			author.setEmail(a.getEmail());
			author.setMyBooks(a.getMyBooks()); 
			author.setMyExp(a.getMyExp()); 
			author.setPhone(a.getPhone()); 
			author.setQualifications(a.getQualifications()); 
			author.setSkills(a.getSkills());
			listOfAuthors.add(author);
			}
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

	@Override
	public void saveAuthor(Author ath) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			Author a=new Author();
			a.setAuthorName(ath.getAuthorName());
			a.setEmail(ath.getEmail());
			a.setMyBooks(ath.getMyBooks());
			a.setMyExp(ath.getMyExp());
			a.setPhone(ath.getPhone());
			a.setQualifications(ath.getQualifications());
			a.setSkills(ath.getSkills());
			session.save(a);
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
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			Author a=new Author();
			a.setAuthorId(ath.getAuthorId());
			a.setAuthorName(ath.getAuthorName());
			a.setEmail(ath.getEmail());
			a.setMyBooks(ath.getMyBooks());
			a.setMyExp(ath.getMyExp());
			a.setPhone(ath.getPhone());
			a.setQualifications(ath.getQualifications());
			a.setSkills(ath.getSkills());
			session.update(a);
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
		try {
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

}
