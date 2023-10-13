package com.ml.miniproject.clientCode;

import java.util.HashSet;

import com.ml.miniproject.DAO.Book_Dao;
import com.ml.miniproject.DAO.DAO_Factory;
import com.ml.miniproject.pojo.Author;
import com.ml.miniproject.pojo.Book;
import com.ml.miniproject.pojo.OrderItem;

public class CC_Book {

	public static void main(String[] args) {
		Book_Dao bdao=DAO_Factory.getBookDao();
		//Book Object		
		Book b1=new Book();
		b1.setBookId(010101010101L);
		b1.setBookName("BetaHouse");
		b1.setCost(25.25d);
		b1.setEdition(1);
		b1.setMyAuthors(new HashSet<Author>());
		b1.setMyOrders(new HashSet<OrderItem>());
		b1.setPubYear(2025);
		b1.setVolume(1.1f);
		bdao.saveBook(b1);
	}

}
