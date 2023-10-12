package com.ml.miniproject.pojo;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long orderId;
	private Date orderDate;
	private int orderQuantity;
	private double orderCost;
	private Date deliveryDate;
	private String status;
	@ManyToOne
	@JoinColumn(name="myCid", referencedColumnName = "cid")
	private Customer customer;
	@OneToOne
	@JoinColumn(name="myAdId", referencedColumnName = "adId")
	private ShippingAddress myAddress;
	@OneToMany(mappedBy = "order")
	private Set<OrderItem> myOrderItems;
	public Order() {}
	public Order(Date orderDate, int orderQuantity, double orderCost, Date deliveryDate, String status,
			Customer customer, ShippingAddress myAddress, Set<OrderItem> myOrderItems) {
		super();
		this.orderDate = orderDate;
		this.orderQuantity = orderQuantity;
		this.orderCost = orderCost;
		this.deliveryDate = deliveryDate;
		this.status = status;
		this.customer = customer;
		this.myAddress = myAddress;
		this.myOrderItems = myOrderItems;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	public double getOrderCost() {
		return orderCost;
	}
	public void setOrderCost(double orderCost) {
		this.orderCost = orderCost;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public ShippingAddress getMyAddress() {
		return myAddress;
	}
	public void setMyAddress(ShippingAddress myAddress) {
		this.myAddress = myAddress;
	}
	public Set<OrderItem> getMyOrderItems() {
		return myOrderItems;
	}
	public void setMyOrderItems(Set<OrderItem> myOrderItems) {
		this.myOrderItems = myOrderItems;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", orderQuantity=" + orderQuantity
				+ ", orderCost=" + orderCost + ", deliveryDate=" + deliveryDate + ", status=" + status + ", customer="
				+ customer + ", myAddress=" + myAddress + ", myOrderItems=" + myOrderItems + "]";
	}
}
