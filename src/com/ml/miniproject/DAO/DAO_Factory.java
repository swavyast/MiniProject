package com.ml.miniproject.DAO;

import java.util.List;

import com.ml.miniproject.DAO_Impl.Author_Dao_Impl;
import com.ml.miniproject.DAO_Impl.Book_Dao_Impl;
import com.ml.miniproject.DAO_Impl.CreditCard_Dao_Impl;
import com.ml.miniproject.DAO_Impl.Customer_Dao_Impl;
import com.ml.miniproject.DAO_Impl.GoldCustomer_Dao_Impl;
import com.ml.miniproject.DAO_Impl.OrderItem_Dao_Impl;
import com.ml.miniproject.DAO_Impl.Order_Dao_Impl;
import com.ml.miniproject.DAO_Impl.ShippingAddress_Dao_Impl;
import com.ml.miniproject.DAO_Impl.SilverCustomer_Dao_Impl;
import com.ml.miniproject.pojo.Author;
import com.ml.miniproject.pojo.Book;
import com.ml.miniproject.pojo.CreditCard;
import com.ml.miniproject.pojo.Customer;
import com.ml.miniproject.pojo.GoldCustomer;
import com.ml.miniproject.pojo.Order;
import com.ml.miniproject.pojo.OrderItem;
import com.ml.miniproject.pojo.ShippingAddress;
import com.ml.miniproject.pojo.SilverCustomer;

public class DAO_Factory {

	// Author DAO
	static Author_Dao author_Dao;
	static {
		author_Dao = new Author_Dao_Impl();
	}

	public static Author_Dao getAuthorDao() {
		return author_Dao;
	}

	public static void saveAuthor(Author a) {
		author_Dao.saveAuthor(a);
	}

	public static void updateAuthor(Author a) {
		author_Dao.upateAuthor(a);
	}

	public static void deleteAuthor(long aid) {
		author_Dao.deleteAuthor(aid);
	}

	public static void deleteAllAuthors() {
		author_Dao.deleteAll();
	}

	public static Author fetchAuthor(long authorId) {
		return author_Dao.fetchAuthor(authorId);
	}

	// needs to be curated
	public static List<Author> fetchAllAuthors(long id) {
		return author_Dao.listAuthors(id);
	}

	// Book DAO
	static Book_Dao book_Dao;
	static {
		book_Dao = new Book_Dao_Impl();
	}

	public static Book_Dao getBookDao() {
		return book_Dao;
	}

	public static void saveBook(Book b) {
		book_Dao.saveBook(b);
	}

	public static void updateBook(Book b) {
		book_Dao.updateBook(b);
	}

	public static void deleteBook(long bookId) {
		book_Dao.deleteBook(bookId);
	}

	public static void deleteAllBooks() {
		book_Dao.deleteAll();
	}

	public static Book fetchBook(long bookId) {
		return book_Dao.fetchBook(bookId);
	}

	public static List<Book> fetchAllBooks() {
		return book_Dao.fetchAll();
	}

	// Credit Card DAO
	static CreditCard_Dao creditCard_Dao;
	static {
		creditCard_Dao = new CreditCard_Dao_Impl();
	}

	public static CreditCard_Dao getCreditCardDao() {
		return creditCard_Dao;
	}

	public static void saveCreditCard(CreditCard c) {
		creditCard_Dao.saveCreditCard(c);
	}

	public static void updateCreditCard(CreditCard cc) {
		creditCard_Dao.updateCreditCard(cc);
	}

	public static void deleteCreditCard(long cCardId) {
		creditCard_Dao.deleteCreditCard(cCardId);
	}

	public static void deleteAllCreditCards() {
		creditCard_Dao.deleteAll();
	}

	public static CreditCard fetchCreditCard(long cCardId) {
		return creditCard_Dao.fetchCreditCard(cCardId);
	}

	public static List<CreditCard> fetchAllCreditCards() {
		return creditCard_Dao.fetchAll();
	}

	// Customer DAO
	static Customer_Dao customer_Dao;
	static {
		customer_Dao = new Customer_Dao_Impl();
	}

	public static Customer_Dao getCustomerDao() {
		return customer_Dao;
	}

	public static Customer fetchCustomer(long cid) {
		return customer_Dao.fetchCustomer(cid);
	}

	public static List<Customer> fetchCustomers() {
		return customer_Dao.fetchAll();
	}

	// Gold Customer DAO
	static GoldCustomer_Dao goldCustomer_Dao;
	static {
		goldCustomer_Dao = new GoldCustomer_Dao_Impl();
	}

	public static GoldCustomer_Dao getGoldCustomer_Dao() {
		return goldCustomer_Dao;
	}

	public static void saveGoldCustomer(GoldCustomer gc) {
		goldCustomer_Dao.saveGoldCustomer(gc);
	}

	public static void updateGoldCustomer(GoldCustomer gc) {
		goldCustomer_Dao.updateGoldCustomer(gc);
	}

	public static void deleteGoldCustomer(long cid) {
		goldCustomer_Dao.deleteGoldCustomer(cid);
	}

	public static void deleteAllGolCustomers() {
		goldCustomer_Dao.deleteAll();
	}

	public static GoldCustomer fetchGoldCustomers(long cid) {
		return goldCustomer_Dao.fetchGoldCustomer(cid);
	}

	public static List<GoldCustomer> fetchAllGoldCustomers() {
		return goldCustomer_Dao.fetchAll();
	}

	// Order DAO

	static Order_Dao order_Dao;
	static {
		order_Dao = new Order_Dao_Impl();
	}

	public static Order_Dao getOrderDao() {
		return order_Dao;
	}

	public static void saveOrder(Order o) {
		order_Dao.saveOrder(o);
	}

	public static void updateGoldCustomer(Order o) {
		order_Dao.upateOrder(o);
	}

	public static void deleteOrder(long oid) {
		order_Dao.deleteOrder(oid);
	}

	public static void deleteAllOrders() {
		order_Dao.deleteAll();
	}

	public static Order fetchOrder(long oid) {
		return order_Dao.fetchOrder(oid);
	}

	public static List<Order> fetchAllOrders() {
		return order_Dao.fetchAll();
	}

	// OrderItem DAO
	static OrderItem_Dao orderItem_Dao;
	static {
		orderItem_Dao = new OrderItem_Dao_Impl();
	}

	public static OrderItem_Dao getOrderItemDao() {
		return orderItem_Dao;
	}

	public static void saveOrderItem(OrderItem oi) {
		orderItem_Dao.saveOrderItem(oi);
	}

	public static void updateOrderItem(OrderItem oi) {
		orderItem_Dao.updateOrderItem(oi);
	}

	public static void deleteOrderItem(long itemId) {
		orderItem_Dao.deleteOrderItem(itemId);
	}

	public static void deleteAllOrderItems() {
		orderItem_Dao.deleteAll();
	}

	public static OrderItem fetchOrderItem(long itemId) {
		return orderItem_Dao.fetchOrderItem(itemId);
	}

	public static List<OrderItem> fetchAllOrderItems() {
		return orderItem_Dao.fetchAll();
	}

	// ShippingAddress DAO
	static ShippingAddress_Dao shippingAddress_Dao;
	static {
		shippingAddress_Dao = new ShippingAddress_Dao_Impl();
	}

	public static ShippingAddress_Dao getShippingAddress_Dao() {
		return shippingAddress_Dao;
	}

	public static void saveShippingAddress(ShippingAddress sa) {
		shippingAddress_Dao.saveShippingAddress(sa);
	}

	public static void updateShippingAddress(ShippingAddress sa) {
		shippingAddress_Dao.updateShippingAddress(sa);
	}

	public static void deleteShippingAddress(long adId) {
		shippingAddress_Dao.deleteShippingAddress(adId);
	}

	public static void deleteAllShippingAddresses() {
		shippingAddress_Dao.deleteAll();
	}

	public static ShippingAddress fetchShippingAddress(long adId) {
		return shippingAddress_Dao.fetchShippingAddress(adId);
	}

	public static List<ShippingAddress> fetchAllShippingAddresses() {
		return shippingAddress_Dao.fetchAll();
	}

	// Silver Customer DAO
	static SilverCustomer_Dao silverCustomer_Dao;
	static {
		silverCustomer_Dao = new SilverCustomer_Dao_Impl();
	}

	public static SilverCustomer_Dao getSilverCustomer_Dao() {
		return silverCustomer_Dao;
	}

	public static void saveSilverCustomer(SilverCustomer sc) {
		silverCustomer_Dao.saveSilverCustomer(sc);
	}

	public static void updateSilverCustomer(SilverCustomer sc) {
		silverCustomer_Dao.updateSilverCustomer(sc);
	}

	public static void deleteSilverCustomer(long cid) {
		silverCustomer_Dao.deleteSilverCustomer(cid);
	}

	public static void deleteAllSilverCustomers() {
		silverCustomer_Dao.deleteAll();
	}

	public static SilverCustomer fetchSilverCustomer(long cid) {
		return silverCustomer_Dao.fetchSilverCustomer(cid);
	}

	public static List<SilverCustomer> fetchAllSilverCustomers() {
		return silverCustomer_Dao.fetchAll();
	}
}
