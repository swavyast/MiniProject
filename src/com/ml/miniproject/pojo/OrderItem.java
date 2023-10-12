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
	@Column(name = "itemId")
	private long itemId;
	@Formula("itemCost=cost")
	@Column(nullable = true)
	private double itemCost;
	@Column(nullable = true)
	private short itemCount;
	@Column(nullable = true)
	private double shippingCost;
	@Formula("itemCost*itemCount+shippingCost")
	@Column(nullable = true)
	private double totalCost;
	@ManyToOne
	@JoinColumns(value = @JoinColumn(name = "myBooks", referencedColumnName = "bookId"))
	private Book myBook;
	@ManyToOne
	@JoinColumn(name="myOid", referencedColumnName = "orderId")
	private Order order;
	public OrderItem() {}
	public OrderItem(Book myBook, double itemCost, short itemCount, double shippingCost, double totalCost,
			Order order) {
		super();
		this.myBook = myBook;
		this.itemCost = itemCost;
		this.itemCount = itemCount;
		this.shippingCost = shippingCost;
		this.totalCost = totalCost;
		this.order = order;
	}
	public long getItemId() {
		return itemId;
	}
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
	public Book getMyBook() {
		return myBook;
	}
	public void setMyBook(Book myBook) {
		this.myBook = myBook;
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
	public double getShippingCost() {
		return shippingCost;
	}
	public void setShippingCost(double shippingCost) {
		this.shippingCost = shippingCost;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "OrderItem [itemId=" + itemId + ", myBook=" + myBook + ", itemCost=" + itemCost + ", itemCount="
				+ itemCount + ", shippingCost=" + shippingCost + ", totalCost=" + totalCost + ", order=" + order + "]";
	}
}
