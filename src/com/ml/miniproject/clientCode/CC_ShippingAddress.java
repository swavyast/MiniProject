package com.ml.miniproject.clientCode;

import com.ml.miniproject.DAO.DAO_Factory;
import com.ml.miniproject.DAO.ShippingAddress_Dao;
import com.ml.miniproject.pojo.ShippingAddress;

public class CC_ShippingAddress {
	public static void main(String[] args) {
		ShippingAddress_Dao sadao = DAO_Factory.getShippingAddress_Dao();
		// Shipping Address Object
		ShippingAddress add = new ShippingAddress();
		add.setStreet("Street No-6");
		add.setLocality("Choura");
		add.setCity("Noida");
		add.setState("Uttar Pradesh");
		add.setCountry("India");
		add.setPincode(201301);
		//	add.setOrder(order);
		//	order.setMyAddress(add);
		sadao.saveShippingAddress(add);
	}
}
