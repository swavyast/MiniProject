package com.ml.miniproject.clientCode;

import java.util.Date;
import java.util.HashSet;

import com.ml.miniproject.DAO.DAO_Factory;
import com.ml.miniproject.DAO.SilverCustomer_Dao;
import com.ml.miniproject.pojo.CreditCard;
import com.ml.miniproject.pojo.Order;
import com.ml.miniproject.pojo.SilverCustomer;

public class CC_SilverCustomer {
public static void main(String[] args) {
	SilverCustomer_Dao scdao=DAO_Factory.getSilverCustomer_Dao();
	//Silver Customer Object
	SilverCustomer sc=new SilverCustomer();
	sc.setCid(1L);
	sc.setCname("Prateek Raj Giri");
	sc.setDob(new Date(13_09_1992));
	sc.setEmail("pratekkgiri91@gmail.com");
	sc.setHandlingCharges(0);
	sc.setMyCards(new HashSet<CreditCard>());
	sc.setMyOrders(new HashSet<Order>());
	sc.setPhone(9911883675L);
	sc.setShippingCharges(0);
	sc.setSupportEmail("pratekkgiri91@gmail.com");
	scdao.saveSilverCustomer(sc);
}
}
