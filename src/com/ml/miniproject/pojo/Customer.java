package com.ml.miniproject.pojo;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="myCstmrs")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cid;
	private String cname;
	private String email;
	private long phone;
	@Column(name="dateOfBirth")
	private Date dob;
	@OneToMany(mappedBy = "customer")
	private Set<CreditCard> myCards;
	@OneToMany(mappedBy = "customer")
	private Set<Order> myOrders;
	
	public Customer() {}

	public Customer(String cname, String email, long phone, Date dob, Set<CreditCard> myCards, Set<Order> myOrders) {
		super();
		this.cname = cname;
		this.email = email;
		this.phone = phone;
		this.dob = dob;
		this.myCards = myCards;
		this.myOrders = myOrders;
	}

	public long getCid() {
		return cid;
	}

	public void setCid(long cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Set<CreditCard> getMyCards() {
		return myCards;
	}

	public void setMyCards(Set<CreditCard> myCards) {
		this.myCards = myCards;
	}

	public Set<Order> getMyOrders() {
		return myOrders;
	}

	public void setMyOrders(Set<Order> myOrders) {
		this.myOrders = myOrders;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", email=" + email + ", phone=" + phone + ", dob=" + dob
				+ ", myCards=" + myCards + ", myOrders=" + myOrders + "]";
	}
}
