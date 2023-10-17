package com.ml.miniproject.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

@Entity
@Table(name="orderItems")
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "oiId")
	private long itemId;
	//@Formula("itemCost=cost")
	@Column(name = "oiCost")
	private double itemCost;
	@Column(name = "oiCount")
	private short itemCount;
	@Column(name = "oiStatus")
	private String status;
	@ManyToOne
	@JoinColumn(name = "myBookId", referencedColumnName = "bookId")
	private Book myBook;
	@ManyToOne
	@JoinColumn(name="myOrderId", referencedColumnName = "orderId")
	private Order order;
	public OrderItem() {}

	public OrderItem(double itemCost, short itemCount, String status) {
		this.itemCost = itemCost;
		this.itemCount = itemCount;
		this.status = status;
	}

	public OrderItem(double itemCost, short itemCount, String status, Book myBook) {
		this.itemCost = itemCost;
		this.itemCount = itemCount;
		this.status = status;
		this.myBook = myBook;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public double getItemCost() {
		return itemCost;
	}

	public void setItemCost(double itemCost) {
		this.itemCost = itemCost;
	}

	public short getItemCount() {
		return itemCount;
	}

	public void setItemCount(short itemCount) {
		this.itemCount = itemCount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Book getMyBook() {
		return myBook;
	}

	public void setMyBook(Book myBook) {
		this.myBook = myBook;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "OrderItem [itemId=" + itemId + ", itemCost=" + itemCost + ", itemCount=" + itemCount + ", status="
				+ status + ", myBook=" + myBook + ", order=" + order + "]";
	}
}
