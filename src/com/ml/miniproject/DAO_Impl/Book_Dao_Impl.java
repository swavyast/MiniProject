package com.ml.miniproject.DAO_Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.ml.miniproject.DAO.Book_Dao;
import com.ml.miniproject.config.HibernateUtil;
import com.ml.miniproject.pojo.Author;
import com.ml.miniproject.pojo.Book;

public class Book_Dao_Impl implements Book_Dao {

	@Override
	public void saveBook(Book b) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			Book b1 = new Book(b.getBookName(), b.getCost(), b.getEdition(), b.getVolume(), b.getPubYear(), b.getStatus());
			session.save(b1);
			tx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Exception occured while saving book records");
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}
	}

	@Override
	public void updateBook(Book b) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			Book b1 = new Book(b.getBookName(), b.getCost(), b.getEdition(), b.getVolume(), b.getPubYear(), b.getStatus(), b.getMyAuthors(), b.getMyOrderItems());
			session.update(b1);
			tx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Exception occured while updating book records");
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}

	}

	@Override
	public Book fetchBook(long bookId) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			Book b1=session.load(Book.class, bookId);
			Book b=new Book();
			b.setBookId(bookId);
			b.setBookName(b1.getBookName());
			b.setCost(b1.getCost());
			b.setEdition(b1.getEdition());
			b.setMyAuthors(b1.getMyAuthors());
			b.setMyOrderItems(b1.getMyOrderItems());
			b.setMyOrders(b1.getMyOrders());
			b.setPubYear(b1.getPubYear());
			b.setStatus(b1.getStatus());
			b.setVolume(b1.getVolume());
			tx.commit();
			session.close();
			return b1;
		}catch (Exception e) {
			System.out.println("Exception occured while fetching book records");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Book> fetchAll() {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			List<Book> list=new ArrayList<Book>();
			list=(List<Book>)session.createQuery("select * from books", Book.class).list(); //.getResultList();
			tx.commit();
			session.close();
			return list;
		} catch (Exception e) {
			System.out.println("Exception occured fetching a list of books from the database");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void deleteBook(long bookId) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			Book b1 = session.load(Book.class, bookId);
			session.delete(b1);
			tx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Exception occured while deleting book records");
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
			session.createQuery("delete from books", Book.class).executeUpdate();
			tx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Exception occured while deleting book entries from the database");
			e.printStackTrace();
		}
		
	}
	
}
