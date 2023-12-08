package com.ml.miniproject.pojo;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cCards")
public class CreditCard {
	private long cCardId;
	private long cCardNumber;
	@ManyToOne
	@JoinTable(name="cards_and_customers", joinColumns = @JoinColumn(name="myCardId", referencedColumnName = "cCardId"), 
	inverseJoinColumns = {@JoinColumn(name="myCid", referencedColumnName = "cid"), 
			@JoinColumn(name="myCName", referencedColumnName = "cname")})
	private Customer customer;
	public CreditCard() {}
	public CreditCard(long cCardId, long cCardNumber, Customer customer) {
		super();
		this.cCardId = cCardId;
		this.cCardNumber = cCardNumber;
		this.customer = customer;
	}
	public long getcCardId() {
		return cCardId;
	}
	public void setcCardId(long cCardId) {
		this.cCardId = cCardId;
	}
	public long getcCardNumber() {
		return cCardNumber;
	}
	public void setcCardNumber(long cCardNumber) {
		this.cCardNumber = cCardNumber;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "CreditCard [cCardId=" + cCardId + ", cCardNumber=" + cCardNumber + ", customer=" + customer + "]";
	}
}
