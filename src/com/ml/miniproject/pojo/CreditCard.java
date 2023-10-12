package com.ml.miniproject.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cCards")
public class CreditCard {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cCardId;
	private long cCardNumber;
	private String cardType;
	private Date expDate;
	private short cvv;
	private String status;
	@ManyToOne
	@JoinTable(name="cards_and_customers", joinColumns = @JoinColumn(name="myCardId", referencedColumnName = "cCardId"), 
	inverseJoinColumns = @JoinColumn(name="myCid", referencedColumnName = "cid"))
	private Customer customer;
	public CreditCard() {}
	public CreditCard(long cCardNumber, String cardType, Date expDate, short cvv, String status, Customer customer) {
		super();
		this.cCardNumber = cCardNumber;
		this.cardType = cardType;
		this.expDate = expDate;
		this.cvv = cvv;
		this.status = status;
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
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	public short getCvv() {
		return cvv;
	}
	public void setCvv(short cvv) {
		this.cvv = cvv;
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
	@Override
	public String toString() {
		return "CreditCard [cCardId=" + cCardId + ", cCardNumber=" + cCardNumber + ", cardType=" + cardType
				+ ", expDate=" + expDate + ", cvv=" + cvv + ", status=" + status + ", customer=" + customer + "]";
	}
}
