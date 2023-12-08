package com.ml.miniproject.pojo;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="shippingAddress")
public class ShippingAddress {
	private long adId;
	private String locality;
	private String city;
	private String state;
	private String country;
	private int pincode;
	@OneToOne
	private Order order;
}
