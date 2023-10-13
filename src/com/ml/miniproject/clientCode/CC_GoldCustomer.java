package com.ml.miniproject.clientCode;

import java.util.Date;
import java.util.HashSet;

import com.ml.miniproject.DAO.DAO_Factory;
import com.ml.miniproject.DAO.GoldCustomer_Dao;
import com.ml.miniproject.pojo.CreditCard;
import com.ml.miniproject.pojo.GoldCustomer;
import com.ml.miniproject.pojo.Order;

public class CC_GoldCustomer {
	public static void main(String[] args) {
		GoldCustomer_Dao gcdao=DAO_Factory.getGoldCustomer_Dao();
		GoldCustomer gc=new GoldCustomer();
		gc.setCid(0);
		gc.setCname("name");
		gc.setDob(new Date());
		gc.setEmail("email");
		gc.setEarlyAccess(false);
		gc.setPhone(0);
		gc.setSupportPhone(0);
		gc.setMyCards(new HashSet<CreditCard>());
		gc.setMyOrders(new HashSet<Order>());
		gc.setCashback(0);
		gc.setRpoints(0);
		gcdao.saveGoldCustomer(gc);
	}

}
