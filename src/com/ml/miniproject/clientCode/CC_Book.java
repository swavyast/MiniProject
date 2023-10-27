package com.ml.miniproject.clientCode;

import java.util.HashSet;
import java.util.Set;

import com.ml.miniproject.DAO.Author_Dao;
import com.ml.miniproject.DAO.Book_Dao;
import com.ml.miniproject.DAO.DAO_Factory;
import com.ml.miniproject.pojo.Author;
import com.ml.miniproject.pojo.Book;

public class CC_Book {

	public static void main(String[] args) {
	    	Author_Dao adao=DAO_Factory.getAuthorDao();
		Book_Dao bdao=DAO_Factory.getBookDao();
		
		//Author Objects	
		Set<Author> authors=new HashSet<Author>();
		Author a1= new Author();
		a1=adao.fetchAuthor(1);		//loading Author by id
		System.out.println(a1);
		Author a2=new Author();
		a2=adao.fetchAuthor(2);
		System.out.println(a2);
		Author a3=new Author();
		a3=adao.fetchAuthor(3);
		System.out.println(a3);
		authors.add(a1);		//feeding values into Set<Author>
		System.out.println(authors);
		
		//Book1 Object
		Book b1=new Book();
		b1=bdao.fetchBook(1);		//loading Book by id
		System.out.println(b1);
		b1.setMyAuthors(authors);
		System.out.println(b1);
		authors=new HashSet<Author>();
		authors.add(a2);
		authors.add(a3);
		System.out.println(authors);
		
		//Book2 Object
		Book b2= new Book(); 
		b2=bdao.fetchBook(2);
		System.out.println(b2);
		b2.setMyAuthors(authors);	//Updating Book's myAuthors property
		System.out.println(b2);
		authors=new HashSet<Author>();
		authors.add(a1);
		authors.add(a2);
		authors.add(a3);
		System.out.println(authors);
		
		//Book3 Object
		Book b3=new Book();
		b3=bdao.fetchBook(3);
		System.out.println(b3);
		b3.setMyAuthors(authors);
		System.out.println(b3);
	}

}
