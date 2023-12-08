package com.ml.miniproject.pojo;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="goldCustomers")
@PrimaryKeyJoinColumn(name = "mycid", referencedColumnName = "cid")
public class GoldCustomer extends Customer {
	private long supportPhone;
	private int rpoints;
	private double cashback;
	private boolean earlyAccess;
	public GoldCustomer() {}
	public GoldCustomer(long supportPhone, int rpoints, double cashback, boolean earlyAccess) {
		super();
		this.supportPhone = supportPhone;
		this.rpoints = rpoints;
		this.cashback = cashback;
		this.earlyAccess = earlyAccess;
	}
	public long getSupportPhone() {
		return supportPhone;
	}
	public void setSupportPhone(long supportPhone) {
		this.supportPhone = supportPhone;
	}
	public int getRpoints() {
		return rpoints;
	}
	public void setRpoints(int rpoints) {
		this.rpoints = rpoints;
	}
	public double getCashback() {
		return cashback;
	}
	public void setCashback(double cashback) {
		this.cashback = cashback;
	}
	public boolean isEarlyAccess() {
		return earlyAccess;
	}
	public void setEarlyAccess(boolean earlyAccess) {
		this.earlyAccess = earlyAccess;
	}
	@Override
	public String toString() {
		return "GoldCustomer [supportPhone=" + supportPhone + ", rpoints=" + rpoints + ", cashback=" + cashback
				+ ", earlyAccess=" + earlyAccess + "]";
	}
}
