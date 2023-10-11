package com.ml.miniproject.DAO_Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ml.miniproject.DAO.Author_Dao;
import com.ml.miniproject.config.HibernateUtil;
import com.ml.miniproject.pojo.Author;

public class Author_Dao_Impl implements Author_Dao {
	SessionFactory sf=HibernateUtil.getSessionFactory();
	Session session=sf.openSession();
	Transaction tx=null;
	@Override
	public Author getAuthorById(long aid) {
		tx=session.beginTransaction();
		Author auth=session.get(Author.class, aid);
		return auth;
	}

	@Override
	public List<Author> listAuthors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveAuthor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void upateAuthor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAuthor() {
		// TODO Auto-generated method stub
		
	}
	
}
