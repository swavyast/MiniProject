package com.ml.miniproject.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="shippingAddress")
public class ShippingAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long adId;
	@Column(length = 10)
	private String street;
	@Column(length = 40)
	private String locality;
	@Column(length = 40)
	private String city;
	@Column(length = 40)
	private String state;
	@Column(length = 40)
	private String country;
	@Column(length = 6)
	private int pincode;
	@OneToOne(mappedBy = "myAddress")
	private Order order;
	public ShippingAddress() {}
	public ShippingAddress(String street, String locality, String city, String state, String country, int pincode,
			Order order) {
		super();
		this.street = street;
		this.locality = locality;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.order = order;
	}
	public long getAdId() {
		return adId;
	}
	public void setAdId(long adId) {
		this.adId = adId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "ShippingAddress [adId=" + adId + ", street=" + street + ", locality=" + locality + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", pincode=" + pincode + ", order=" + order + "]";
	}
}
