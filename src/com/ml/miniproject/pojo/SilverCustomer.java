package com.ml.miniproject.pojo;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="silverCustomers")
@PrimaryKeyJoinColumn(name = "myCid", referencedColumnName = "cid")
public class SilverCustomer extends Customer{
	private String supportEmail;
	private double shippingCharges;
	private double discounts;
	private double handlingCharges;
	public SilverCustomer() {}
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
