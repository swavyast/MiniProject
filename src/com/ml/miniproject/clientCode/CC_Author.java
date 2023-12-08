package com.ml.miniproject.clientCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
//import java.awt.print.Book;

import com.ml.miniproject.DAO.Author_Dao;
import com.ml.miniproject.DAO.Book_Dao;
import com.ml.miniproject.DAO.DAO_Factory;
import com.ml.miniproject.pojo.Author;
import com.ml.miniproject.pojo.Book;

public class CC_Author {

	public static void main(String[] args) {
		Author_Dao adao = DAO_Factory.getAuthorDao();
		Book_Dao bdao=DAO_Factory.getBookDao();
		Book b1=new Book("Java", 500L, 1, 1.1f, 2025, "To Be Published");
		bdao.saveBook(b1);
		Book b2=new Book("C++", 400L, 5, 5.9f, 2021, "Available");
		bdao.saveBook(b2);
		Book b3=new Book("C#", 300L, 3, 3.0f, 2022, "Out of Stock");
		bdao.saveBook(b3);
		
		Set<String> skills = new HashSet<String>();
		skills.add("Writer");
		skills.add("Poet");
		
		List<String> qual = new ArrayList<String>();
		qual.add("Diploma in Information Technology");
		qual.add("B. Tech. in Computer Science and Engineering");
		
		Map<String, Integer> exp = new HashMap<String, Integer>();
		exp.put("Omni-Net Technologies Pvt. Ltd., Lucknow", 1);
		exp.put("Lucknow Institute of Technology, Lucknow", 2);
		
		Set<Author> authors = new HashSet<Author>();
		Set<Book> books = new HashSet<Book>();
		Author author1 = new Author("Himanshu Rai", "swavyast@gmail.com", 7275855535L, skills, qual, exp, books);
		adao.saveAuthor(author1);
		Author author2 = new Author("Sudhanshu Rai", "avyast@gmail.com", 7375855535L, skills, qual, exp, books);
		adao.saveAuthor(author2);
		Author author3 = new Author("Sitanshu Rai", "wavyast@gmail.com", 7475855535L, skills, qual, exp, books);
		adao.saveAuthor(author3);
		
		authors.add(author1);
		b1.setMyAuthors(authors);
		authors=new HashSet<Author>();
		authors.add(author2);
		authors.add(author3);
		b2.setMyAuthors(authors);
		authors=new HashSet<Author>();
		authors.add(author1);
		authors.add(author2);
		authors.add(author3);
		b3.setMyAuthors(authors);
	}

}
