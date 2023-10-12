package com.ml.miniproject.clientCode;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;

import com.ml.miniproject.DAO.Author_Dao;
import com.ml.miniproject.DAO_Impl.Author_Dao_Impl;
import com.ml.miniproject.pojo.Author;
import com.ml.miniproject.pojo.Book;
import com.ml.miniproject.pojo.CreditCard;
import com.ml.miniproject.pojo.Order;
import com.ml.miniproject.pojo.OrderItem;
import com.ml.miniproject.pojo.ShippingAddress;
import com.ml.miniproject.pojo.SilverCustomer;

public class SaveAuthor {

	public static void main(String[] args) {
		Author_Dao adao=new Author_Dao_Impl();
		Set<String> skills=new HashSet<String>();
		skills.add("Writer");
		skills.add("Poet");
		List<String> qual=new ArrayList<String>();
		qual.add("Diploma in Information Technology");
		qual.add("B. Tech. in Computer Science and Engineering");
		Map<String, Integer> exp= new HashMap<String, Integer>();
		exp.put("Omni-Net Technologies Pvt. Ltd., Lucknow", 1);
		exp.put("Lucknow Institute of Technology, Lucknow", 2);
		Set<Book> books=new HashSet<Book>();
		Set<OrderItem> orderItemSet=new HashSet<OrderItem>();
		Set<CreditCard> cards=new HashSet<CreditCard>();
		Set<Order> orders=new HashSet<Order>();
		Set<Author> authors=new HashSet<Author>();
		
		//Credit Card Object
		CreditCard mycard=new CreditCard();
		mycard.setCardType("Silver");
		mycard.setcCardNumber(45893567124638L);
		mycard.setCustomer(new SilverCustomer());
		mycard.setCvv((short)369);
		mycard.setExpDate(new Date());
		mycard.setStatus("Active");
		
		cards.add(mycard);
		
		//Order Object
		Order order=new Order();
		order.setCustomer(new SilverCustomer());
		order.setDeliveryDate(new Date());
		order.setMyAddress(new ShippingAddress());
		order.setMyOrderItems(new HashSet<OrderItem>());
		order.setOrderCost(100);
		order.setOrderDate(new Date());
		order.setOrderQuantity(1);
		order.setStatus("Order Placed");
		
		orders.add(order);
		
		//Shipping Address Object
		ShippingAddress add=new ShippingAddress();
		add.setStreet("Street No-6");
		add.setLocality("Choura");
		add.setCity("Noida");
		add.setState("Uttar Pradesh");
		add.setCountry("India");
		add.setPincode(201301);
		add.setOrder(order);
		order.setMyAddress(add);
		
		//Silver Customer Object
		SilverCustomer sc=new SilverCustomer();
		sc.setCname("Prateek Raj Giri");
		sc.setDob(new Date(13_09_1992));
		sc.setEmail("pratekkgiri91@gmail.com");
		sc.setHandlingCharges(0);
		sc.setMyCards(new HashSet<CreditCard>());
		sc.setMyOrders(new HashSet<Order>());
		sc.setPhone(9911883675L);
		sc.setShippingCharges(0);
		sc.setSupportEmail("pratekkgiri91@gmail.com");
		order.setCustomer(sc);
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
		books.add(b1);
		//Order Item Object
		OrderItem oitem=new OrderItem();
		oitem.setItemCost(0);
		oitem.setItemCount((short)1);
		oitem.setMyBook(new Book());
		oitem.setOrder(new Order());
		oitem.setShippingCost(0);
		oitem.setTotalCost(0);
		orderItemSet.add(oitem);
		order.setMyOrderItems(orderItemSet);
		b1.setMyOrders(orderItemSet);
		Author auth=new Author("Himanshu Rai", "swavyast@gmail.com", 7275855535L, skills, qual, exp, books);
		authors.add(auth);
		adao.saveAuthor(auth);
	}

}
