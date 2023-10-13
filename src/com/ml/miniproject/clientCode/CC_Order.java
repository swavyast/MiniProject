package com.ml.miniproject.clientCode;

import java.util.Date;
import java.util.HashSet;

import com.ml.miniproject.DAO.DAO_Factory;
import com.ml.miniproject.DAO.Order_Dao;
import com.ml.miniproject.pojo.Order;
import com.ml.miniproject.pojo.OrderItem;
import com.ml.miniproject.pojo.ShippingAddress;

public class CC_Order {
	public static void main(String[] args) {
		Order_Dao odao=DAO_Factory.getOrderDao();
		//Order Object
		Order order=new Order();
		//order.setCustomer(sc);
		//order.setCustomer(new SilverCustomer());
		order.setDeliveryDate(new Date());
		order.setMyAddress(new ShippingAddress());
		order.setMyOrderItems(new HashSet<OrderItem>());
		order.setOrderCost(100);
		order.setOrderDate(new Date());
		order.setOrderQuantity(1);
		order.setStatus("Order Placed");
		odao.saveOrder(order);
	}

}
