package com.ml.miniproject.DAO;

import com.ml.miniproject.DAO_Impl.Author_Dao_Impl;
import com.ml.miniproject.DAO_Impl.Book_Dao_Impl;
import com.ml.miniproject.DAO_Impl.CreditCard_Dao_Impl;
import com.ml.miniproject.pojo.Author;
import com.ml.miniproject.pojo.Book;
import com.ml.miniproject.pojo.CreditCard;

public class DAO_Factory {
	
	//Author DAO
	static Author_Dao author_Dao;
	static {
		author_Dao=new Author_Dao_Impl();
	}
	public static Author_Dao getAuthorDao() {
		return author_Dao;
	}
	public static void saveAuthor(Author a) {
		author_Dao.saveAuthor(a);
	}
	//Book DAO
	static Book_Dao book_Dao;
	static {
		book_Dao=new Book_Dao_Impl();
	}
	public static Book_Dao getBookDao() {
		return book_Dao;
	}
	public static void saveBook(Book b) {
		book_Dao.saveBook(b);
	}
	
	//Credit Card DAO
	static CreditCard_Dao creditCard_Dao;
	static {
		creditCard_Dao=new CreditCard_Dao_Impl();
	}
	public static CreditCard_Dao getCreditCardDao() {
		return creditCard_Dao;
	}
	public static void saveCreditCard(CreditCard c) {
		creditCard_Dao.saveCreditCard(c);
	}
}
