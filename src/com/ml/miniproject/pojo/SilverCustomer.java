package com.ml.miniproject.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="silverCustomers")
@PrimaryKeyJoinColumn(name = "myCid")
public class SilverCustomer extends Customer{
	@Column(name = "supportEmail")
	private String supportEmail;
	@Column(name = "shippingCharges")
	private double shippingCharges;
	@Column(name = "scDiscounts")
	private double discounts;
	@Column(name = "handlingCharges")
	private double handlingCharges;
	public SilverCustomer() {}
	
	public SilverCustomer(String cname, String email, long phone, Date dob, String supportEmail, double shippingCharges,
			double discounts, double handlingCharges) {
		super(cname, email, phone, dob);
		this.supportEmail = supportEmail;
		this.shippingCharges = shippingCharges;
		this.discounts = discounts;
		this.handlingCharges = handlingCharges;
	}

	public SilverCustomer(String supportEmail, double shippingCharges, double discounts, double handlingCharges) {
		super();
		this.supportEmail = supportEmail;
		this.shippingCharges = shippingCharges;
		this.discounts = discounts;
		this.handlingCharges = handlingCharges;
	}
	public String getSupportEmail() {
		return supportEmail;
	}
	public void setSupportEmail(String supportEmail) {
		this.supportEmail = supportEmail;
	}
	public double getShippingCharges() {
		return shippingCharges;
	}
	public void setShippingCharges(double shippingCharges) {
		this.shippingCharges = shippingCharges;
	}
	public double getDiscounts() {
		return discounts;
	}
	public void setDiscounts(double discounts) {
		this.discounts = discounts;
	}
	public double getHandlingCharges() {
		return handlingCharges;
	}
	public void setHandlingCharges(double handlingCharges) {
		this.handlingCharges = handlingCharges;
	}
	@Override
	public String toString() {
		return "SilverCustomer [supportEmail=" + supportEmail + ", shippingCharges=" + shippingCharges + ", discounts="
				+ discounts + ", handlingCharges=" + handlingCharges + "]";
	}
}
