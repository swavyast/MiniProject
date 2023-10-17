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
	@Column(name="adId")
	private long adId;
	@Column(name="adStreet")
	private String street;
	@Column(name="adLocality")
	private String locality;
	@Column(name="adCity")
	private String city;
	@Column(name="adState")
	private String state;
	@Column(name="adCountry")
	private String country;
	@Column(name="adPincode")
	private int pincode;
	@OneToOne(mappedBy = "myAddress")
	private Order order;
	public ShippingAddress() {}
	
	public ShippingAddress(String street, String locality, String city, String state, String country, int pincode) {
		this.street = street;
		this.locality = locality;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}

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
